package com.hui.model.post.vo;

import com.hui.model.post.po.Comment;
import lombok.Data;

@Data
public class CommentVo extends Comment {

    /**
     * 0：点赞
     * 1：取消点赞
     */
    private Short operation;
}
