package com.hui.post.controller;



import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.dto.CommentDto;
import com.hui.model.post.dto.CommentLikeDto;
import com.hui.model.post.dto.CommentSaveDto;
import com.hui.post.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "添加评论")
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {


    private final CommentService commentService;

    @ApiOperation("添加一级评论")
    @PostMapping("/save")
    public ResponseResult saveComment(@RequestBody CommentSaveDto dto){
        return commentService.saveComment(dto);
    }

    @ApiOperation("评论点赞")
    @PostMapping("/like")
    public ResponseResult like(@RequestBody CommentLikeDto dto){
        return commentService.like(dto);
    }

    @ApiOperation("查询评论---operation为0 代表当前用户已点赞的评论")
    @PostMapping("/load")
    public ResponseResult findByArticleId(@RequestBody CommentDto dto){
        return commentService.findByArticleId(dto);
    }
}
