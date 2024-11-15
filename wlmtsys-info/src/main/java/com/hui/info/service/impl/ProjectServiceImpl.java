package com.hui.info.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Project;
import com.hui.info.mapper.ProjectMapper;
import com.hui.info.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.obs.service.OBSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
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
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {



    private final OBSService obsService;

    /**
     * 获取project列表
     *
     * @return
     */
    @Override
    public List<Project> getProjectList() {
        List<Project> projectsList = list();
        return projectsList;
    }

    /**
     * 保存project
     *
     * @param project
     */
    @Override
    public void saveProject(Project project) {
        if (project != null && project.getContent() != null && project.getTitle() != null) {
            project.setCreateTime(LocalDateTime.now());
            save(project);
        }
    }

    /**
     * 删除project
     *
     * @param id
     */
    @Override
    public void deleteProject(Integer id) {
        if (id != null) {
            removeById(id);
        }
    }

    /**
     * 更新project
     *
     * @param project
     */
    @Override
    public void updateProject(Project project) {
        if (project != null && project.getId() != null) {
            project.setCreateTime(LocalDateTime.now());
            updateById(project);
        }
    }

    /**
     * 分页查询project
     *
     * @param query
     * @return
     */
    @Override
    public PageDTO<Project> queryProjectPage(PageQuery query) {
        Page<Project> page = this.lambdaQuery()
                .like(query.getTitle() != null, Project::getTitle, query.getTitle())
                .like(query.getContent() != null, Project::getContent, query.getContent())
                .orderByDesc(Project::getCreateTime)
                .page(query.toMpPage("date", false));
        List<Project> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return PageDTO.empty(page);
        }
        List<Project> Projects = new ArrayList<>();
        for (Project news : records) {
            Project Project = BeanUtils.copyBean(news, Project.class);
            Projects.add(Project);
        }
        return PageDTO.of(page, Projects);
    }

    /**
     * 上传图片
     *
     * @param multipartFile
     */
    @Override
    public ResponseResult uploadNews(MultipartFile multipartFile) {
        //1.检查参数
        if(multipartFile == null || multipartFile.getSize() == 0 ){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        String image = obsService.uploadImage(multipartFile, "project");
        return ResponseResult.okResult(image);
    }

    /**
     * 获取project详情
     *
     * @param id
     * @return
     */
    @Override
    public Project getProject(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        return getById(id);
    }
}
