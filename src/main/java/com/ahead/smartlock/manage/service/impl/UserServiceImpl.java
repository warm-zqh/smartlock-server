package com.ahead.smartlock.manage.service.impl;

import com.ahead.smartlock.core.utils.DataConverterUtils;
import com.ahead.smartlock.manage.entity.User;
import com.ahead.smartlock.manage.mapper.UserMapper;
import com.ahead.smartlock.manage.params.VerifyUserPageFilterParam;
import com.ahead.smartlock.manage.response.VerifyUserResponse;
import com.ahead.smartlock.manage.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zqh
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Page<VerifyUserResponse> getPage(Long page, Long size, VerifyUserPageFilterParam filterParam) {
        //计算查询分页开始页
        if (page < 1L) {
            page = 1L;
        }
        Long startIndex = (page - 1) * size;
        List<VerifyUserResponse> responses = userMapper.searchPage(startIndex, size, filterParam);
        Long count = userMapper.getCount(filterParam);
        return DataConverterUtils.convertPage(responses, page, size, count);
/*        Page<VerifyUserResponse> responsePage = DataConverterUtils.convertPage(userMapper.selectPage(new Page<>(page, size), new LambdaQueryWrapper<User>()
                .like(StringUtils.hasText(filterParam.getName()), User::getName, filterParam.getName())
                .like(StringUtils.hasText(filterParam.getPhone()), User::getTelephoneNumber, filterParam.getPhone())
                .like(StringUtils.hasText(filterParam.getStatus()), User::getStatus, filterParam.getStatus())), VerifyUserResponse.class);
        //宿舍信息
        List<String> dormitoryIds = responsePage.getRecords().stream().map(VerifyUserResponse::getDormitoryId).distinct().collect(Collectors.toList());
        //班级信息
        List<String> classIds = responsePage.getRecords().stream().map(VerifyUserResponse::getClassId).distinct().collect(Collectors.toList());
        //学院信息
        List<String> collegeIds = responsePage.getRecords().stream().map(VerifyUserResponse::getCollegeId).distinct().collect(Collectors.toList());
        responsePage.getRecords().forEach(response -> {
            // TODO 宿舍 班级 学院信息
        });
        return responsePage;*/
    }
}
