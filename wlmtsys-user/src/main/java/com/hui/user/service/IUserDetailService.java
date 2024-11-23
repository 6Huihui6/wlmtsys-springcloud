package com.hui.user.service;

import com.hui.model.user.po.UserDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 教师详情表 服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-17
 */
public interface IUserDetailService extends IService<UserDetail> {

    /**
     * 根据ids查询用户详情
     */
    List<UserDetail> queryByIds(List<Integer> ids);
}
