package com.hui.info.controller;


import com.hui.info.service.IImagesService;
import com.hui.model.info.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */

@RequestMapping("/images")
@Slf4j
@Api(tags = "图片上传")
@RestController
@RequiredArgsConstructor
public class ImagesController {
    private final IImagesService iImagesService;


    @ApiOperation(value = "上传图片接口", notes = "上传图片接口")
    @PostMapping("/upload")
    public ResponseResult uploadNews(@RequestParam("file") MultipartFile multipartFile) {
        log.info("图片接口,{}", multipartFile);
        return   iImagesService.upload(multipartFile);
    }
}
