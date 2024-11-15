package com.hui.model.info.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "WxUserDTO", description = "微信用户信息DTO")
public class WxUserDTO {

    @Schema(description = "微信用户openid", required = true)
    private String openid;

    @Schema(description = "微信用户昵称")
    private String nickName;

    @Schema(description = "微信用户头像")
    private String avatarUrl;
}