package com.hui.user.service.impl;

import com.hui.model.user.po.UserDetail;
import com.hui.user.mapper.UserDetailMapper;
import com.hui.user.service.IUserDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教师详情表 服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-17
 */
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

    private final UserDetailMapper userDetailMapper;
    /**
     * 根据ids查询用户详情
     *
     * @param ids
     */
    @Override
    public List<UserDetail> queryByIds(List<Integer> ids) {
        return userDetailMapper.selectBatchIds(ids);
    }
}
