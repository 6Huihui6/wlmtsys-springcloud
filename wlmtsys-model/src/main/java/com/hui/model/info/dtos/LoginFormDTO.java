package com.hui.model.info.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(name = "LoginFormDTO", description = "登录表单实体",required = true)
public class LoginFormDTO {
    @Schema(description = "验证码", required = false)
    private String code;
    @Schema(description = "用户名", required = false)
    private String username;
    @Schema(description = "手机号", required = false)
    private String phone;
    @Schema(description = "密码", required = false)
    private String password;
    @Schema(description = "微信头像", required = false)
    private String avatarurl;
}
