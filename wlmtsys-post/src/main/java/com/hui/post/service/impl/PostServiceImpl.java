package com.hui.post.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.common.utils.UserContext;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.mess.ArticleVisitStreamMess;
import com.hui.model.post.dto.CollectBehaviorDto;
import com.hui.model.post.dto.LikesBehaviorDto;
import com.hui.model.post.dto.PageDto;
import com.hui.model.post.dto.PostDto;
import com.hui.model.post.po.Post;
import com.hui.post.constants.BehaviorConstants;
import com.hui.post.mapper.PostMapper;
import com.hui.post.service.IImagesService;
import com.hui.post.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.utils.thread.AppThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    private final IImagesService imagesService;
    private final StringRedisTemplate redisTemplate ;
    /**
     * 新增或编辑帖子
     *
     */
    @Override
    public ResponseResult addOrEditPost(PostDto dto) {
        //参数校验
        if (dto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Integer userId = Math.toIntExact(UserContext.getUser());
        Post post = BeanUtils.copyBean(dto, Post.class);
        if (dto.getPostId() == null){
            //新增
            post.setUserId(userId);
            post.setCreatedTime(LocalDateTime.now());
            boolean save = save(post);
            if (!save) {
                return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
            }
            //保存图片
            imagesService.saveImages(dto.getImage(), post.getPostId());
        }else{
            //编辑
            boolean update = updateById(post);
            if (!update) {
                return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
            }
            //保存图片
            imagesService.saveImages(dto.getImage(), post.getPostId());
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 删除帖子
     *
     */
    @Override
    public ResponseResult deletePost(Integer postId) {
        if (postId == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        removeById(postId);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 获取帖子列表
     *
     * @param pageDto
     */
    @Override
    public ResponseResult getPostList(PageDto pageDto) {
        //校验参数
        Page<Post> page=lambdaQuery().eq(pageDto.getContent()!=null,Post::getContent,pageDto.getContent())
                .orderByDesc(pageDto.getOrder()==2,Post::getHeat)
                .orderByDesc(pageDto.getOrder()==1,Post::getPublishTime)
                .page(new Page<>(pageDto.getPageNo(),pageDto.getPageSize()));
        List<Post> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return ResponseResult.okResult(PageDTO.empty(page));
        }
        return ResponseResult.okResult(PageDTO.of(page,records));
    }

    /**
     * 保存评论数
     *
     * @param articleVisitStreamMess
     */
    @Override
    public void saveCommentCount(ArticleVisitStreamMess articleVisitStreamMess) {
        if (articleVisitStreamMess == null || articleVisitStreamMess.getPostId() == null) {
            return;
        }
        Post post = getById(articleVisitStreamMess.getPostId());
        if (post == null) {
            return;
        }
        post.setComment(post.getComment() + 1);
        updateById(post);
    }
    /**
     * 点赞
     *
     * @param dto
     */
    @Override
    public ResponseResult like(LikesBehaviorDto dto) {
        // 1.基于前端的参数，判断是执行点赞还是取消点赞
        boolean success = dto.getOperation()==1 ? likes(dto) : unlike(dto);
        if (!success) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }
        // 3.如果执行成功，统计点赞总数
        Long likedTimes = redisTemplate.opsForSet()
                .size(BehaviorConstants.LIKE_BEHAVIOR + dto.getPostsId());
        // 4.更新数据库中的点赞数
        int likes = likedTimes.intValue();
        lambdaUpdate().set(Post::getLikes, likes).eq(Post::getPostId, dto.getPostsId()).update();
        String key = BehaviorConstants.LIKE_BEHAVIOR + BehaviorConstants.TOTAL;
        // 4.缓存点总数到Redis
        redisTemplate.opsForZSet().add(
                key,
                dto.getPostsId().toString(),
                likedTimes
        );
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 收藏
     *
     * @param dto
     */
    @Override
    public ResponseResult collect(CollectBehaviorDto dto) {
        // 1.基于前端的参数，判断是执行收藏还是取消收藏
        boolean success = dto.getOperation()==1 ? collects(dto) : uncollect(dto);
        if (!success) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }
        // 3.如果执行成功，统计收藏总数
        Long collectTimes = redisTemplate.opsForSet()
                .size(BehaviorConstants.COLLECTION_BEHAVIOR + dto.getPostsId());
        // 4.更新数据库中的收藏数
        int collects = collectTimes.intValue();
        lambdaUpdate().set(Post::getCollection, collects).eq(Post::getPostId, dto.getPostsId()).update();
        String key = BehaviorConstants.COLLECTION_BEHAVIOR + BehaviorConstants.TOTAL;
        // 4.缓存点总数到Redis
        redisTemplate.opsForZSet().add(
                key,
                dto.getPostsId().toString(),
                collectTimes
        );
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }



    private boolean uncollect(CollectBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.COLLECTION_BEHAVIOR + dto.getPostsId();
        // 3.执行SREM命令
        Long result = redisTemplate.opsForSet().remove(key, userId.toString());
        // 4.删除收藏记录
//        collectRecordService.deleteCollectRecord(dto);
        return result != null && result > 0;
    }

    private boolean collects(CollectBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.COLLECTION_BEHAVIOR + dto.getPostsId();
        // 3.执行SADD命令
        Long result = redisTemplate.opsForSet().add(key, userId.toString());
        // 4.保存收藏记录
//        collectRecordService.saveCollectRecord(dto);
        return result != null && result > 0;
    }

    private boolean likes(@NotNull LikesBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.LIKE_BEHAVIOR + dto.getPostsId();
        // 3.执行SADD命令
        Long result = redisTemplate.opsForSet().add(key, userId.toString());
        return result != null && result > 0;
    }
    private boolean unlike(@NotNull LikesBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.LIKE_BEHAVIOR + dto.getPostsId();
        // 3.执行SREM命令
        Long result = redisTemplate.opsForSet().remove(key, userId.toString());
        return result != null && result > 0;
    }

    /**
     * 获取帖子详情
     *
     * @param postId
     */
    @Override
    public ResponseResult getPostDetail(Integer postId) {
        return null;
    }

}
