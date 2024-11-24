package com.hui.user.controller;


import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import com.hui.model.user.dto.UserDTO;
import com.hui.model.user.po.UserDetail;
import com.hui.model.user.vos.UserDetailVO;
import com.hui.model.user.vos.UserVo;
import com.hui.user.service.IUserDetailService;
import com.hui.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

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
    private  final IUserDetailService detailService;

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
    public UserVo queryUserById(@RequestParam("id") Integer id){
        return usersService.queryUserById(id);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/current")
    public ResponseResult<UserVo> getCurrentLoginUser(){
        return usersService.getCurrentLoginUser();
    }

    @ApiOperation(value = "根据批量id获取用户信息")
    @GetMapping("/list")
    public List<UserDetailVO> queryUserByIds(
            @ApiParam("用户id的列表") @RequestParam("ids") List<Integer> ids){
        if(CollUtils.isEmpty(ids)){
            return CollUtils.emptyList();
        }
        // 1.查询列表
        List<UserDetail> list = detailService.queryByIds(ids);
        // 2.转换
        return BeanUtils.copyList(list, UserDetailVO.class, (d, u) -> u.setType(d.getType().getValue()));
    }

    @ApiOperation(value = "修改用户信息")
    @PutMapping("/update")
    public ResponseResult updateUser(@Valid @RequestBody UserDTO userDTO){
        return usersService.updateUser(userDTO);
    }

}
