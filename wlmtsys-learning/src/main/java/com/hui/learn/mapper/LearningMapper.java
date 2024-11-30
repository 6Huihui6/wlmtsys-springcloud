package com.hui.learn.mapper;

import com.hui.model.learn.po.Learning;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学习资料表 Mapper 接口
 * </p>
 *
 * @author hui
 * @since 2024-11-29
 */
@Mapper
public interface LearningMapper extends BaseMapper<Learning> {

}
