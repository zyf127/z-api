package com.zyf.zapibackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyf.zapibackend.common.ErrorCode;
import com.zyf.zapibackend.exception.BusinessException;
import com.zyf.zapibackend.mapper.InterfaceInfoMapper;
import com.zyf.zapibackend.mapper.UserInterfaceInfoMapper;
import com.zyf.zapibackend.model.vo.InterfaceInfoVO;
import com.zyf.zapibackend.service.AnalysisService;
import com.zyf.zapicommon.model.entity.InterfaceInfo;
import com.zyf.zapicommon.model.entity.UserInterfaceInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public List<InterfaceInfoVO> listTopInvokeInterface(Integer interfaceNum) {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.selectTopList(interfaceNum);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream().collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjMap.keySet());
        List<InterfaceInfo> interfaceInfoList = interfaceInfoMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(interfaceInfoList)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return interfaceInfoList.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            interfaceInfoVO.setUsedNum(interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getUsedNum());
            return interfaceInfoVO;
        }).collect(Collectors.toList());
    }
}
