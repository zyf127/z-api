package com.zyf.zapicommon.service;

import com.zyf.zapicommon.model.entity.InterfaceInfo;

public interface InnerInterfaceInfoService {
    /**
     * 根据请求路径和请求方法从数据库中查询接口
     *
     * @param url 请求路径
     * @param method 请求方法
     * @return 接口
     */
    InterfaceInfo getInterfaceInfo(String url, String method);
}
