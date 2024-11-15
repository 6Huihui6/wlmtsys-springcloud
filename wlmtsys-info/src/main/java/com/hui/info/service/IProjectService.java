package com.hui.info.service;

import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Project;
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
public interface IProjectService extends IService<Project> {

    /**
     * 获取project列表
     * @return
     */

    List<Project> getProjectList();

    /**
     * 保存project
     * @param project
     */
    void saveProject(Project project);

    /**
     * 删除project
     * @param id
     */
    void deleteProject(Integer id);

    /**
     * 更新project
     * @param project
     */
    void updateProject(Project project);

    /**
     * 分页查询project
     * @param query
     * @return
     */
    PageDTO<Project> queryProjectPage(PageQuery query);

    /**
     * 上传图片
     * @param multipartFile
     */
    ResponseResult uploadNews(MultipartFile multipartFile);

    /**
     * 获取project详情
     * @param id
     * @return
     */
    Project getProject(Integer id);
}
