package com.hui.info.controller;


import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.info.service.IInfoService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Info;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Slf4j
@Api(tags = "实验室简介管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/info")
public class InfoController {

    private final IInfoService infoService;


    @ApiOperation("admin+官网---实验室简介查询接口")
    @GetMapping("/intro")
    public ResponseResult getLabIntro() {
        log.info("实验室简介接口");
        List<Info> list = infoService.getLabIntro();
        return ResponseResult.okResult(list);
    }

    @ApiOperation("admin---添加实验室简介接口")
    @PostMapping("/add")
    public void addLabInfo(@RequestBody Info wlmtsysInfo) {
        log.info("添加实验室简介接口");
        infoService.addLabInfo(wlmtsysInfo);
    }


    @ApiOperation("admin---根据id获取实验室简介接口")
    @GetMapping("/{id}")
    public ResponseResult getLabInfo(@PathVariable("id") Integer id) {
        log.info("获取实验室简介接口");
        Info wlmtsysInfo = infoService.getLabInfo(id);
        return ResponseResult.okResult(wlmtsysInfo);
    }

    @ApiOperation("admin---删除实验室简介接口")
    @DeleteMapping("/delete/{id}")
    public void deleteLabInfo(@PathVariable("id") Integer id) {
        log.info("删除实验室简介接口");
        infoService.deleteLabInfo(id);
    }


    @ApiOperation("admin---图片接口1")
    @PostMapping("/upload")
    public ResponseResult uploadNews(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer imageId) {
        log.info("图片接口,{},id:{}", multipartFile, imageId);

        return  infoService.uploadNews(multipartFile, imageId);
    }

    @ApiOperation("admin---图片接口2")
    @PostMapping("/upload/weimg")
    public ResponseResult uploadNewsWe(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer weimgId) {
        log.info("图片接口,{},id:{}", multipartFile, weimgId);
        infoService.uploadNewsWe(multipartFile, weimgId);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @ApiOperation("admin---修改实验室简介接口")
    @PutMapping("/update")
    public void updateLabInfo(@RequestBody Info wlmtsysInfo) {
        log.info("修改实验室简介接口");
        infoService.updateLabInfo(wlmtsysInfo);
    }

    @ApiOperation(value = "admin---分页 获取信息接口")
    @GetMapping("/page")
    public PageDTO<Info> queryNewsPage(PageQuery query){
        log.info("分页 获取信息接口");
        return infoService.queryEmployPage(query);
    }
}
