package com.hui.auth.service.impl;


import com.hui.auth.common.constants.JwtConstants;
import com.hui.auth.service.IAccountService;
import com.hui.auth.service.ICaptchaService;
import com.hui.auth.service.ILoginRecordService;
import com.hui.auth.util.JwtTool;
import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.exceptions.BadRequestException;
import com.hui.common.utils.BooleanUtils;
import com.hui.common.utils.WebUtils;
import com.hui.api.client.user.UserClient;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表，平台内所有用户的账号、密码信息 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2022-06-16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final JwtTool jwtTool;
    private final UserClient userClient;
    private final ILoginRecordService loginRecordService;
    private final ICaptchaService captchaService;




    private String generateToken(LoginUserDTO detail) {
        // 2.2.生成access-token
        String token = jwtTool.createToken(detail);
        // 2.3.生成refresh-token，将refresh-token的JTI 保存到Redis
        String refreshToken = jwtTool.createRefreshToken(detail);
        // 2.4.将refresh-token写入用户cookie，并设置HttpOnly为true
        int maxAge = BooleanUtils.isTrue(detail.getRememberMe()) ?
                (int) JwtConstants.JWT_REMEMBER_ME_TTL.toSeconds() : -1;
        WebUtils.cookieBuilder()
                .name(detail.getRoleId() == 2 ? JwtConstants.REFRESH_HEADER : JwtConstants.ADMIN_REFRESH_HEADER)
                .value(refreshToken)
                .maxAge(maxAge)
                .httpOnly(true)
                .build();
        return token;
    }



    @Override
    public void logout() {
        // 删除jti
        jwtTool.cleanJtiCache();
        // 删除cookie
        WebUtils.cookieBuilder()
                .name(JwtConstants.REFRESH_HEADER)
                .value("")
                .maxAge(0)
                .httpOnly(true)
                .build();
    }

    /**
     */
    @Override
    public String refreshToken(String refreshToken) {
        // 1.校验refresh-token,校验JTI
       LoginUserDTO userDTO = jwtTool.parseRefreshToken(refreshToken);
        // 2.生成新的access-token、refresh-token
        return generateToken(userDTO);
    }

    /**
     * 发送验证码
     *
     * @param email
     */
    @Override
    public void generateCaptcha(String email) {
        captchaService.generateCaptcha(email);
    }
    /**
     * 注册
     *
     * @param loginFormDTO
     */
    @Override
    public ResponseResult registerByEmail(LoginFormDTO loginFormDTO) {
        // 1.校验验证码
        if (loginFormDTO == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        String captcha = loginFormDTO.getCode();
        boolean isRegiter = captchaService.verifyCaptcha(loginFormDTO.getEmail(), captcha);
        if (!isRegiter) {
            return ResponseResult.errorResult(AppHttpCodeEnum.CODE_ERROR);
        }
        // 2.调用用户服务注册接口
        userClient.register(loginFormDTO);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }




    @Override
    public String login(LoginFormDTO loginDTO, boolean isStaff) {
        // 1.查询并校验用户信息
        LoginUserDTO detail = userClient.queryUserDetail(loginDTO, isStaff);
        if (detail == null) {
            throw new BadRequestException("登录信息有误");
        }

        // 2.基于JWT生成登录token
        // 2.1.设置记住我标记
        detail.setRememberMe(loginDTO.getRememberMe());
        // 2.2.生成token
        String token = generateToken(detail);

        // 3.计入登录信息表
        loginRecordService.loginSuccess(loginDTO.getEmail(), detail.getUserId());
        // 4.返回结果
        return token;
    }

}
