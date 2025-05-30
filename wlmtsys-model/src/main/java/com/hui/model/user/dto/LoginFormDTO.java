package com.hui.model.user.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "登录注册表单实体")
public class LoginFormDTO {
    @ApiModelProperty(value = "用户名", example = "admin", required = true)
    private  String username;
    @ApiModelProperty(value = "登录方式：1-密码登录; 2-验证码登录", example = "1", required = true)
    private Integer type;
    @ApiModelProperty(value = "验证码登录", example = "123456", required = false)
    private String code;
    @ApiModelProperty(value = "邮箱", example = "2222222222@qq.com")
    private String email;
    @ApiModelProperty(value = "手机号", example = "13800010001")
    private String cellPhone;
    @ApiModelProperty(value = "密码", example = "123", required = true)
    private String password;
    @ApiModelProperty(value = "7天免密登录", example = "true")
    private Boolean rememberMe = false;
}
