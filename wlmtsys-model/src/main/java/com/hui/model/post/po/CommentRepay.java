package com.hui.model.post.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * APP评论回复信息
 */
@Data
@Document("comment_repay")
public class CommentRepay {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * postId
     */
    private String postId;

    /**
     * 用户ID
     */
    private Integer authorId;

    /**
     * 用户昵称
     */
    private String authorName;

    /**
     * 评论id
     */
    private String commentId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 点赞数
     */
    private Integer likes;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 作者头像
     */
    private String image;

}