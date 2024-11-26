package com.hui.info.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.info.service.IImagesService;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Info;
import com.hui.info.mapper.InfoMapper;
import com.hui.info.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.obs.service.OBSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    private final OBSService obsService;

    /**
     * 获取实验室介绍信息
     *
     * @return
     */
    @Override
    public ResponseResult getLabIntro() {
        List<Info> list =  list();
        log.info("实验室介绍信息：{}",list);
        return ResponseResult.okResult(list);
    }

    /**
     * 更新实验室介绍信息
     *
     * @param Info
     */
    @Override
    public void updateLabInfo(Info Info) {
        Info.setCreateTime(LocalDateTime.now());
        updateById(Info);

    }

    /**
     * 添加实验室介绍信息
     *
     * @param Info
     */
    @Override
    public void addLabInfo(Info Info) {
        if (!StrUtil.isEmpty(Info.getTitle())) {
            Info.setCreateTime(LocalDateTime.now());
            log.info("添加实验室介绍信息：{}",Info);
            save(Info);
        }
    }

    /**
     * 删除实验室介绍信息
     *
     * @param id
     */
    @Override
    public void deleteLabInfo(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        if (id != null) {
            log.info("删除实验室介绍信息：{}", id);
            removeById(id);
        }
    }

    /**
     * 分页查询实验室介绍信息
     *
     * @param query
     * @return
     */
    @Override
    public PageDTO<Info> queryEmployPage(PageQuery query) {
        Page<Info> page = this.lambdaQuery()
                .like(query.getContent1() != null, Info::getContent1, query.getContent1())
                .like(query.getContent2() != null, Info::getContent2, query.getContent2())
                .like(query.getAddress() != null, Info::getAddress, query.getAddress())
                .page(new Page<>(query.getPageNo(), query.getPageNo()));
        List<Info> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return PageDTO.empty(page);
        }
        List<Info> wlmtsysProjects = new ArrayList<>();
        for (Info news : records) {
            Info wlmtsysProject = BeanUtils.copyBean(news, Info.class);
            wlmtsysProjects.add(wlmtsysProject);
        }
        return PageDTO.of(page, wlmtsysProjects);
    }

    /**
     * 上传图片
     *
     * @param multipartFile
     */
    @Override
    public ResponseResult uploadNews(MultipartFile multipartFile,Integer id) {
        //1.检查参数
        if(multipartFile == null || multipartFile.getSize() == 0 ){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        String imageUrl = obsService.uploadImage(multipartFile, "info");
        log.info("上传图片到MinIO中，imageUrl:{}",imageUrl);
        //3.更新数据库
        this.lambdaUpdate().eq(Info::getId,id).set(Info::getWeimg,imageUrl).update();
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * @param multipartFile
     * @param weimgId
     * @return
     */
    @Override
    public ResponseResult uploadNewsWe(MultipartFile multipartFile, Integer weimgId) {
        //1.检查参数
        if(multipartFile == null || multipartFile.getSize() == 0 || weimgId == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        String imageUrl = obsService.uploadImage(multipartFile, "info");
        log.info("上传图片到MinIO中，imageUrl:{}",imageUrl);

        //3.更新数据库
        this.lambdaUpdate().eq(Info::getId,weimgId).set(Info::getWeimg,imageUrl).update();
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 获取实验室介绍信息
     *
     * @param id
     * @return
     */
    @Override
    public Info getLabInfo(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        Info Info = getById(id);
        if (Info != null) {
            log.info("获取实验室介绍信息：{}",Info);
            return Info;
        }
        return Info;
    }
}
