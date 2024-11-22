package com.hui.post.service.impl;

import com.alibaba.fastjson.JSON;
import com.hui.api.client.user.UserClient;
import com.hui.common.autoconfigure.mq.RabbitMqHelper;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.UserContext;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.mess.UpdatePostMess;
import com.hui.model.post.dto.CommentDto;
import com.hui.model.post.dto.CommentLikeDto;
import com.hui.model.post.dto.CommentSaveDto;
import com.hui.model.post.po.Comment;
import com.hui.model.post.po.CommentLike;
import com.hui.model.post.po.CommentRepayLike;
import com.hui.model.post.vo.CommentVo;
import com.hui.model.user.dto.UserDTO;
import com.hui.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.hui.common.constants.MqConstants.Exchange.COMMENT_EXCHANGE;
import static com.hui.common.constants.MqConstants.Key.COMMENT_NEW_KEY;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserClient userClient;
    private final MongoTemplate mongoTemplate;
    private final RabbitMqHelper rabbitMqHelper;




    @Override
    public ResponseResult saveComment(CommentSaveDto dto) {
        //1.检查参数
        if (dto == null || StringUtils.isBlank(dto.getContent()) || dto.getPostId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        if (dto.getContent().length() > 140) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "评论内容不能超过140字");
        }

        //2.判断是否登录
        Long userId =UserContext.getUser();
//        Long userId = AppThreadLocalUtil.getUser().getId();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        //3.安全检查 自行实现
        //4.保存评论
        UserDTO user = userClient.queryUserById(userId);
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "当前登录信息有误");
        }
        Comment comment = new Comment();
        comment.setAuthorId(Math.toIntExact(userId));
        comment.setContent(dto.getContent());
        comment.setCreatedTime(new Date());
        comment.setPostId(dto.getPostId());
        comment.setImage(user.getAvatarUrl());
        comment.setAuthorName(user.getName());
        comment.setLikes(0);
        comment.setReply(0);
        comment.setType((short) 0);
        comment.setFlag((short) 0);
        mongoTemplate.save(comment);

        //发送消息，进行聚合
        UpdatePostMess mess = new UpdatePostMess();
        mess.setPostId(dto.getPostId());
        mess.setAdd(1);
        mess.setType(UpdatePostMess.UpdatePostType.COMMENT);
        rabbitMqHelper.send(
                COMMENT_EXCHANGE,
                COMMENT_NEW_KEY,
                JSON.toJSONString(mess)
        );
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


    @Override
    public ResponseResult like(CommentLikeDto dto) {
        //1.检查参数
        if (dto == null || dto.getCommentId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        //2.判断是否登录
        Long userId =UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }

        Comment apComment = mongoTemplate.findById(dto.getCommentId(), Comment.class);
        Query query = Query.query(Criteria.where("commentRepayId").is(dto.getCommentId()).and("authorId").is(userId));
        CommentRepayLike isLike = mongoTemplate.findOne(query, CommentRepayLike.class);
        //3.点赞
        if (apComment != null && dto.getOperation() == 0) {
            if(isLike != null){
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REPEAT);
            }
            //更新评论点赞数量
            apComment.setLikes(apComment.getLikes() + 1);
            mongoTemplate.save(apComment);

            //保存评论点赞数据
            CommentLike apCommentLike = new CommentLike();
            apCommentLike.setCommentId(apComment.getId());
            apCommentLike.setAuthorId(Math.toIntExact(userId));
            mongoTemplate.save(apCommentLike);
        } else {
            if(isLike == null){
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_NOT_LIKE);
            }
            //更新评论点赞数量
            int tmp = apComment.getLikes() - 1;
            tmp = tmp < 1 ? 0 : tmp;
            apComment.setLikes(tmp);
            mongoTemplate.save(apComment);

            //删除评论点赞
            Query query1 = Query.query(Criteria.where("commentId").is(apComment.getId()).and("authorId").is(userId));
            mongoTemplate.remove(query1, CommentLike.class);
        }

        //4.取消点赞
        Map<String, Object> result = new HashMap<>();
        result.put("likes", apComment.getLikes());
        return ResponseResult.okResult(result);
    }


    @Override
    public ResponseResult findByArticleId(CommentDto dto) {
        //1.检查参数
        if (dto == null || dto.getPostId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        int size = 10;

        //2.加载数据
        Query query;
        if (dto.getMinDate() == null) {
             query = Query.query(Criteria.where("postId").is(dto.getPostId()));
        } else {
            query = Query.query(Criteria.where("postId").is(dto.getPostId()).and("createdTime").lt(dto.getMinDate()));
        }
        query.with(Sort.by(Sort.Direction.DESC, "createdTime")).limit(size);
        List<Comment> list = mongoTemplate.find(query, Comment.class);

        //3.数据封装返回
        //3.1 用户未登录
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.okResult(list);
        }

        //3.2 用户已登录

        //需要查询当前评论中哪些数据被点赞了
        List<String> idList = list.stream().map(x -> x.getId()).collect(Collectors.toList());
        Query query1 = Query.query(Criteria.where("commentId").in(idList).and("authorId").is(userId));
        List<CommentLike> apCommentLikes = mongoTemplate.find(query1, CommentLike.class);
        if (apCommentLikes == null) {
            return ResponseResult.okResult(list);
        }

        List<CommentVo> resultList = new ArrayList<>();
        list.forEach(x -> {
            CommentVo vo = new CommentVo();
            BeanUtils.copyProperties(x, vo);
            for (CommentLike apCommentLike : apCommentLikes) {
                if (x.getId().equals(apCommentLike.getCommentId())) {
                    vo.setOperation((short) 0);
                    break;
                }
            }
            resultList.add(vo);
        });

        return ResponseResult.okResult(resultList);
    }
}
