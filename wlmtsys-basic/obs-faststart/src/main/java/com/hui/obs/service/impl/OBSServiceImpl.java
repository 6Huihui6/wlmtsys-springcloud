package com.hui.obs.service.impl;



import com.hui.obs.service.OBSService;
import com.hui.obs.service.domain.OBS;
import com.hui.obs.service.domain.Uploader;
import com.obs.services.exception.ObsException;
import com.obs.services.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-10-12
 */
@Service
public class OBSServiceImpl implements OBSService {

    /**
     * 保存图片
     */
    public String uploadImage(MultipartFile mpFile, String type)  {
        try {
            String fileName = Uploader.getRandomName(mpFile);
            File tempFile = File.createTempFile("drawu",fileName);
            mpFile.transferTo(tempFile);
            PutObjectRequest request = new PutObjectRequest();
            request.setFile(tempFile);
            request.setBucketName("drawu");
            request.setObjectKey(type + tempFile.getName());
            OBS.client.putObject(request);
            String obsUrl = "https://drawu.obs.cn-south-1.myhuaweicloud.com/images/" + tempFile.getName();
            return obsUrl;
        } catch (ObsException e) {
            System.out.println("putObject failed");
            // 请求失败,打印http状态码
            System.out.println("HTTP Code:" + e.getResponseCode());
            // 请求失败,打印服务端错误码
            System.out.println("Error Code:" + e.getErrorCode());
            // 请求失败,打印详细错误信息
            System.out.println("Error Message:" + e.getErrorMessage());
            // 请求失败,打印请求id
            System.out.println("Request ID:" + e.getErrorRequestId());
            System.out.println("Host ID:" + e.getErrorHostId());
        } catch (Exception e) {
            System.out.println("putObject failed");
            // 其他异常信息打印
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存图片
     *
     * @param images 图片列表
     * @param id
     */
//    @Override
//    public void saveImages(List<String> images, Integer id) {
//        for (String image : images) {
//            Images img = new Images();
//            img.setUrl(image);
//            img.setTypeId(id);
//            this.save(img);
//        }
//    }
}
