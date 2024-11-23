package com.hui.api.client.user;



import com.hui.api.client.user.fallback.UserClientFallback;
import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import com.hui.model.user.dto.UserDTO;
import com.hui.model.user.vos.UserDetailVO;
import com.hui.model.user.vos.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service", fallbackFactory = UserClientFallback.class)
public interface UserClient {

    /**
     * 根据手机号查询用户id
     * @param phone 手机号
     * @return 用户id
     */
    @GetMapping("/user/ids")
    Long exchangeUserIdWithPhone(@RequestParam("phone") String phone);

    /**
     * 登录接口
     * @param loginDTO 登录信息
     * @param isStaff 是否是外部员工
     * @return 用户详情
     */
    @PostMapping("/user/detail/{isStaff}")
    LoginUserDTO queryUserDetail(@RequestBody LoginFormDTO loginDTO, @PathVariable("isStaff") boolean isStaff);

    @PostMapping("/user/register")
    ResponseResult register(@RequestBody LoginFormDTO loginFormDTO);
    /**
     * 查询用户类型
     * @param id 用户id
     * @return 用户类型，0-普通学员，1-老师，2-其他员工
     */
    @GetMapping("/user/{id}/type")
    Integer queryUserType(@PathVariable("id") Long id);

    /**
     * <h1>根据id批量查询用户信息</h1>
     * @param ids 用户id集合
     * @return 用户集合
     */
    @GetMapping("/user/list")
    List<UserDetailVO> queryUserByIds(@RequestParam("ids") Iterable<Integer> ids);

    /**
     * 根据id查询单个学生信息
     * @param userId 用户id
     * @return 学生
     */
    @GetMapping("/user/one")
    UserVo queryUserById(@RequestParam("id") Integer userId);


}
