package com.hui.model.user.dto;


import com.hui.common.constants.RegexConstants;
import com.hui.model.user.enums.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
public class PhoneLoginDTO implements Serializable {


    @ApiModelProperty(value = "手机", example = "13890011009")
    @Pattern(regexp = RegexConstants.PHONE_PATTERN, message = "手机号格式错误")
    private String Phone;
    @ApiModelProperty(value = "用户角色")
    @NotNull
    private UserRole role;

    @ApiModelProperty(value = "邮箱")
    @Email
    private String email;

    @ApiModelProperty(value = "密码")
    @NotNull
    private String password;

}
