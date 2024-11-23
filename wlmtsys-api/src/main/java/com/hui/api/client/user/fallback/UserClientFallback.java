package com.hui.api.client.user.fallback;



import com.hui.api.client.user.UserClient;
import com.hui.common.domain.dto.LoginUserDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.user.dto.LoginFormDTO;
import com.hui.model.user.dto.UserDTO;
import com.hui.model.user.vos.UserDetailVO;
import com.hui.model.user.vos.UserVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collections;
import java.util.List;

@Slf4j
public class UserClientFallback implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        log.error("查询用户服务出现异常", cause);
        return new UserClient() {
            @Override
            public Long exchangeUserIdWithPhone(String phone) {
                return null;
            }

            @Override
            public LoginUserDTO queryUserDetail(LoginFormDTO loginDTO, boolean isStaff) {
                return null;
            }

            @Override
            public Integer queryUserType(Long id) {
                return null;
            }

            @Override
            public List<UserDetailVO> queryUserByIds(Iterable<Integer> ids) {
                return Collections.emptyList();
            }

            @Override
            public UserVo queryUserById(Integer userId) {
                return null;
            }

            @Override
            public ResponseResult register(@RequestBody LoginFormDTO loginFormDTO) {
                return null;
            }
        };
    }
}
