package com.zyf.zapibackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyf.zapibackend.common.ErrorCode;
import com.zyf.zapibackend.exception.BusinessException;
import com.zyf.zapibackend.model.entity.UserInterfaceInfo;
import com.zyf.zapibackend.service.UserInterfaceInfoService;
import com.zyf.zapibackend.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author zyf
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，条件校验
        if (add) {
           if (userInterfaceInfo.getUserId() <= 0 || userInterfaceInfo.getInterfaceInfoId() <= 0) {
               throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户或接口不存在");
           }
        }
       if (userInterfaceInfo.getLeftNum() < 0) {
           throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
       }
    }

    @Override
    public boolean invokeCount(Long userId, Long interfaceInfoId) {
        // 判断
        if (userId == null || interfaceInfoId == null || userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 更新调用次数
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setSql("used_num = used_num + 1, left_num = left_num - 1");
        updateWrapper.eq("user_id", userId);
        updateWrapper.eq("interface_info_id", interfaceInfoId);
        updateWrapper.gt("left_num", 0);
        return this.update(updateWrapper);
    }
}




