package com.hui.post.service.impl;

import com.hui.common.utils.BeanUtils;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.po.Channel;
import com.hui.model.post.vo.ChannelVo;
import com.hui.post.mapper.ChannelMapper;
import com.hui.post.service.IChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-22
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements IChannelService {

    /**
     * 获取频道列表
     */
    @Override
    public ResponseResult getChannelList() {
        List<Channel> list = lambdaQuery().eq(Channel::getParentId, 0).list();
        List<ChannelVo> channelVos = BeanUtils.copyList(list, ChannelVo.class);
        List<Integer> channelIds = list.stream().map(Channel::getId).filter(Objects::nonNull).toList();
        List<Channel> channelList = lambdaQuery().in(Channel::getParentId, channelIds).list();
        Map<Integer, List<Channel>> channelMap = channelList.stream().collect(Collectors.groupingBy(Channel::getParentId));
        for (ChannelVo channelVo : channelVos) {
            channelVo.setChildren(channelMap.get(channelVo.getId()));
        }
        return ResponseResult.okResult(channelVos);
    }
}
