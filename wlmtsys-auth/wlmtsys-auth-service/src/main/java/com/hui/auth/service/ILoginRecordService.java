package com.hui.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.model.auth.po.LoginRecord;


/**
 * <p>
 * 登录信息记录表 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-07-12
 */
public interface ILoginRecordService extends IService<LoginRecord> {

    void saveAsync(LoginRecord record);

    void loginSuccess(String email, Long userId);
}
