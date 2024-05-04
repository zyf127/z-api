package com.zyf.zapibackend.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyf.zapibackend.mapper.UserMapper;
import com.zyf.zapicommon.model.entity.User;
import com.zyf.zapicommon.service.InnerUserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("access_key", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
