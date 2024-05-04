package com.zyf.zapicommon.service;

public interface InnerUserInterfaceInfoService {
    /**
     * 调用次数统计
     *
     * @param userId 用户 id
     * @param interfaceInfoId 接口 id
     * @return 是否调用成功
     */
    boolean invokeCount(Long userId, Long interfaceInfoId);

    /**
     * 获取剩余调用次数
     *
     * @param userId 用户 id
     * @param interfaceInfoId 接口 id
     * @return 剩余调用次数
     */
    Integer getLeftNum(Long userId, Long interfaceInfoId);
}
