package com.hui.info.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.News;
import com.hui.info.mapper.NewsMapper;
import com.hui.info.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.obs.service.OBSService;
import com.obs.services.internal.ObsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {


    private final OBSService obsService;



    /**
     * 获取新闻列表
     *
     * @return
     */
    @Override
    public List<News> getNewsList(Integer lables ) {
        List<News> newsList =this.lambdaQuery().eq(News::getLabel,lables)
                .orderByDesc(News::getDate).list();
        return newsList;
    }

    /**
     * 添加新闻
     *
     * @param news
     */
    @Override
    public void addNews(News news) {
        if (news != null&&news.getDate() != null&&news.getTitle() != null&&news.getContent() != null) {
            this.save(news);
        }else{
            throw new IllegalArgumentException("news is null or date is null or title is null or content is null");
        }

    }

    /**
     * 删除新闻
     *
     * @param id
     */
    @Override
    public void deleteNews(Integer id) {
        if (id == null) {
            log.error("id is null");
            return;
        }
        log.info("deleteNews:{}", id);
        this.removeById(id);
    }

    /**
     * 更新新闻
     *
     * @param news
     */
    @Override
    public ResponseResult updateNews(News news) {
        if (news == null) {
            log.error("news is null");
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        log.info("updateNews:{}", news);
        this.updateById(news);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 分页查询新闻
     *
     * @param query
     * @return
     */
    @Override
    public PageDTO<News> queryNewsPage(PageQuery query) {
        Page<News> page = this.lambdaQuery()
                .eq(query.getLabel() != null, News::getLabel,query.getLabel())
                .like(query.getContent() != null, News::getContent, query.getContent())
                .between(query.getBeginTime() != null && query.getEndTime() != null,
                        News::getDate, query.getBeginTime(), query.getEndTime())
                .orderByDesc(News::getDate)
                .page(query.toMpPage("date", false));
        List<News> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return PageDTO.empty(page);
        }
        List<News> News = new ArrayList<>();
        for (News news : records) {
            News News1 = BeanUtils.copyBean(news, News.class);
            News.add(News1);
        }
        return PageDTO.of(page, News);
    }

    /**
     * 图片上传
     *
     * @param multipartFile
     */
    @Override
    public ResponseResult uploadNews(MultipartFile multipartFile, Integer newsId) {
        //1.检查参数
        if(multipartFile == null || multipartFile.getSize() == 0 || newsId == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        String image = obsService.uploadImage(multipartFile, "news");

        //3.更新数据库
        this.lambdaUpdate().eq(News::getId,newsId).set(News::getImage,image).update();
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);

    }

    /**
     * 图片
     *
     * @param multipartFile
     * @return
     */
    @Override
    public String upload(MultipartFile multipartFile) {
        return  obsService.uploadImage(multipartFile, "news");
    }


}
