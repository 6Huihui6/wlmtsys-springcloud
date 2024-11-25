package com.hui.info.service;

import com.hui.model.info.dtos.ApplicationsDto;
import com.hui.model.info.dtos.InterviewInvitationDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Applications;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.model.info.query.ApplicatePageQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-24
 */
public interface IApplicationsService extends IService<Applications> {

    /**
     * 判断是否正在招聘
     */
    ResponseResult isRecruiting();



    /**
     * 获取招聘信息
     */
    ResponseResult recruitingInfo(ApplicatePageQuery query);

    /**
     * 申请加入
     */
    ResponseResult apply(ApplicationsDto dto);

    /**
     * 申请状态
     * */
    ResponseResult applyStatus();

    /**
     * 处理申请
     * */
    ResponseResult handleApply(Integer applicationId, Integer status);

    /**
     * 删除申请
     */
    ResponseResult deleteApply(Integer applicationId);


}
