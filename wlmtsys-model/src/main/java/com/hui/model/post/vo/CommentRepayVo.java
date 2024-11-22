package com.hui.model.post.vo;

import com.hui.model.post.po.CommentRepay;
import lombok.Data;

@Data
public class CommentRepayVo extends CommentRepay {

    /**
     * 0：点赞
     * 1：取消点赞
     */
    private Short operation;
}