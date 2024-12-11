package com.hui.model.post.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentLikeDto {

    /**
     * 评论id
     */
    private String commentId;

    /**
     * 0：点赞
     * 1：取消点赞
     */
    @ApiModelProperty(value = "0：点赞 1：取消点赞", example = "0")
    private Short operation;
}