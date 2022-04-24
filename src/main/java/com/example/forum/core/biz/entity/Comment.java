package com.example.forum.core.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.forum.common.util.RelativeDateFormat;
import com.example.forum.core.sys.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 回复
 */
@Data
@TableName("biz_comment")
public class Comment extends Model<Comment> implements Serializable {


    /**
     * ID，自动生成
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 帖子ID
     */
    private Long postId;

    /**
     * 帖子板块ID
     */
    private Long categoryId;

    /**
     * 回帖人用户ID
     */
    private Long userId;

    /**
     * 帖子用户id
     */
    private Long postUserId;

    /**
     * 被回复人的用户id
     */
    private Long replyUserId;

    /**
     * 回帖内容
     */
    private String commentContent;

    /**
     * 上一级
     */
    private Long pid = 0L;

    /**
     * 关系路径
     */
    private String pathTrace;


    /**
     * 回帖帖子
     */
    @TableField(exist = false)
    private Post post;

    /**
     * 回帖人
     */
    @TableField(exist = false)
    private User user;

    /**
     * 当前回帖下的所有子回帖
     */
    @TableField(exist = false)
    private List<Comment> childComments;

    /**
     * 创建时间
     */
    @TableField(exist = false)
    private String createTimeStr;


    public String getCreateTimeStr() {
        return RelativeDateFormat.format(getCreateTime());
    }
}
