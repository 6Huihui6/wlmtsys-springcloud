package com.hui.post.service;

import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.po.Channel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-22
 */
public interface IChannelService extends IService<Channel> {

    /**
     * 获取频道列表
     */
    ResponseResult getChannelList();
}
