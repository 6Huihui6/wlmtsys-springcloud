package com.hui.obs.service.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Uploader {

    public static String getRandomName(MultipartFile mpFile) throws IOException {
        String extension = mpFile.getOriginalFilename();
        return extension;
    }

//    public static File getUploadFile() {
//        File convFile = File.createTempFile("", extension);
//        // 将MultipartFile的内容保存到临时文件
//        file.transferTo(convFile);
//    }

}
