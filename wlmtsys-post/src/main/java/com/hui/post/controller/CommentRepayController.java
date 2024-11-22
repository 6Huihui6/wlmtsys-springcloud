package com.hui.post.controller;



import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.dto.CommentRepayDto;
import com.hui.model.post.dto.CommentRepayLikeDto;
import com.hui.model.post.dto.CommentRepaySaveDto;
import com.hui.post.service.CommentRepayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment_repay")
public class CommentRepayController {


    @Autowired
    private CommentRepayService commentRepayService;

    @PostMapping("/load")
    public ResponseResult loadCommentRepay(@RequestBody CommentRepayDto dto){
        return commentRepayService.loadCommentRepay(dto);
    }

    @PostMapping("/save")
    public ResponseResult saveCommentRepay(@RequestBody CommentRepaySaveDto dto){
        return commentRepayService.saveCommentRepay(dto);
    }

    @PostMapping("/like")
    public ResponseResult saveCommentRepayLike(@RequestBody CommentRepayLikeDto dto){
        return commentRepayService.saveCommentRepayLike(dto);
    }

}