package com.example.forum.core.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     帖子分区
 * </pre>
 *
 * @author : saysky
 * @date 2022/4/16
 */
@Data
@TableName("biz_area")
public class Area extends Model<Area> implements Serializable {


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
     * 区域名称
     */
    private String name;

    /**
     * 板块列表
     */
    @TableField(exist = false)
    private List<Category> categoryList;

    /**
     * 帖子列表
     */
    @TableField(exist = false)
    private List<Post> postList;

}
