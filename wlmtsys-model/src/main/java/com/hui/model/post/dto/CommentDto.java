package com.hui.model.post.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    /**
     * 文章id
     */
    private Long postId;

    // 最小时间
    private Date minDate;

    //是否是首页
    private Short index;

}