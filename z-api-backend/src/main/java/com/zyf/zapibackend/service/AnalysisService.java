package com.zyf.zapibackend.service;

import com.zyf.zapibackend.model.vo.InterfaceInfoVO;

import java.util.List;

public interface AnalysisService {
    /**
     * 统计调用次数最多的前 interfaceNum 个的接口
     *
     * @param interfaceNum 数量
     * @return 返回对应数量的接口
     */
    List<InterfaceInfoVO> listTopInvokeInterface(Integer interfaceNum);
}
