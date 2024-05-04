package com.zyf.zapicommon.service;

import com.zyf.zapicommon.model.entity.User;

public interface InnerUserService {
    /**
     * 根据 accessKey 从数据库中查询用户
     *
     * @param accessKey 标识 accessKey
     * @return 用户
     */
    User getInvokeUser(String accessKey);
}
