package com.zyf.zapibackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 包含 id 的请求
 *
 * @author zyf
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}