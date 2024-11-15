package com.hui.model.info.dtos;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录表单实体")
public class AdUserDto {

    /**
     * 用户名
     */
    @Schema(title = "登录用户名", description = "管理员登录使用的用户名")
    @TableField("name")
    private String name;


    /**
     * 密码
     */
    @Schema(title = "密码", description = "登录使用的密码", required = true)
    private String password;
}