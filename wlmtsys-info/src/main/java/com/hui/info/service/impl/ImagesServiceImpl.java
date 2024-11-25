package com.hui.info.service.impl;

import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.model.info.dtos.CarouselDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Images;
import com.hui.info.mapper.ImagesMapper;
import com.hui.info.service.IImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.obs.service.OBSService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Service
@RequiredArgsConstructor
public class ImagesServiceImpl extends ServiceImpl<ImagesMapper, Images> implements IImagesService {

    private final OBSService obsService;

    @Override
    public ResponseResult upload(MultipartFile multipartFile) {
        String image = obsService.uploadImage(multipartFile, "images");
        return ResponseResult.okResult(image);
    }

    /**
     * 获取轮播图
     */
    @Override
    public ResponseResult getCarousel() {
        List<Images> footer = lambdaQuery().eq(Images::getType, "footer").list();
        return ResponseResult.okResult(footer);
    }

    /**
     * 添加轮播图
     *
     * @param carouselDTO
     */
    @Override
    public ResponseResult addCarousel(CarouselDTO carouselDTO) {
        if ( carouselDTO.getType()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        Images images = BeanUtils.copyBean(carouselDTO, Images.class);
        save(images);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 获取首页轮播图
     */
    @Override
    public ResponseResult getTopCarousel() {
        List<Images> footer = lambdaQuery().eq(Images::getType, "top").list();
        return ResponseResult.okResult(footer);
    }

    /**
     * 删除轮播图
     *
     * @param id
     */
    @Override
    public ResponseResult deleteCarousel(Integer id) {
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
