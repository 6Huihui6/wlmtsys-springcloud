package com.hui.info.controller;


import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.info.service.IImagesService;
import com.hui.info.service.IInfoService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.CarouselDTO;
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
    private final IImagesService iImagesService;



    @ApiOperation("admin+官网---实验室简介查询接口")
    @GetMapping("/intro")
    public ResponseResult getLabIntro() {
        log.info("实验室简介接口");
        return  infoService.getLabIntro();
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
    @ApiOperation(value = "首页---获取footer轮播图接口")
    @GetMapping("/carousel/footer")
    public ResponseResult getCarousel() {
        log.info("首页---footer轮播图接口");
        return iImagesService.getCarousel();
    }
    @ApiOperation(value = "首页---获取top轮播图接口")
    @GetMapping("/carousel/top")
    public ResponseResult getTopCarousel() {
        log.info("首页---footer轮播图接口");
        return iImagesService.getTopCarousel();
    }
    @ApiOperation(value = "首页---添加footer或top轮播图接口")
    @PostMapping("/carousel/add")
    public ResponseResult addCarousel(@RequestBody CarouselDTO carouselDTO) {
        log.info("首页---添加footer轮播图接口");
        return iImagesService.addCarousel(carouselDTO);
    }
    @ApiOperation(value = "首页---根据id删除footer或top轮播图接口")
    @GetMapping("/carousel/delete/{id}")
    public ResponseResult deleteCarousel(@PathVariable("id") Integer id) {
        return iImagesService.deleteCarousel(id);
    }

}
