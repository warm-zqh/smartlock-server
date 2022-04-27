package com.ahead.smartlock.manage.mapper;

import com.ahead.smartlock.manage.entity.User;
import com.ahead.smartlock.manage.params.VerifyUserPageFilterParam;
import com.ahead.smartlock.manage.response.VerifyUserResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zqh
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取礼品赠送总数
     *
     * @param filter    筛选参数
     * @return 礼品赠送信息总数
     */
    Long getCount(@Param("filter") VerifyUserPageFilterParam filter);

    /**
     * 礼品赠送信息查询分页
     *
     * @param startIndex 起始页
     * @param size       当前页记录总数
     * @param filter     筛选参数
     * @return 数据传输对象集合
     */
    List<VerifyUserResponse> searchPage(@Param("startIndex") Long startIndex, @Param("size") Long size, @Param("filter") VerifyUserPageFilterParam filter);
}
