package com.example.forum.common.enums;

/**
 * <pre>
 *     帖子状态enum
 * </pre>
 *
 * @author : saysky
 * @date 2022/4/16
 */
public enum PostStatusEnum {

    /**
     * 已发布
     */
    PUBLISHED(0),

    /**
     * 草稿
     */
    DRAFT(1),

    /**
     * 回收站
     */
    RECYCLE(2),

    /**
     * 待审核
     */
    CHECKING(3);

    private Integer code;

    PostStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
