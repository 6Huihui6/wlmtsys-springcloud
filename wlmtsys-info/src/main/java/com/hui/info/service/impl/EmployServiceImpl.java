package com.hui.info.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.common.utils.UserContext;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Applications;
import com.hui.model.info.po.Employ;
import com.hui.info.mapper.EmployMapper;
import com.hui.info.service.IEmployService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class EmployServiceImpl extends ServiceImpl<EmployMapper, Employ> implements IEmployService {



    /**
     * 获取所有招聘信息
     *
     */
    @Override
    public List<Employ> getEmployList(Integer lables) {
        return this.lambdaQuery().eq(Employ::getLabel, lables).orderByDesc(Employ::getCreateTime).list();
    }

    /**
     * 保存招聘信息
     *
     */
    @Override
    public void saveEmploy(Employ employ) {
        if (employ.getLabel() != null){
            employ.setCreateTime(LocalDateTime.now());
            this.save(employ);
        }

    }

    /**
     * 删除招聘信息
     *
     */
    @Override
    public void deleteEmploy(Integer id) {
        if (id!= null) {
            this.removeById(id);
        }
    }

    /**
     * 更新招聘信息
     *
     */
    @Override
    public void updateEmploy(Employ employ) {
        if (employ.getId() != null) {
            employ.setCreateTime(LocalDateTime.now());
            this.updateById(employ);
        }
    }

    /**
     * 分页查询招聘信息
     */
    @Override
    public PageDTO<Employ> queryEmployPage(PageQuery query) {
        Page<Employ> page = this.lambdaQuery()
                .like(query.getTitle()!=null,Employ::getTitle,query.getTitle())
                .eq(query.getLabel()!=null,Employ::getLabel, query.getLabel())
                .like(query.getRequirement()!=null,Employ::getRequirement, query.getRequirement())
                .orderByDesc(Employ::getCreateTime)
                .page(query.toMpPage("create_time", false));
        List<Employ> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return PageDTO.empty(page);
        }
        List<Employ> employList = new ArrayList<>();
        for (Employ news : records) {
            Employ employ = BeanUtils.copyBean(news, Employ.class);
            employList.add(employ);
        }
        return PageDTO.of(page, employList);
    }

    /**
     * 开启或关闭招聘
     *
     * @param status
     */
    @Override
    public ResponseResult openOrCloseRecruiting(Integer status) {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        if (status == 1) {
            lambdaUpdate().set(Employ::getStatus, status).update();
        }
        if (status == 0) {
            lambdaUpdate().set(Employ::getStatus, status).update();
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
