package com.hui.post.service.impl;

import com.alibaba.fastjson.JSON;
import com.hui.common.autoconfigure.mq.RabbitMqHelper;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.UserContext;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.mess.UpdatePostMess;
import com.hui.model.post.po.ViewRecords;
import com.hui.post.mapper.ViewRecordsMapper;
import com.hui.post.service.IViewRecordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.hui.common.constants.MqConstants.Exchange.COMMENT_EXCHANGE;
import static com.hui.common.constants.MqConstants.Key.VIEW_ADD;
import static com.hui.model.common.constants.BehaviorConstants.VIEW_BEHAVIOR;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-25
 */
@RequiredArgsConstructor
@Service
public class ViewRecordsServiceImpl extends ServiceImpl<ViewRecordsMapper, ViewRecords> implements IViewRecordsService {

    private final StringRedisTemplate redisTemplate ;
    private final RabbitMqHelper rabbitMqHelper;
    /**
     * 添加阅读记录
     *
     * @param postId
     */
    @Override
    public ResponseResult addViewRecord(Integer postId) {
        Long user = UserContext.getUser();
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        // 查询是否已有阅读记录
//        redisTemplate.opsForZSet().
//        ViewRecords viewRecords = this.lambdaQuery().eq(ViewRecords::getUserId, user).eq(ViewRecords::getPostId, postId).one();
//        if (viewRecords != null) {
//
//        }
        // 记录阅读次数
        String key = VIEW_BEHAVIOR+ user;
        long currentTime = Instant.now().getEpochSecond();
        // 使用 RedisTemplate 查询 postId 对应的分数
        Double score = redisTemplate.opsForZSet().score(key, postId.toString());
        if (score != null) {
            //删除原有记录
            redisTemplate.opsForZSet().remove(key, postId);
            // 记录新记录
            redisTemplate.opsForZSet().add(key, String.valueOf(postId),currentTime);
        } else {
            // 记录新记录
            redisTemplate.opsForZSet().add(key, String.valueOf(postId),currentTime);
        }

        //发送消息，进行聚合
        UpdatePostMess mess = new UpdatePostMess();
        mess.setPostId(Long.valueOf(postId));
        mess.setAdd(1);
        mess.setType(UpdatePostMess.UpdatePostType.VIEWS);
        rabbitMqHelper.send(
                COMMENT_EXCHANGE,
                VIEW_ADD,
                JSON.toJSONString(mess)
        );
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);

    }
}
