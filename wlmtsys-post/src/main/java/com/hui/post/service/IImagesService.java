package com.hui.post.service;

import com.hui.model.post.po.Images;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
public interface IImagesService extends IService<Images> {

    /**
     * 上传图片
     */
    String upload(MultipartFile multipartFile);

    /**
     * 保存图片
     */
    void saveImages(List<String> image, Integer postId);

//    void queryImages(List<Integer> postIds);
}
