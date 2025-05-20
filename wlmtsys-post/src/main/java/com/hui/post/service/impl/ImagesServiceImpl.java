package com.hui.post.service.impl;

import com.hui.model.post.po.Images;
import com.hui.obs.service.OBSService;
import com.hui.post.mapper.ImagesMapper;
import com.hui.post.service.IImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2024-11-19
 */
@Service
@RequiredArgsConstructor
public class ImagesServiceImpl extends ServiceImpl<ImagesMapper, Images> implements IImagesService {

    private final OBSService obsService;

    /**
     * 上传图片
     */
    @Override
    public String upload(MultipartFile multipartFile) {
        return obsService.uploadImage(multipartFile,"post");
    }

    /**
     * 保存图片
     *
     */
    @Override
    public void saveImages(List<String> image, Integer postId) {
        for (String url : image) {
            Images img = new Images();
            img.setUrl(url);
            img.setPostId(postId);
            this.save(img);
        }
    }
}
