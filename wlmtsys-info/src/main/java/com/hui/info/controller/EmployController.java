package com.hui.info.controller;



import com.hui.info.service.IEmployService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Employ;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "招聘接口")
@RequiredArgsConstructor
@RequestMapping("/employ")
public class EmployController {


    private final IEmployService employService;

    @ApiOperation("开启招新或关闭招新某个岗位接口----0:关闭招新，1:开启招新")
    @GetMapping("/openOrCloseRecruiting")
    public ResponseResult openOrCloseRecruiting(@RequestParam("status") Integer status)  {
        return employService.openOrCloseRecruiting(status);
    }

    @ApiOperation("admin---新增招聘信息接口")
    @PostMapping("/add")
    public void addEmploy( @RequestBody Employ employ) {
        log.info("新增招聘信息接口");
        employService.saveEmploy(employ);
    }



    @ApiOperation("admin---删除招聘信息接口")
    @DeleteMapping("/delete/{id}")
    public void deleteEmploy(@PathVariable("id") Integer id) {
        log.info("删除招聘信息接口");
        employService.deleteEmploy(id);
    }

    @ApiOperation("admin---更新招聘信息接口")
    @PutMapping("/update")
    public void updateEmploy(@RequestBody Employ employ) {
        log.info("更新招聘信息接口");
        employService.updateEmploy(employ);
    }

    @ApiOperation("admin---分页 获取招聘信息接口")
    @GetMapping("/page")
    public PageDTO<Employ> queryNewsPage(PageQuery query){
        log.info("分页 获取招聘信息接口");
        return employService.queryEmployPage(query);
    }

    @ApiOperation("招聘查询接口,lable为标签，1:大一，2:大二，3:大三")
    @GetMapping("/list/{lables}")
    public ResponseResult getEmployList(@PathVariable("lables") Integer lables) {
        log.info("招聘查询接口");
        List<Employ> list = employService.getEmployList(lables);
        return ResponseResult.okResult(list);
    }




}
