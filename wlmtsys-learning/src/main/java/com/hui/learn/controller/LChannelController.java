package com.hui.learn.controller;


import com.hui.learn.service.ILChannelService;
import com.hui.model.info.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-30
 */
@Api(tags = "频道管理")
@RestController
@RequestMapping("/channel")
@RequiredArgsConstructor
public class LChannelController {

    private final ILChannelService channelService;

    @ApiOperation(value = "获取频道列表")
    @GetMapping("/list")
    public ResponseResult getChannelList() {
        return channelService.getChannelList();
    }


}
