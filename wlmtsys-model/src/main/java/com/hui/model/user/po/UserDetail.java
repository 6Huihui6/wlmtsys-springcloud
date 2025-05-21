package com.hui.model.user.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.hui.model.user.enums.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教师详情表
 * </p>
 *
 * @author hui
 * @since 2024-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_detail")
@ApiModel(value="UserDetail对象", description="教师详情表")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户类型：1-员工, 2-普通学员，3-老师")
    private UserType type;

    private String username;

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

    @ApiModelProperty(value = "部门id，1为管理部，2为运营部，3为技术部，4为指导老师")
    private Long depId;


}
