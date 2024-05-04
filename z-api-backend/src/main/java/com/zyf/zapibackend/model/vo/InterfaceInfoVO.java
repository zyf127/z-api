package com.zyf.zapibackend.model.vo;

import com.zyf.zapicommon.model.entity.InterfaceInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class InterfaceInfoVO extends InterfaceInfo implements Serializable {
    private static final long serialVersionUID = -2022470923673623159L;
    /**
     * 调用次数
     */
    private Integer usedNum;
}
