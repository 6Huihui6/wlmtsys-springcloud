package com.hui.user.service.impl;


import cn.hutool.core.util.StrUtil;
import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.exceptions.BadRequestException;
import com.hui.common.exceptions.ForbiddenException;
import com.hui.common.utils.AssertUtils;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import com.hui.model.user.enums.UserStatus;
import com.hui.model.user.po.User;
import com.hui.model.user.po.UserDetail;
import com.hui.user.mapper.UserMapper;
import com.hui.user.service.IUserDetailService;
import com.hui.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.hui.user.constant.UserConstants.*;
import static com.hui.user.constant.UserErrorInfo.Msg.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final StringRedisTemplate stringRedisTemplate;
    private final PasswordEncoder passwordEncoder;
    private final IUserDetailService detailService;

    /**
     * 登录
     *
     * @param loginDTO
     * @param isStaff
     * @return
     */
    @Override
    public LoginUserDTO queryUserDetail(LoginFormDTO loginDTO, boolean isStaff) {
        log.info(passwordEncoder.encode(DEFAULT_PASSWORD));
        // 1.判断登录方式
        Integer type = loginDTO.getType();
        User user = null;
        // 2.用户名和密码登录
        if (type == 1) {
            user = loginByPw(loginDTO);
        }
        // 3.验证码登录
        if (type == 2) {
            user = loginByVerifyCode(loginDTO.getEmail(), loginDTO.getCode());
        }
        // 4.错误的登录方式
        if (user == null) {
            throw new BadRequestException(ILLEGAL_LOGIN_TYPE);
        }
        // 5.判断用户类型与登录方式是否匹配
//        if (isStaff ^ user.getType() != INTERNAL_USER) {
//            throw new BadRequestException(isStaff ? "非管理端用户" : "非学生端用户");
//        }
        // 6.封装返回
        LoginUserDTO userDTO = new LoginUserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setRoleId(handleRoleId(user));
        return userDTO;
    }

    /**
     * 注册
     *
     * @param loginFormDTO
     * @return
     */
    @Override
    public ResponseResult register(LoginFormDTO loginFormDTO) {
        // 1.数据校验
        String email = loginFormDTO.getEmail();
        String password = loginFormDTO.getPassword();
        if (StrUtil.isBlank(email) && StrUtil.isBlank(password)) {
            throw new BadRequestException(INVALID_UN);
        }
        // 2.判断用户是否存在
        User user = lambdaQuery()
               .eq(StrUtil.isNotBlank(email), User::getEmail, email)
               .one();
        if (user != null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }

        // 3.保存用户信息
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        save(newUser);
        // 4.保存用户详情
        UserDetail detail = new UserDetail();
        detail.setUserId(Math.toIntExact(newUser.getId()));
        detailService.save(detail);
        // 5.封装返回
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
//        return "success";
    }

    public User loginByVerifyCode(String email, String code) {
        // 1.校验验证码
        boolean isRight = verifyCaptcha(email, code);
        if (!isRight) {
            throw new BadRequestException(INVALID_CODE);
        }
        // 2.根据手机号查询
        User user = lambdaQuery().eq(User::getEmail, email).one();
        if (user == null) {
            throw new BadRequestException(PHONE_NOT_EXISTS);
        }
        // 3.校验是否禁用
        if (user.getStatus() == UserStatus.BANNED) {
            throw new ForbiddenException(USER_FROZEN);
        }
        return user;
    }
    // 校验验证码
    public boolean verifyCaptcha(String email, String inputCaptcha) {
        // 从Redis中获取验证码
        String storedCaptcha = stringRedisTemplate.opsForValue().get("captcha:" + email);
        if (storedCaptcha == null || !storedCaptcha.equals(inputCaptcha)) {
            return false;
        }
        // 验证成功后删除验证码
        stringRedisTemplate.delete("captcha:" + email);
        return true;
    }
    public User loginByPw(LoginFormDTO loginDTO) {
        // 1.数据校验
        String email = loginDTO.getEmail();
        String cellPhone = loginDTO.getCellPhone();
        if (StrUtil.isBlank(email) && StrUtil.isBlank(cellPhone)) {
            throw new BadRequestException(INVALID_UN);
        }
        // 2.根据用户名或手机号查询
        User user = lambdaQuery()
                .eq(StrUtil.isNotBlank(email), User::getEmail, email)
                .eq(StrUtil.isNotBlank(cellPhone), User::getCellPhone, cellPhone)
                .one();
        AssertUtils.isNotNull(user, INVALID_UN_OR_PW);
        // 3.校验是否禁用
        if (user.getStatus() == UserStatus.BANNED) {
            throw new ForbiddenException(USER_FROZEN);
        }
        String encode = passwordEncoder.encode(loginDTO.getPassword());
        log.info(encode);
        // 4.校验密码
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new BadRequestException(INVALID_UN_OR_PW);
        }

        return user;
    }
    private Long handleRoleId(User user) {
        Long roleId = 0L;
        switch (user.getType()) {
            case INTERNAL_USER:
                roleId =INTERNAL_USER_ID  ;
                break;
            case EXTERNAL_USER:
                roleId = EXTERNAL_USER_ID;
                break;
            case STAFF:
                UserDetail detail = detailService.getById(user.getId());
                roleId = detail.getRoleId();
                break;
        }
        return roleId;
    }

}
