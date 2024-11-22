package com.hui.model.post.dto;


import com.hui.model.annotation.IdEncrypt;
import lombok.Data;

@Data
public class CommentSaveDto {

    /**
     * 文章id
     */
    @IdEncrypt
    private Long postId;

    /**
     * 评论内容
     */
    private String content;
}