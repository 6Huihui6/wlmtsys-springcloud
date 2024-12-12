package com.hui.post.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.common.utils.DateUtils;
import com.hui.model.post.po.PointsRecord;
import com.hui.post.constants.CommonConstants;
import com.hui.model.post.po.PointsRecordType;
import com.hui.post.mapper.PointsRecordMapper;
import com.hui.post.service.IPointsRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 学习积分记录，每个月底清零 服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-12-11
 */
@Service
@RequiredArgsConstructor
public class PointsRecordServiceImpl extends ServiceImpl<PointsRecordMapper, PointsRecord> implements IPointsRecordService {

    private final StringRedisTemplate redisTemplate;
    /**
     * 添加积分记录
     *
     */
    @Override
    public void addPointsRecord(Long postId, int points, PointsRecordType type) {
        LocalDateTime now = LocalDateTime.now();
        PointsRecord p = new PointsRecord();
        p.setPoints(points);
        p.setPostId(postId);
        p.setType(type);
        save(p);
        // 4.更新总积分到Redis
        String key = CommonConstants.POINTS_BOARD_KEY_PREFIX + now.format(DateUtils.POINTS_BOARD_SUFFIX_FORMATTER);
        redisTemplate.opsForZSet().incrementScore(key, postId.toString(), points);
    }

}
