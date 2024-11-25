package com.hui.post.service;

import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.mess.ArticleVisitStreamMess;
import com.hui.model.post.dto.CollectBehaviorDto;
import com.hui.model.post.dto.LikesBehaviorDto;
import com.hui.model.post.dto.PageDto;
import com.hui.model.post.dto.PostDto;
import com.hui.model.post.po.Post;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
public interface IPostService extends IService<Post> {

    /**
     * 新增或编辑帖子
     */
    ResponseResult addOrEditPost(PostDto dto);

    /**
     * 删除帖子
     */
    ResponseResult deletePost(Integer postId);

    /**
     * 获取帖子列表
     */
    ResponseResult getPostList(PageDto pageDto);

    /**
     * 保存评论数
     */
    void saveCommentCount(ArticleVisitStreamMess articleVisitStreamMess);

    /**
     * 点赞
     */
    ResponseResult like(LikesBehaviorDto dto);

    /**
     * 收藏
     */
    ResponseResult collect(CollectBehaviorDto dto);



    /**
     * 获取帖子详情
     */
    ResponseResult getPostDetail(Integer postId);

    /**
     * 保存浏览数
     */
    void saveViewCount(ArticleVisitStreamMess articleVisitStreamMess);
}
