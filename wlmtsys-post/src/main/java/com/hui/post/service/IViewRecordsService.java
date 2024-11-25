package com.hui.post.service;

import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.post.po.ViewRecords;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-25
 */
public interface IViewRecordsService extends IService<ViewRecords> {

    /**
     * 添加阅读记录
     * @param postId
     */
    ResponseResult addViewRecord(Integer postId);
}
