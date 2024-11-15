package com.hui.info.service;

import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.po.Employ;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
public interface IEmployService extends IService<Employ> {

    /**
     * 获取所有招聘信息
     * @return
     */
    List<Employ> getEmployList(Integer lables);

    /**
     * 保存招聘信息
     * @param employ
     */
    void saveEmploy(Employ employ);

    /**
     * 删除招聘信息
     * @param id
     */
    void deleteEmploy(Integer id);

    /**
     * 更新招聘信息
     * @param employ
     */
    void updateEmploy(Employ employ);

    /**
     * 分页查询招聘信息
     * @param query
     * @return
     */
    PageDTO<Employ> queryEmployPage(PageQuery query);
}
