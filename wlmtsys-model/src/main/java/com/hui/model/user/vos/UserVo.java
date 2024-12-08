package com.hui.model.user.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hui.model.user.enums.UserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="")
public class UserVo implements Serializable {

    private static final Integer serialVersionUID = 1;

    @ApiModelProperty(value = "关联用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户类型：1-内部人员, 2-外部人员，3-管理员")
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
    private Integer roleId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建者id")
    private Integer creater;

    @ApiModelProperty(value = "更新者id")
    private Integer updater;

    @ApiModelProperty(value = "部门id")
    private Integer depId;
    
    /**
     * 用户名
     */
    private String email;
    private String username;
    /**
     * 手机号
     */
    private String cellPhone;
    private String password;
    /**
     * 账户状态：0-禁用，1-正常
     */
    private UserStatus status;

    private String openid;



}
