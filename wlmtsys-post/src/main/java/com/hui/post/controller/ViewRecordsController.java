package com.hui.post.controller;


import com.hui.model.info.dtos.ResponseResult;
import com.hui.post.service.IViewRecordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-25
 */
@Api(tags = "历史浏览记录")
@RestController
@RequestMapping("/view-records")
@RequiredArgsConstructor
public class ViewRecordsController {

    private final IViewRecordsService viewRecordsService;

    @ApiOperation(value = "新增当前用户历史浏览记录")
    @GetMapping("/add")
    public ResponseResult addViewRecord(@RequestParam("postId") Integer postId) {
        return viewRecordsService.addViewRecord(postId);
    }


}
