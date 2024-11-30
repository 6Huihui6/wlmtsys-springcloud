package com.hui.learn.service;

import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.learn.dto.LCollectBehaviorDto;
import com.hui.model.learn.dto.LLikesBehaviorDto;
import com.hui.model.learn.dto.LearningDto;
import com.hui.model.learn.po.Learning;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.model.learn.query.LearnPageQuery;

/**
 * <p>
 * 学习资料表 服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-29
 */
public interface ILearningService extends IService<Learning> {

    /**
     * 新增学习资料
     */
    ResponseResult addLearning(LearningDto learningDto);

    /**
     * 删除学习资料
     */
    ResponseResult deleteLearning(Integer id);


    /**
     * 分页查询学习资料*/
    ResponseResult listLearning(LearnPageQuery query);

    /**
     * 更新学习资料
     */
    ResponseResult updateLearning(LearningDto learningDto);

    /**
     * 点赞学习资料
     */
    ResponseResult likeLearning(LLikesBehaviorDto dto);

    /**
     * 收藏学习资料
     */
    ResponseResult collectLearning(LCollectBehaviorDto dto);

    /**
     * 根据id查询学习资料
     */
    ResponseResult getLearningById(Integer id);

    /**
     * 根据用户id查询学习资料
     */
    ResponseResult listMyLearning();
}
