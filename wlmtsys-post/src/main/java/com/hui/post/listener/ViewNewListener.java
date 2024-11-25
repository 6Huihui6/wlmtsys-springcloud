package com.hui.post.listener;

import com.alibaba.fastjson.JSON;
import com.hui.model.mess.ArticleVisitStreamMess;
import com.hui.post.service.IPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import static com.hui.common.constants.MqConstants.Exchange.COMMENT_EXCHANGE;
import static com.hui.common.constants.MqConstants.Key.COMMENT_NEW_KEY;
import static com.hui.common.constants.MqConstants.Key.VIEW_ADD;

@Component
@Slf4j
@RequiredArgsConstructor
public class ViewNewListener {

    private final IPostService postService;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "comment.new", durable = "true"),
            exchange = @Exchange(name = COMMENT_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = VIEW_ADD
    ))
    public void onMessage(String mess){
        if(StringUtils.isNotBlank(mess)){
            System.out.println(mess);
            ArticleVisitStreamMess articleVisitStreamMess = JSON.parseObject(mess, ArticleVisitStreamMess.class);
            log.info("收到新评论消息：{}", articleVisitStreamMess);
            postService.saveViewCount(articleVisitStreamMess);
        }
    }


}