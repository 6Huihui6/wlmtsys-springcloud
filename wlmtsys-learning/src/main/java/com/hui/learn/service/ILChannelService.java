package com.hui.learn.service;

import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.learn.po.LChannel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-30
 */
public interface ILChannelService extends IService<LChannel> {

    /**
     * 获取频道列表
     */
    ResponseResult getChannelList();
}
