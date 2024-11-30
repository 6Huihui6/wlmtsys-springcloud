package com.hui.learn.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.api.client.user.UserClient;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.UserContext;
import com.hui.model.common.constants.BehaviorConstants;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.learn.dto.LCollectBehaviorDto;
import com.hui.model.learn.dto.LLikesBehaviorDto;
import com.hui.model.learn.dto.LearningDto;
import com.hui.model.learn.po.Learning;
import com.hui.learn.mapper.LearningMapper;
import com.hui.learn.service.ILearningService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.model.learn.query.LearnPageQuery;
import com.hui.model.learn.vo.LearningVo;
import com.hui.model.user.vos.UserVo;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 学习资料表 服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-29
 */
@Service
@RequiredArgsConstructor
public class LearningServiceImpl extends ServiceImpl<LearningMapper, Learning> implements ILearningService {


    private final UserClient userClient;
    private final StringRedisTemplate redisTemplate ;
    /**
     * 新增学习资料
     *
     * @param learningDto
     */
    @Override
    public ResponseResult addLearning(LearningDto learningDto) {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        if (learningDto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Learning learning = BeanUtils.copyBean(learningDto, Learning.class);
        UserVo userVo = userClient.queryUserById(Math.toIntExact(userId));
        learning.setUploader(userVo.getUsername());
        learning.setUserId(Math.toIntExact(userId));
        save(learning);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 删除学习资料
     *
     * @param id
     */
    @Override
    public ResponseResult deleteLearning(Integer id) {
        if (id == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Learning learning = getById(id);
        if (learning == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 分页查询学习资料
     */
    @Override
    public ResponseResult listLearning(LearnPageQuery query) {
        Page<Learning> page = lambdaQuery()
                .eq(query.getChannelId() != null, Learning::getChannelId, query.getChannelId())
                .eq(query.getType() != null, Learning::getType, query.getType())
                .like(query.getKeyword() != null, Learning::getTitle, query.getKeyword())
                .like(query.getKeyword() != null, Learning::getDescription, query.getKeyword())
                .page(query.toMpPageDefaultSortByCreateTimeDesc());
        List<Learning> records = page.getRecords();
        if (records == null || records.isEmpty()){
            return ResponseResult.okResult(PageDTO.empty(page));
        }
        List<LearningVo> learningVos = BeanUtils.copyList(records, LearningVo.class);
        // 2.查询当前用户
        Long userId = UserContext.getUser();
//        for (LearningVo learningVo : learningVos) {
//            if( userId!= null){
//                boolean isLiked = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(BehaviorConstants.LEARN_LIKE_BEHAVIOR + learningVo.getId(), userId.toString()));
//                learningVo.setLikeOrNot(isLiked);
//                //查询当前用户是否收藏BehaviorConstants.COLLECTION_BEHAVIOR + dto.getPostsId();
//                boolean isCollected = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + learningVo.getId(), userId.toString()));
//                learningVo.setCollectOrNot(isCollected);
//            }
//        }
        // 准备两个列表来存储点赞和收藏的键
        List<String> likeKeys = new ArrayList<>();
        List<String> collectKeys = new ArrayList<>();

        for (LearningVo learningVo : learningVos) {
            if (userId != null) {
                // 构建Redis键
                String likeKey = BehaviorConstants.LEARN_LIKE_BEHAVIOR + learningVo.getId();
                String collectKey = BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + learningVo.getId();

                // 添加到列表中，稍后一起查询
                likeKeys.add(likeKey);
                collectKeys.add(collectKey);
            }
        }

// 使用管道技术批量查询
        if (!likeKeys.isEmpty() || !collectKeys.isEmpty()) {
            redisTemplate.execute((RedisCallback<Object>) connection -> {
                // 执行点赞查询
                for (String likeKey : likeKeys) {
                    connection.sIsMember(likeKey.getBytes(), userId.toString().getBytes());
                }
                // 执行收藏查询
                for (String collectKey : collectKeys) {
                    connection.sIsMember(collectKey.getBytes(), userId.toString().getBytes());
                }
                return null;
            });
        }

// 重新遍历学习项目，设置点赞和收藏状态
        for (LearningVo learningVo : learningVos) {
            if (userId != null) {
                // 构建Redis键
                String likeKey = BehaviorConstants.LEARN_LIKE_BEHAVIOR + learningVo.getId();
                String collectKey = BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + learningVo.getId();

                // 根据查询结果设置点赞和收藏状态
                boolean isLiked = redisTemplate.opsForSet().isMember(likeKey, userId.toString());
                learningVo.setLikeOrNot(isLiked);

                boolean isCollected = redisTemplate.opsForSet().isMember(collectKey, userId.toString());
                learningVo.setCollectOrNot(isCollected);
            }
        }
        return ResponseResult.okResult(PageDTO.of(page, learningVos));
    }

    /**
     * 更新学习资料
     *
     * @param learningDto
     */
    @Override
    public ResponseResult updateLearning(LearningDto learningDto) {
        if (learningDto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Learning learning = BeanUtils.copyBean(learningDto, Learning.class);
        updateById(learning);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 点赞学习资料
     */
    @Override
    public ResponseResult likeLearning(LLikesBehaviorDto dto) {
        // 1.基于前端的参数，判断是执行点赞还是取消点赞
        boolean success = dto.getOperation()==1 ? likes(dto) : unlike(dto);
        if (!success) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }
        // 3.如果执行成功，统计点赞总数
        Long likedTimes = redisTemplate.opsForSet()
                .size(BehaviorConstants.LEARN_LIKE_BEHAVIOR + dto.getLearningId());
        // 4.更新数据库中的点赞数
        int likes = likedTimes.intValue();
        lambdaUpdate().set(Learning::getLikes, likes).eq(Learning::getId, dto.getLearningId()).update();
        String key = BehaviorConstants.LEARN_LIKE_BEHAVIOR + BehaviorConstants.TOTAL;
        // 4.缓存点总数到Redis
        redisTemplate.opsForZSet().add(
                key,
                dto.getLearningId().toString(),
                likedTimes
        );
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    private boolean likes(@NotNull LLikesBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.LEARN_LIKE_BEHAVIOR + dto.getLearningId();
        // 3.执行SADD命令
        Long result = redisTemplate.opsForSet().add(key, userId.toString());
        return result != null && result > 0;
    }
    private boolean unlike(@NotNull LLikesBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.LEARN_LIKE_BEHAVIOR + dto.getLearningId();
        // 3.执行SREM命令
        Long result = redisTemplate.opsForSet().remove(key, userId.toString());
        return result != null && result > 0;
    }

    /**
     * 收藏
     *
     * @param dto
     */
    @Override
    public ResponseResult collectLearning(LCollectBehaviorDto dto) {
        // 1.基于前端的参数，判断是执行收藏还是取消收藏
        boolean success = dto.getOperation()==1 ? collects(dto) : uncollect(dto);
        if (!success) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }
        // 3.如果执行成功，统计收藏总数
        Long collectTimes = redisTemplate.opsForSet()
                .size(BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + dto.getLearningId());
        // 4.更新数据库中的收藏数
        int collects = collectTimes.intValue();
        lambdaUpdate().set(Learning::getCollects, collects).eq(Learning::getId, dto.getLearningId()).update();
        String key = BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + BehaviorConstants.TOTAL;
        // 4.缓存点总数到Redis
        redisTemplate.opsForZSet().add(
                key,
                dto.getLearningId().toString(),
                collectTimes
        );
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 根据id查询学习资料
     *
     * @param id
     */
    @Override
    public ResponseResult getLearningById(Integer id) {
        if (id == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Learning learning = getById(id);
        if (learning == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        return ResponseResult.okResult(learning);
    }

    /**
     * 根据用户id查询学习资料
     */
    @Override
    public ResponseResult listMyLearning() {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        List<Learning> learnings = lambdaQuery().eq(Learning::getUserId,userId).list();
        if (learnings == null || learnings.isEmpty()) {
            return ResponseResult.okResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        List<LearningVo> learningVos = BeanUtils.copyList(learnings, LearningVo.class);
//        当前用户是否收藏
//        for (LearningVo learningVo : learningVos) {
//                boolean isLiked = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(BehaviorConstants.LEARN_LIKE_BEHAVIOR + learningVo.getId(), userId.toString()));
//                learningVo.setLikeOrNot(isLiked);
//                //查询当前用户是否收藏BehaviorConstants.COLLECTION_BEHAVIOR + dto.getPostsId();
//                boolean isCollected = Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + learningVo.getId(), userId.toString()));
//                learningVo.setCollectOrNot(isCollected);
//        }

        return ResponseResult.okResult(learningVos);
    }


    private boolean uncollect(LCollectBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + dto.getLearningId();
        // 3.执行SREM命令
        Long result = redisTemplate.opsForSet().remove(key, userId.toString());
        // 4.删除收藏记录
//        collectRecordService.deleteCollectRecord(dto);
        return result != null && result > 0;
    }

    private boolean collects(LCollectBehaviorDto dto) {
        // 1.获取用户id
        Long userId = UserContext.getUser();
        // 2.获取Key
        String key = BehaviorConstants.LEARN_COLLECTION_BEHAVIOR + dto.getLearningId();
        // 3.执行SADD命令
        Long result = redisTemplate.opsForSet().add(key, userId.toString());
        // 4.保存收藏记录
//        collectRecordService.saveCollectRecord(dto);
        return result != null && result > 0;
    }


}
