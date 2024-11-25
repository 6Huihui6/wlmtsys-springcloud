package com.hui.post.controller;


import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.dto.CollectBehaviorDto;
import com.hui.model.post.dto.LikesBehaviorDto;
import com.hui.model.post.dto.PageDto;
import com.hui.model.post.dto.PostDto;
import com.hui.post.service.IPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 帖子表 前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
@RestController
@Api(tags = "帖子接口")
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final IPostService postService;

    @ApiOperation(value = "获取帖子列表")
    @GetMapping("/list")
    public ResponseResult list( PageDto pageDto) {
        return postService.getPostList(pageDto);
    }

    @ApiOperation(value = "帖子发布或修改")
    @PostMapping("/addOrEdit")
    public ResponseResult addOrEdit(@RequestBody PostDto dto ) {
        return postService.addOrEditPost(dto);
    }

    @ApiOperation(value = "根据帖子ID删除帖子")
    @DeleteMapping("/delete/{postId}")
    public ResponseResult delete(@PathVariable("postId") Integer postId ) {
        return postService.deletePost(postId);
    }

    @ApiOperation(value = "点赞或取消点赞")
    @PostMapping("/like")
    public ResponseResult likeOrCancel(@RequestBody LikesBehaviorDto dto ) {
        return postService.like(dto);
    }
    /**
     * 用户点赞或取消点赞·接口
     */
    @ApiOperation(value = "用户收藏或取消收藏·接口")
    @PostMapping("/collect")
    public ResponseResult collect(@RequestBody CollectBehaviorDto dto) {
        return postService.collect(dto);
    }
    @ApiOperation(value = "获取帖子详情", notes = "获取帖子详情")
    @GetMapping("/get/{postId}")
    public ResponseResult get(@PathVariable("postId") Integer postId ) {
        return postService.getPostDetail(postId);
    }

}
