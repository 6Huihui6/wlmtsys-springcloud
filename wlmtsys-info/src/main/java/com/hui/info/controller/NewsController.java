package com.hui.info.controller;


import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.info.service.INewsService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.News;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Api(tags = "新闻模块")
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {


    private final INewsService newsService;


    @ApiOperation("admin---添加新闻接口")
    @PostMapping("/save")
    public void addNews(@RequestBody News news) {
        log.info("添加新闻接口");
        newsService.addNews(news);
    }


@ApiOperation(value = "admin---删除新闻接口", notes = "admin---删除新闻接口")
    @DeleteMapping("/delete/{id}")
    public void deleteNews(@PathVariable("id") Integer id) {
        log.info("删除新闻接口");
        newsService.deleteNews(id);
    }


    @ApiOperation(value = "admin---修改新闻接口", notes = "admin---修改新闻接口")
    @PutMapping("/update")
    public ResponseResult updateNews(@RequestBody  News news) {
        log.info("修改新闻接口,{}",news);
        newsService.updateNews(news);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @ApiOperation(value = "上传图片接口", notes = "上传图片接口")
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        log.info("图片接口,{}", multipartFile);
        return   newsService.upload(multipartFile);
    }


    @ApiOperation(value = "上传图片接口", notes = "上传图片接口")
    @PostMapping("/uploadNews")
    public ResponseResult uploadNews(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer newsId) {
        log.info("图片接口,{},id:{}", multipartFile, newsId);
        newsService.uploadNews(multipartFile, newsId);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @ApiOperation(value = "admin---分页查询获取新闻详情接口", notes = "admin---分页查询获取新闻详情接口")
    @GetMapping("/page")
    public PageDTO<News> queryNewsPage(PageQuery query){
        log.info("分页查询获取新闻详情接口:{}",query);
        return newsService.queryNewsPage(query);
    }

    @ApiOperation(value = "官网-----新闻查询接口", notes = "官网-----新闻查询接口")
    @GetMapping("/list/{lables}")
    public ResponseResult getNewsList(@PathVariable("lables") Integer lables) {
        log.info("新闻查询接口");
        List<News> list = newsService.getNewsList(lables);
        return ResponseResult.okResult(list);
    }



}
