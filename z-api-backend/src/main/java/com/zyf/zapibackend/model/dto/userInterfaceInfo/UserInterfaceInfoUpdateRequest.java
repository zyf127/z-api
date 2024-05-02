package com.zyf.zapibackend.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {
    private static final long serialVersionUID = -5030817921808421849L;

    /**
     * 主键
     */
    private Long id;

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
