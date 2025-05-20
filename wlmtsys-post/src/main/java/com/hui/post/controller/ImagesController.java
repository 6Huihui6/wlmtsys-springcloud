package com.hui.post.controller;


import com.hui.post.service.IImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
 * @since 2024-11-19
 */
@Api(tags = "图片上传")
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImagesController {


    private final IImagesService imagesService;

    @ApiOperation(value = "上传图片---返回图片的url地址")
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return imagesService.upload(multipartFile);
    }

}
