package com.hui.info.controller;


import com.hui.info.service.IApplicationsService;
import com.hui.model.info.dtos.ApplicationsDto;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.query.ApplicatePageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-11-24
 */
@Api(tags = "申请管理")
@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationsController {

    private final IApplicationsService applicationsService;

//    @ApiOperation(value = "查询当前是否在招新")
    @GetMapping("/employStatus")
    @ApiIgnore
    public ResponseResult isRecruiting() {
        return applicationsService.isRecruiting();
    }


    @ApiOperation("分页查询当前申请信息---可通过keyword、status、参数进行查询，keyword为搜索关键字，status为1为待审核，2为已通过，3为未通过")
    @GetMapping("/pageInfo")
    public ResponseResult recruitingInfo( ApplicatePageQuery query) {
        return applicationsService.recruitingInfo(query);
    }

    @ApiOperation("申请加入招新")
    @PostMapping("/apply")
    public ResponseResult apply(@RequestBody ApplicationsDto dto) {
        return applicationsService.apply(dto);
    }

    @ApiOperation("查询当前用户的申请状态")
    @GetMapping("/applyStatus")
    public ResponseResult applyStatus() {
        return applicationsService.applyStatus();
    }

    @ApiOperation("admin-处理用户的申请------status为1为待审核，2为已通过，3为未通过" +
            "处理后会自动发送邮件通知给用户")
    @PostMapping("/handleApply")
    public ResponseResult handleApply(@RequestParam("applicationId") Integer applicationId, @RequestParam("status") Integer status) {
        return applicationsService.handleApply(applicationId,status);
    }

    @ApiOperation("根据id查询删除用户的申请信息")
    @DeleteMapping("/deleteApply")
    public ResponseResult deleteApply(@RequestParam("applicationId") Integer applicationId) {
        return applicationsService.deleteApply(applicationId);
    }

}
