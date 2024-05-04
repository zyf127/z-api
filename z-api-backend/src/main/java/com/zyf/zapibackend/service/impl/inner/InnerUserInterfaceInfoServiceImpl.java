package com.zyf.zapibackend.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyf.zapibackend.service.UserInterfaceInfoService;
import com.zyf.zapicommon.model.entity.UserInterfaceInfo;
import com.zyf.zapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Override
    public boolean invokeCount(Long userId, Long interfaceInfoId) {
        return userInterfaceInfoService.invokeCount(userId, interfaceInfoId);
    }

    @Override
    public Integer getLeftNum(Long userId, Long interfaceInfoId) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("interface_info_id", interfaceInfoId);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoService.getOne(queryWrapper);
        return userInterfaceInfo.getLeftNum();
    }
}
