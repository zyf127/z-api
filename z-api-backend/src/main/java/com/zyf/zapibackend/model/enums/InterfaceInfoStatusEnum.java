package com.zyf.zapibackend.model.enums;

/**
 * 接口信息状态枚举
 */
public enum InterfaceInfoStatusEnum {
    OFFLINE(0, "下线"),
    ONLINE(1, "上线");
    private final int value;
    private final String text;

    InterfaceInfoStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
