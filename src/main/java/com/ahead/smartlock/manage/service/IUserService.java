package com.ahead.smartlock.manage.service;

import com.ahead.smartlock.manage.entity.User;
import com.ahead.smartlock.manage.params.VerifyUserPageFilterParam;
import com.ahead.smartlock.manage.response.VerifyUserResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author zqh
 */
public interface IUserService extends IService<User> {
    /**
     * 分页查询
     *
     * @param page        页数
     * @param size        每页条数
     * @param filterParam 筛选参数
     * @return 查询结果
     */
    Page<VerifyUserResponse> getPage(Long page, Long size, VerifyUserPageFilterParam filterParam);
}
