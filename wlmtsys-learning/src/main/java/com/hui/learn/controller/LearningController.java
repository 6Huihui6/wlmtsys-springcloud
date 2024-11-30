package com.hui.learn.controller;


import com.hui.learn.service.ILearningService;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.learn.dto.LCollectBehaviorDto;
import com.hui.model.learn.dto.LLikesBehaviorDto;
import com.hui.model.learn.dto.LearningDto;
import com.hui.model.learn.query.LearnPageQuery;
import com.sun.jdi.PrimitiveValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学习资料表 前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-29
 */
@Api(tags = "学习资料mk")
@RestController
@RequestMapping("/learning")
@RequiredArgsConstructor
public class LearningController {

    private final ILearningService learningService;

    @ApiOperation(value = "分页查询所有学习资料", notes = "分页查询所有学习资料")
    @GetMapping("/page")
    public ResponseResult listLearning(LearnPageQuery query) {
        return learningService.listLearning(query);
    }
    @ApiOperation(value = "添加学习资料", notes = "添加学习资料")
    @PostMapping("/add")
    public ResponseResult addLearning(@RequestBody LearningDto learningDto) {
        return learningService.addLearning(learningDto);
    }

    @ApiOperation(value = "查询当前用户发布的学习资料", notes = "查询当前用户发布的学习资料")
    @GetMapping("/my")
    public ResponseResult listMyLearning() {
        return learningService.listMyLearning();
    }

    @ApiOperation(value = "根据id删除学习资料", notes = "根据id删除学习资料")
    @PostMapping("/delete/{id}")
    public ResponseResult deleteLearning(@PathVariable("id") Integer id) {
        return learningService.deleteLearning(id);
    }

    @ApiOperation(value = "根据id更新学习资料", notes = "根据id更新学习资料")
    @PostMapping("/update")
    public ResponseResult updateLearning(@RequestBody LearningDto learningDto) {
        return learningService.updateLearning(learningDto);
    }

    @ApiOperation(value = "用户点赞或取消点赞学习资料", notes = "用户点赞或取消点赞学习资料")
    @PostMapping("/like")
    public ResponseResult likeLearning(@RequestBody LLikesBehaviorDto dto) {
        return learningService.likeLearning(dto);
    }
    @ApiOperation(value = "用户收藏或取消收藏学习资料", notes = " 用户收藏或取消收藏学习资料")
    @PostMapping("/collect")
    public ResponseResult collectLearning(@RequestBody LCollectBehaviorDto dto) {
        return learningService.collectLearning(dto);
    }

    @ApiOperation(value = "根据id查询学习资料", notes = "根据id查询学习资料")
    @GetMapping("/{id}")
    public ResponseResult getLearningById(@PathVariable("id") Integer id) {
        return learningService.getLearningById(id);
    }



}
