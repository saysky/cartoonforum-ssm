package com.example.forum.core.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.forum.core.sys.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     帖子板块
 * </pre>
 *
 * @author : saysky
 * @date 2022/4/16
 */
@Data
@TableName("biz_category")
public class Category extends Model<Category> implements Serializable {


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
     * 板块名称
     */
    private String name;

    /**
     * 分区ID
     */
    private Long areaId;

    /**
     * 版主用户id
     */
    private Long banzhuUserId;

    @TableField(exist = false)
    private Area area;

    @TableField(exist = false)
    private User banzhuUser;
}
