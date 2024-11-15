package com.hui.info.service;

import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.News;
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
public interface INewsService extends IService<News> {



    /**
     * 获取新闻列表
     * @return
     */
    List<News> getNewsList(Integer lables);

    /**
     * 添加新闻
     * @param news
     */
    void addNews(News news);

    /**
     * 删除新闻
     * @param id
     */
    void deleteNews(Integer id);

    /**
     * 更新新闻
     * @param news
     */
    ResponseResult updateNews(News news);

    /**
     * 分页查询新闻
     * @param query
     * @return
     */
    PageDTO<News> queryNewsPage(PageQuery query);

    /**
     * 图片上传
     * @param multipartFile
     */
    ResponseResult uploadNews(MultipartFile multipartFile, Integer newsId);

    /**
     * 图片
     * @param multipartFile
     * @return
     */
    String upload(MultipartFile multipartFile);
}
