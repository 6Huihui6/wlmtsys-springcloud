package com.hui.model.post.vo;

import com.hui.model.post.po.CommentRepay;
import com.hui.model.post.po.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentRepayListVo  {

    private Comment apComments;
    private List<CommentRepay> commentRepays;
}