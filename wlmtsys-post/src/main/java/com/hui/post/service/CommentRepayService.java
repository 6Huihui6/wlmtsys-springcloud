package com.hui.post.service;


import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.dto.CommentRepayDto;
import com.hui.model.post.dto.CommentRepayLikeDto;
import com.hui.model.post.dto.CommentRepaySaveDto;

/**
 * 评论回复
 */
public interface CommentRepayService {

    /**
     * 查看更多回复内容
     */
    ResponseResult loadCommentRepay(CommentRepayDto dto);

    /**
     * 保存回复
     */
    ResponseResult saveCommentRepay(CommentRepaySaveDto dto);

    /**
     * 点赞回复的评论
     */
    ResponseResult saveCommentRepayLike(CommentRepayLikeDto dto);
}