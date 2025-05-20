package com.hui.post.mapper;

import com.hui.model.post.po.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 帖子表 Mapper 接口
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
