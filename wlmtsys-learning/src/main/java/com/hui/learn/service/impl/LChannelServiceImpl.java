package com.hui.learn.service.impl;

import com.hui.common.utils.BeanUtils;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.learn.po.LChannel;
import com.hui.learn.mapper.LChannelMapper;
import com.hui.learn.service.ILChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.model.learn.vo.LChannelVo;
import org.springframework.stereotype.Service;

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
 * @since 2024-11-30
 */
@Service
public class LChannelServiceImpl extends ServiceImpl<LChannelMapper, LChannel> implements ILChannelService {

    /**
     * 获取频道列表
     */
    @Override
    public ResponseResult getChannelList() {
        List<LChannel> list = lambdaQuery().eq(LChannel::getParentId, 0).list();
        List<LChannelVo> channelVos = BeanUtils.copyList(list, LChannelVo.class);
        List<Integer> channelIds = list.stream().map(LChannel::getId).filter(Objects::nonNull).toList();
        List<LChannel> channelList = lambdaQuery().in(LChannel::getParentId, channelIds).list();
        Map<Integer, List<LChannel>> channelMap = channelList.stream().collect(Collectors.groupingBy(LChannel::getParentId));
        for (LChannelVo channelVo : channelVos) {
            channelVo.setChildren(channelMap.get(channelVo.getId()));
        }
        return ResponseResult.okResult(channelVos);
    }
}
