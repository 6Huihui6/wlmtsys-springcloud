package com.hui.info.service;


import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Info;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
public interface IInfoService extends IService<Info> {

    /**
     * 获取实验室介绍信息
     *
     * @return
     */
    List<Info> getLabIntro();

    /**
     * 更新实验室介绍信息
     * @param Info
     */
    void updateLabInfo(Info Info);

    /**
     * 添加实验室介绍信息
     * @param Info
     */
    void addLabInfo(Info Info);

    /**
     * 删除实验室介绍信息
     * @param id
     */
    void deleteLabInfo(Integer id);

    /**
     * 分页查询实验室介绍信息
     * @param query
     * @return
     */
    PageDTO<Info> queryEmployPage(PageQuery query);

    /**
     * 上传图片
     * @param multipartFile
     * @param imageId
     */
    ResponseResult uploadNews(MultipartFile multipartFile, Integer imageId);

    ResponseResult uploadNewsWe(MultipartFile multipartFile, Integer weimgId);

    /**
     * 获取实验室介绍信息
     * @param id
     * @return
     */
    Info getLabInfo(Integer id);
}
