package com.zyf.zapibackend.service;

import com.zyf.zapibackend.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zyf
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验
     *
     * @param userInterfaceInfo 用户调用接口关系信息
     * @param add 是否为创建校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用次数统计
     *
     * @param userId 用户 id
     * @param interfaceInfoId 接口 id
     * @return 是否调用成功
     */
    boolean invokeCount(Long userId, Long interfaceInfoId);
}
