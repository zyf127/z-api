package com.zyf.zapibackend.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInterfaceInfoAddRequest implements Serializable {
    private static final long serialVersionUID = -4162141692119795509L;

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
}
