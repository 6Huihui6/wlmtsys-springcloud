package com.hui.model.info.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "UserVO", description = "用户视图对象")
public class UserLoginVO {

    @Schema(description = "用户ID")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "openid")
    private String openid;

    @Schema(description = "用户token")
    private String token;
}