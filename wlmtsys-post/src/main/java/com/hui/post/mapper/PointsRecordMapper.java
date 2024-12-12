package com.hui.post.mapper;

import com.hui.model.post.po.PointsRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学习积分记录，每个月底清零 Mapper 接口
 * </p>
 *
 * @author hui
 * @since 2024-12-11
 */
@Mapper
public interface PointsRecordMapper extends BaseMapper<PointsRecord> {

}
