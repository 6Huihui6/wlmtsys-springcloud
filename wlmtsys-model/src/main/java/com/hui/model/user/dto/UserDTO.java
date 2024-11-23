package com.hui.model.user.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.hui.common.constants.RegexConstants;
import com.hui.common.validate.annotations.EnumValid;
import com.hui.model.user.enums.UserRole;
import com.hui.model.user.enums.UserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "用户详情")
public class UserDTO {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户类型：1-员工, 2-普通学员，3-老师")
    private Integer type;

    @ApiModelProperty(value = "性别：0-男性，1-女性")
    private Integer gender;

    @ApiModelProperty(value = "头像地址")
    private String image;


    @ApiModelProperty(value = "QQ号码")
    private String qq;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "岗位")
    private String job;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String district;

    @ApiModelProperty(value = "个人介绍")
    private String intro;

    @ApiModelProperty(value = "形象照地址")
    private String photo;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建者id")
    private Long creater;

    @ApiModelProperty(value = "更新者id")
    private Long updater;

    @ApiModelProperty(value = "部门id")
    private Long depId;

    private String salt;

    /**
     * 手机号
     */
    private String cellPhone;
    private String password;
    private Integer sex;
    /**
     * 账户状态：0-禁用，1-正常
     */
    private UserStatus status;

    private String openid;


    @ApiModelProperty(value = "手机", example = "13890011009")
    @Pattern(regexp = RegexConstants.PHONE_PATTERN, message = "手机号格式错误")
    private String Phone;

    @ApiModelProperty(value = "用户名", example = "13800010004")
    private String username;
    @ApiModelProperty(value = "用户角色")
    @NotNull
    private UserRole role;

    @ApiModelProperty(value = "邮箱")
    @Email
    private String email;


}
