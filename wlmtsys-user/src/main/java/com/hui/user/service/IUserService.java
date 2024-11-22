package com.hui.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import com.hui.model.user.dto.UserDTO;
import com.hui.model.user.po.User;

import javax.validation.Valid;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @param loginDTO
     * @param isStaff
     * @return
     */
    LoginUserDTO queryUserDetail(@Valid LoginFormDTO loginDTO, boolean isStaff);

    /**
     * 注册
     * @param loginFormDTO
     * @return
     */
    ResponseResult register(LoginFormDTO loginFormDTO);

    UserDTO queryUserById(Long id);
}
