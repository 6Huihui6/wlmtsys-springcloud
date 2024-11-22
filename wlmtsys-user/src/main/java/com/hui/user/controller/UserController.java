package com.hui.user.controller;


import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import com.hui.model.user.dto.UserDTO;
import com.hui.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Slf4j
@RestController
@Api(tags = "用户模块")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private  final IUserService usersService;

    /**
     * 登录结构
     * @param loginDTO 登录表单
     * @param isStaff 是否是后台登录
     * @return 登录用户信息
     */
    @ApiIgnore
    @PostMapping("/detail/{isStaff}")
    public LoginUserDTO queryUserDetail(
            @Valid @RequestBody LoginFormDTO loginDTO, @PathVariable("isStaff") boolean isStaff) {
        return usersService.queryUserDetail(loginDTO, isStaff);
    }

//    @ApiIgnore
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResponseResult register(@Valid @RequestBody LoginFormDTO loginFormDTO){
        return usersService.register(loginFormDTO);
    };

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/one")
    public UserDTO queryUserById(@RequestParam("id") Long id){
        return usersService.queryUserById(id);
    }

}
