package com.zyf.zapibackend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zyf.zapicommon.model.entity.InterfaceInfo;

/**
* @author zyf
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验
     *
     * @param interfaceInfo 接口信息
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
