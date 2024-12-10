package com.hui.post.controller;



import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.dto.CommentRepayDto;
import com.hui.model.post.dto.CommentRepayLikeDto;
import com.hui.model.post.dto.CommentRepaySaveDto;
import com.hui.post.service.CommentRepayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "评论回复模块")
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment_repay")
public class CommentRepayController {


    private final CommentRepayService commentRepayService;

    @ApiOperation(value = "加载评论回复列表", notes = "根据评论ID加载评论回复列表")
    @PostMapping("/load")
    public ResponseResult loadCommentRepay(@RequestBody CommentRepayDto dto){
        return commentRepayService.loadCommentRepay(dto);
    }

    @ApiOperation(value = "保存评论回复", notes = "保存评论回复")
    @PostMapping("/save")
    public ResponseResult saveCommentRepay(@RequestBody CommentRepaySaveDto dto){
        return commentRepayService.saveCommentRepay(dto);
    }
    @ApiOperation(value = "点赞评论回复", notes = "点赞评论回复")
    @PostMapping("/like")
    public ResponseResult saveCommentRepayLike(@RequestBody CommentRepayLikeDto dto){
        return commentRepayService.saveCommentRepayLike(dto);
    }

}