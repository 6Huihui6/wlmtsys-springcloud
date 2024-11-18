package com.hui.auth.service;
import com.hui.model.user.dto.LoginFormDTO;

/**
 * <p>
 * 账号表，平台内所有用户的账号、密码信息 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-06-16
 */
public interface IAccountService {

    String login(LoginFormDTO loginFormDTO, boolean isStaff);

    void logout();

    String refreshToken(String refreshToken);
}