package com.zyf.zapibackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author zyf
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -7868580347498626969L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
