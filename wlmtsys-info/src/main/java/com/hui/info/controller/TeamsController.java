package com.hui.info.controller;


import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.info.service.ITeamsService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Teams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Api(tags = "团队管理")
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamsController {


    private final ITeamsService teamsService;


    @ApiOperation(value = "团队查询接口")
    @GetMapping("/list/{depart}")
    public ResponseResult geTeamsList(@PathVariable("depart") Integer depart) {
        log.info("团队查询接口");
        List<Teams> list = teamsService.getTeamsList(depart);
        return ResponseResult.okResult(list);
    }
    @ApiOperation(value = "admin----团队成员新增接口")
    @PostMapping("/add")
    public  void saveTeam(@RequestBody Teams Teams){
        log.info("admin----团队成员新增接口");
        teamsService.saveTeam(Teams);
    }

    @ApiOperation(value = "admin----团队成员删除接口")
    @DeleteMapping("/delete/{id}")
    public  void deleteTeam(@PathVariable("id") Integer id){
        log.info("admin----团队成员删除接口");
        teamsService.deleteTeam(id);
    }

    @ApiOperation(value = "admin----团队成员修改接口")
    @PutMapping("/update")
    public  void updateTeam(@RequestBody Teams Teams){
        log.info("admin----团队成员修改接口");
        teamsService.updateTeam(Teams);
    }


    @ApiOperation(value = "admin---团队成员分页查询接口")
    @GetMapping("/page")
    public PageDTO<Teams> queryNewsPage(PageQuery query) {
        log.info("团队成员分分页查询接口");
        return teamsService.queryProjectPage(query);
    }


    @ApiOperation(value = "admin---团队成员ID查询接口")
    @GetMapping("/{id}")
    public ResponseResult getTeamById(@PathVariable("id") Integer id) {
        log.info("admin---团队成员ID查询接口");
        Teams Teams = teamsService.getTeamById(id);
        return ResponseResult.okResult(Teams);
    }

    @ApiOperation(value = "图片接口")
    @PostMapping("/upload")
    public ResponseResult uploadNews(@RequestParam("file") MultipartFile multipartFile) {
        log.info("图片接口,{},id:{}", multipartFile);
        return    teamsService.upload(multipartFile);

    }
}
