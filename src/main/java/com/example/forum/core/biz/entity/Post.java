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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author example
 */
@Data
@TableName("biz_post")
public class Post extends Model<Post> implements Serializable {

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
     * 用户ID
     */
    private Long userId;
    /**
     * 帖子标题
     */
    private String postTitle;

    /**
     * 帖子内容 html格式
     */
    private String postContent;

    /**
     * 帖子访问量
     */
    private Long postViews;


    /**
     * 回帖数量(冗余字段，加快查询速度)
     */
    private Long commentSize;

    /**
     * 板块ID
     */
    private Long categoryId;

    /**
     * 分区ID
     */
    private Long areaId;


    /**
     * 发表用户 多对一
     */
    @TableField(exist = false)
    private User user;

    /**
     * 帖子所属板块
     */
    @TableField(exist = false)
    private Category category;


    /**
     * 帖子所属分区
     */
    @TableField(exist = false)
    private Area area;


    /**
     * 帖子的回帖
     */
    @TableField(exist = false)
    private List<Comment> comments = new ArrayList<>();

    /**
     * 更新时间
     */
    @TableField(exist = false)
    private String createTimeStr;

    public String getCreateTimeStr() {
        return RelativeDateFormat.format(getCreateTime());
    }

}