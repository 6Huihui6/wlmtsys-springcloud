package com.hui.post.service.impl;

import com.alibaba.fastjson.JSON;
import com.hui.api.client.user.UserClient;
import com.hui.common.autoconfigure.mq.RabbitMqHelper;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.UserContext;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.mess.UpdatePostMess;
import com.hui.model.post.dto.CommentRepayDto;
import com.hui.model.post.dto.CommentRepayLikeDto;
import com.hui.model.post.dto.CommentRepaySaveDto;
import com.hui.model.post.po.CommentRepay;
import com.hui.model.post.po.CommentRepayLike;
import com.hui.model.post.po.Comment;
import com.hui.model.post.vo.CommentRepayVo;
import com.hui.model.user.vos.UserVo;
import com.hui.post.service.CommentRepayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
public class CommentRepayServiceImpl implements CommentRepayService {


    private final UserClient userClient;
    private final RabbitMqHelper rabbitMqHelper;
    private final MongoTemplate mongoTemplate;

    @Override
    public ResponseResult loadCommentRepay(CommentRepayDto dto) {
        //1.检查参数
        if(dto == null || dto.getCommentId() == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        int size = 20;

        //2.加载数据
        Query query;
        if(dto.getMinDate() == null){
            query = Query.query(Criteria.where("commentId").is(dto.getCommentId()));
        }else {
            query = Query.query(Criteria.where("commentId").is(dto.getCommentId()).and("createdTime").lt(dto.getMinDate()));
        }
        query.with(Sort.by(Sort.Direction.DESC,"createdTime")).limit(size);
        List<CommentRepay> list = mongoTemplate.find(query, CommentRepay.class);

        //3.数据封装返回
        //3.1 用户未登录
        Long userId = UserContext.getUser();
        if(userId == null){
            return ResponseResult.okResult(list);
        }

        //3.2 用户已登录

        //需要查询当前评论中哪些数据被点赞了
        List<String> idList = list.stream().map(CommentRepay::getId).collect(Collectors.toList());
        Query query1 = Query.query(Criteria.where("commentRepayId").in(idList).and("authorId").is(userId));
        List<CommentRepayLike> commentRepayLikes = mongoTemplate.find(query1, CommentRepayLike.class);
        if(commentRepayLikes.isEmpty()){
            return ResponseResult.okResult(list);
        }

        List<CommentRepayVo> resultList = new ArrayList<>();
        list.forEach(x->{
            CommentRepayVo vo = new CommentRepayVo();
            BeanUtils.copyProperties(x,vo);
            for (CommentRepayLike commentRepayLike : commentRepayLikes) {
                if(x.getId().equals(commentRepayLike.getCommentRepayId())){
                    vo.setOperation((short)0);
                    break;
                }
            }
            resultList.add(vo);
        });

        return ResponseResult.okResult(resultList);
    }

    @Override
    public ResponseResult saveCommentRepay(CommentRepaySaveDto dto) {
        //1.检查参数
        if(dto == null || StringUtils.isBlank(dto.getContent()) || dto.getCommentId() == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        if(dto.getContent().length() > 140){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"评论内容不能超过140字");
        }

        //2.判断是否登录
        Long userId = UserContext.getUser();
        if(userId == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }

        //3.安全检查 自行实现

        //4.保存评论
        UserVo dbUser = userClient.queryUserById(Math.toIntExact(userId));
        if(dbUser == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"当前登录信息有误");
        }
        CommentRepay commentRepay = new CommentRepay();
        commentRepay.setAuthorId(Math.toIntExact(userId));
        commentRepay.setContent(dto.getContent());
        commentRepay.setCreatedTime(new Date());
        commentRepay.setCommentId(dto.getCommentId());
        commentRepay.setAuthorName(dbUser.getUsername());
        commentRepay.setUpdatedTime(new Date());
        commentRepay.setLikes(0);
        commentRepay.setImage(dbUser.getImage());
        commentRepay.setPostId(dto.getPostId());
        mongoTemplate.save(commentRepay);

        //5更新回复数量
        Comment apComment = mongoTemplate.findById(dto.getCommentId(), Comment.class);
        if (apComment != null) {
            apComment.setReply(apComment.getReply()+1);
            mongoTemplate.save(apComment);
        }

        //发送消息，进行聚合
        UpdatePostMess mess = new UpdatePostMess();
        mess.setPostId(Long.valueOf(dto.getPostId()));
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
    public ResponseResult saveCommentRepayLike(CommentRepayLikeDto dto) {
        //1.检查参数
        if(dto == null || dto.getCommentRepayId() == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.判断是否登录
        Long userId = UserContext.getUser();
        if(userId == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        CommentRepay commentRepay = mongoTemplate.findById(dto.getCommentRepayId(), CommentRepay.class);
        Query query = Query.query(Criteria.where("commentRepayId").is(dto.getCommentRepayId()).and("authorId").is(userId));
        CommentRepayLike isLike = mongoTemplate.findOne(query, CommentRepayLike.class);
        //3.点赞
        if(commentRepay != null && dto.getOperation() == 0){
            if(isLike != null){
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REPEAT);
            }
            //更新评论点赞数量
            commentRepay.setLikes(commentRepay.getLikes()+1);
            mongoTemplate.save(commentRepay);

            //保存评论点赞数据
            CommentRepayLike commentRepayLike = new CommentRepayLike();
            commentRepayLike.setCommentRepayId(commentRepay.getId());
            commentRepayLike.setAuthorId(Math.toIntExact(userId));
            mongoTemplate.save(commentRepayLike);
        }else {
            if(isLike == null){
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_NOT_LIKE);
            }
            //更新评论点赞数量
            int tmp = 0;
            if (commentRepay != null) {
                tmp = commentRepay.getLikes()-1;
            tmp = tmp < 1 ? 0 : tmp;
            commentRepay.setLikes(tmp);
            mongoTemplate.save(commentRepay);
            }
            //删除评论点赞
            Query query1 = Query.query(Criteria.where("commentRepayId").is(commentRepay != null ? commentRepay.getId() : null).and("authorId").is(userId));
            mongoTemplate.remove(query1, CommentRepayLike.class);
        }
        //4.取消点赞
        Map<String,Object> result = new HashMap<>();
        result.put("likes", commentRepay != null ? commentRepay.getLikes() : null);
        return ResponseResult.okResult(result);
    }
}
