package com.zyf.zapibackend.controller;

import com.zyf.zapibackend.annotation.AuthCheck;
import com.zyf.zapibackend.common.BaseResponse;
import com.zyf.zapibackend.common.ErrorCode;
import com.zyf.zapibackend.common.ResultUtils;
import com.zyf.zapibackend.exception.BusinessException;
import com.zyf.zapibackend.model.vo.InterfaceInfoVO;
import com.zyf.zapibackend.service.AnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private AnalysisService analysisService;

    /**
     * 统计调用次数最多的前 interfaceNum 个的接口
     *
     * @param interfaceNum 数量
     * @return 返回对应数量的接口
     */
    @AuthCheck(mustRole = "admin")
    @GetMapping("/top/invoke/interface")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterface(Integer interfaceNum) {
        if (interfaceNum == null || interfaceNum <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = analysisService.listTopInvokeInterface(interfaceNum);
        return ResultUtils.success(interfaceInfoVOList);
    }
}
