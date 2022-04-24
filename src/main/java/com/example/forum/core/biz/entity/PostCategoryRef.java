package com.example.forum.core.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子板块关联表
 *
 * @author 言曌
 * @date 2022/4/16
 */

@Data
@TableName("biz_post_category_ref")
public class PostCategoryRef  extends Model<PostCategoryRef> implements Serializable {

    private static final long serialVersionUID = 1989776329130364722L;

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
     * 帖子Id
     */
    private Long postId;

    /**
     * 板块Id
     */
    private Long cateId;

    public PostCategoryRef(Long postId, Long cateId) {
        this.postId = postId;
        this.cateId = cateId;
    }

    public PostCategoryRef() {
    }
}
