package com.zyf.zapibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyf.zapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author zyf
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> selectTopList(Integer interfaceNum);
}




