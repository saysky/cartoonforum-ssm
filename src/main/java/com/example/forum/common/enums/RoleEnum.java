package com.example.forum.common.enums;

/**
 * <pre>
 *     角色类型enum
 * </pre>
 *
 */
public enum RoleEnum {

    /**
     * 管理员
     */
    ADMIN("admin"),

    /**
     * 普通用户
     */
    USER("user"),

    /**
     * 版主
     */
    BANZHU("banzhu");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
