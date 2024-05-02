package com.zyf.zapibackend.model.dto.userInterfaceInfo;

import com.zyf.zapibackend.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = -6829355186693022778L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 已调用次数
     */
    private Integer usedNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;
}
