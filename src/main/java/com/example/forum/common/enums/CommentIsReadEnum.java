package com.example.forum.common.enums;

/**
 * <pre>
 *     评论已读状态enum
 * </pre>
 *
 * @author : saysky
 * @date 2022/4/16
 */
public enum CommentIsReadEnum {

    /**
     * 已读
     */
    READ(1),

    /**
     * 未读
     */
    NOT_READ(0);

    private Integer code;

    CommentIsReadEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
