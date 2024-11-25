package com.hui.info.service;

import com.hui.model.info.dtos.CarouselDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Images;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
public interface IImagesService extends IService<Images> {


    ResponseResult upload(MultipartFile multipartFile);

    /**
     * 获取轮播图
     */
    ResponseResult getCarousel();

    /**
     * 添加轮播图
*/
    ResponseResult addCarousel(CarouselDTO carouselDTO);

    /**
     * 获取首页轮播图
     * */
    ResponseResult getTopCarousel();

    /**
     * 删除轮播图
     */
    ResponseResult deleteCarousel(Integer id);
}
