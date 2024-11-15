package com.hui.info.controller;


import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.info.service.IProjectService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Project;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "项目管理")
@RequestMapping("/project")
public class ProjectController {


    private final IProjectService projectsService;


    @ApiOperation(value = "新增项目接口", notes = "新增项目接口")
    @PostMapping("/save")
    public void addProject(@RequestBody Project project) {
        log.info("新增项目接口");
        projectsService.saveProject(project);
    }

    @ApiOperation(value = "删除项目接口", notes = "删除项目接口")
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Integer id) {
        log.info("删除项目接口");
        projectsService.deleteProject(id);
    }


    @ApiOperation(value = "修改项目接口", notes = "修改项目接口")
    @PutMapping("/update")
    public void updateProject(@RequestBody Project project) {
        log.info("修改项目接口");
        projectsService.updateProject(project);
    }

    @ApiOperation(value = "项目分页查询接口", notes = "项目分页查询接口")
    @GetMapping("/page")
    public PageDTO<Project> queryNewsPage(PageQuery query) {
        log.info("项目分页查询接口");
        return projectsService.queryProjectPage(query);
    }


    @ApiOperation(value = "项目详情查询接口", notes = "项目详情查询接口")
    @GetMapping("/{id}")
    public ResponseResult getProject(@PathVariable Integer id) {
        log.info("项目详情查询接口,id:{}", id);
        Project project = projectsService.getProject(id);
        return ResponseResult.okResult(project);
    }

    @ApiOperation(value = "图片上传接口", notes = "图片上传接口")
    @PostMapping("/upload")
    public ResponseResult uploadNews(@RequestParam("file") MultipartFile multipartFile ) {
        log.info("图片接口,{},id:{}", multipartFile );
        return  projectsService.uploadNews(multipartFile);
    }


    @ApiOperation(value = "项目查询接口", notes = "项目查询接口")
    @GetMapping("/list")
    public ResponseResult getProjectList() {
        log.info("项目查询接口");
        List<Project> list = projectsService.getProjectList();
        return ResponseResult.okResult(list);
    }


}
