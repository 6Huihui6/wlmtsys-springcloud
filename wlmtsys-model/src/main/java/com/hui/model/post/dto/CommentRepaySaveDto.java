package com.hui.model.post.dto;

import lombok.Data;

@Data
public class CommentRepaySaveDto {

    /**
     * 评论id
     */
    private String commentId;

    /**
     * post id
     */
    private String postId;


    /**
     * 回复内容
     */
    private String content;
}