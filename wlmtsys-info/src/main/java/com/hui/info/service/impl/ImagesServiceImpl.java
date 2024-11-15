package com.hui.info.service.impl;

import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Images;
import com.hui.info.mapper.ImagesMapper;
import com.hui.info.service.IImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.obs.service.OBSService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
}
