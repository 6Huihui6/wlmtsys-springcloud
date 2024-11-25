package com.hui.info.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.api.client.user.UserClient;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.common.utils.UserContext;
import com.hui.model.info.dtos.ApplicationsDto;
import com.hui.model.info.dtos.InterviewInvitationDTO;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Applications;
import com.hui.info.mapper.ApplicationsMapper;
import com.hui.info.service.IApplicationsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.model.info.query.ApplicatePageQuery;
import com.hui.model.info.vo.ApplicationsStatusVo;
import com.hui.model.user.vos.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-24
 */
@Service
@RequiredArgsConstructor
public class ApplicationsServiceImpl extends ServiceImpl<ApplicationsMapper, Applications> implements IApplicationsService {

    /**
     * 判断是否正在招聘
     */
    private  final UserClient userClient;
    private final JavaMailSender javaMailSender; //可直接注入邮件发送的对象
    @Value("${spring.mail.username}") //动态获取配置文件中 发送邮件的账户
    private String sendemail;


    @Override
    public ResponseResult isRecruiting() {
        ApplicationsStatusVo applicationsStatusVo = new ApplicationsStatusVo();
        Applications applications = getById(1);
        if (applications.getStatus()!= 0) {
            applicationsStatusVo.setStatus(1);
        } else {
            applicationsStatusVo.setStatus(0);
        }
        return ResponseResult.okResult(applicationsStatusVo);
    }



    /**
     * 获取招聘信息
     *
     * @param query
     */
    @Override
    public ResponseResult recruitingInfo(ApplicatePageQuery query) {
        Page<Applications> page = lambdaQuery()
                .like(query.getKeyword() != null, Applications::getEmail, query.getKeyword())
                .like(query.getKeyword() != null, Applications::getUsername, query.getKeyword())
                .eq(query.getStatus() != null, Applications::getStatus, query.getStatus())
                .page(query.toMpPageDefaultSortByCreateTimeDesc());
        List<Applications> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return ResponseResult.okResult(PageDTO.empty(page));
        }
        return ResponseResult.okResult(PageDTO.of(page, records));
    }

    /**
     * 申请加入
     *
     * @param dto
     */
    @Override
    public ResponseResult apply(ApplicationsDto dto) {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Applications applications = BeanUtils.copyBean(dto, Applications.class);
        applications.setUserId(Math.toIntExact(userId));
        UserVo userVo = userClient.queryUserById(Math.toIntExact(userId));
        applications.setEmail(userVo.getEmail());
        applications.setUsername(userVo.getUsername());
        save(applications);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 申请状态
     */
    @Override
    public ResponseResult applyStatus() {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Applications applications = getById(userId);
        return ResponseResult.okResult(applications);
    }

    /**
     * 处理申请
     *
     * @param applicationId
     */
    @Override
    public ResponseResult handleApply(Integer applicationId,Integer status) {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Applications applications = getById(applicationId);
        if (applications == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        applications.setUpdateId(Math.toIntExact(userId));
        applications.setStatus(status);
        updateById(applications);
        //发送邮件通知
        InterviewInvitationDTO interviewInvitationDTO = new InterviewInvitationDTO();
        interviewInvitationDTO.setEmail(applications.getEmail());
        interviewInvitationDTO.setIntervieweeName(applications.getUsername());
        interviewInvitationDTO.setInterviewDateTime(LocalDateTime.now());
        interviewInvitationDTO.setStatus(status);
        interviewInvitationDTO.setCompanyName("未来媒体实验室");
        interviewInvitationDTO.setCompanyUrl("https://wlmtsys.com");
        sendCaptchaEmail(interviewInvitationDTO);
        return ResponseResult.okResult(applications);
    }
    /**
     * 发送邮件
     */
    void sendCaptchaEmail(InterviewInvitationDTO invitationDTO){
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendemail);
        message.setTo(invitationDTO.getEmail());
        //邮件标题
        message.setSubject("【未来媒体实验室】");
//        2为已通过，3为未通过
        if(invitationDTO.getStatus() == 2){
            message.setText("主题：面试邀请\n\n" +
                    "亲爱的 " + invitationDTO.getIntervieweeName() + "，\n\n" +
                    "您好！\n\n" +
                    "我们很高兴地通知您，您的申请已经通过了我们的初步筛选。\n" +
                    "您的资质和经验给我们留下了深刻的印象，我们诚挚地邀请您参加面试环节。\n\n" +
                    "具体时间和地点等后续信息，请多多关注我们的官方网站。\n\n" +
                    "同时，请您留意我们的官方公众号，我们会在您收到确认邮件后告知您。\n\n" +
                    "请在收到此邮件后48小时内回复此邮件，以便我们做出相应的安排 ！\n\n" +
                    "再次感谢您对 " + invitationDTO.getCompanyName() + " 的兴趣，我们期待着与您进一步交流。\n\n" +
                    "(此邮件为系统自动发送)\n\n"+
                    "祝好，\n\n" +
                    invitationDTO.getCompanyName() + "\n" +
                    invitationDTO.getCompanyUrl());
        }else{
            message.setText("主题：面试回馈\n\n" +
                    "亲爱的 " + invitationDTO.getIntervieweeName() + "，\n\n" +
                    "您好！\n\n" +
                    "很抱歉通知您，您的申请未能通过我们的初步筛选。\n" +
                    "我们鼓励您继续追求您的激情和目标，并探索其他可能的机会。\n\n" +
                    "如果您有任何疑问，请随时联系我们。\n\n" +
                    "祝好，再次感谢您给予我们的信任和机会。祝您在未来的学习和生活中一切顺利。(此邮件为系统自动发送)\n\n" +
                    "(此邮件为系统自动发送) \n\n"+
                    invitationDTO.getCompanyName() + "\n" +
                    invitationDTO.getCompanyUrl());
        }
        //发送邮件
        javaMailSender.send(message);
    }
    /**
     * 删除申请
     *
     * @param applicationId
     */
    @Override
    public ResponseResult deleteApply(Integer applicationId) {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        removeById(applicationId);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
