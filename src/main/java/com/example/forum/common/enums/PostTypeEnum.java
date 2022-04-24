package com.example.forum.common.enums;

/**
 * <pre>
 *     帖子类型enum
 * </pre>
 *
 * @author : saysky
 * @date 2022/4/16
 */
public enum PostTypeEnum {

    /**
     * 帖子
     */
    POST_TYPE_POST("post"),

    /**
     * 页面
     */
    POST_TYPE_PAGE("page"),

    /**
     * 公告
     */
    POST_TYPE_NOTICE("notice");

    private String value;

    PostTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
