package com.zyf.zapibackend.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    private static final long serialVersionUID = 3775624440186273052L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 请求参数
     */
    private String userRequestParams;
}
