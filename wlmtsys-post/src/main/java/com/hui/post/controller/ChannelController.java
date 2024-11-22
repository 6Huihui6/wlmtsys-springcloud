package com.hui.post.controller;


import com.hui.model.info.dtos.ResponseResult;
import com.hui.post.service.IChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-22
 */
@Slf4j
@RestController
@Api(tags = "频道管理")
@RequiredArgsConstructor
@RequestMapping("/channel")
public class ChannelController {

    private final IChannelService channelService;

    @ApiOperation(value = "获取频道列表")
    @GetMapping("/list")
    public ResponseResult getChannelList() {
        return channelService.getChannelList();
    }

}
