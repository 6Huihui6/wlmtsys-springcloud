package com.hui.post.service;

import com.hui.model.post.po.PointsRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.model.post.po.PointsRecordType;

/**
 * <p>
 * 学习积分记录，每个月底清零 服务类
 * </p>
 *
 * @author hui
 * @since 2024-12-11
 */
public interface IPointsRecordService extends IService<PointsRecord> {

    /**
     * 添加积分记录

     */
    void addPointsRecord(Long postId, int points, PointsRecordType type);
}
