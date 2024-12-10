package com.hui.model.post.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentRepayLikeDto {

    /**
     * 回复id
     */
    private String commentRepayId;

    /**
     * 0：点赞
     * 1：取消点赞
     */
    @ApiModelProperty(value = "0：点赞 1：取消点赞")
    private Short operation;
}