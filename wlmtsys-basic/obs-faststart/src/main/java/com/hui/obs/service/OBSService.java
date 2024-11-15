package com.hui.obs.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-10-12
 */
public interface OBSService {

    String uploadImage(MultipartFile mpFile, String type);

//    /**
//     * 保存图片
//     * @param images 图片列表
//     * @param id
//     */
//    void saveImages(List<String> images, Integer id);
}
