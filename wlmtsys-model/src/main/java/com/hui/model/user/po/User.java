package com.hui.model.user.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.hui.model.user.enums.UserStatus;
import com.hui.model.user.enums.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String salt;
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
    private String image;
    private Integer sex;
    /**
     * 账户状态：0-禁用，1-正常
     */
    private UserStatus status;
    /**
     * 用户类型：1-其他员工, 2-普通学员，3-老师
     */
    private UserType type;
    private LocalDateTime createTime;
    private String openid;
    private LocalDateTime updateTime;


}
