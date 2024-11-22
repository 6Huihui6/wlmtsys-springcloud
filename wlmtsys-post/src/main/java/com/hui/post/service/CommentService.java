package com.hui.post.service;


import com.hui.model.post.dto.CommentDto;
import com.hui.model.post.dto.CommentLikeDto;
import com.hui.model.post.dto.CommentSaveDto;
import com.hui.model.info.dtos.ResponseResult;

public interface CommentService {

    /**
     * 保存评论
     * @param dto
     * @return
     */
    public ResponseResult saveComment(CommentSaveDto dto);


    /**
     * 点赞
     * @param dto
     * @return
     */
    public ResponseResult like(CommentLikeDto dto);

    /**
     * 加载评论列表
     * @param dto
     * @return
     */
    public ResponseResult findByArticleId(CommentDto dto);


}
