package com.hui.model.post.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("post")
@ApiModel(value="Post对象", description="帖子表")
public class PostVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "帖子ID")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "帖子内容")
    private String content;

    @ApiModelProperty(value = "发帖时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "点赞数")
    private Integer likes;
    @ApiModelProperty(value = " 当前用户是否点赞")
    private boolean isLikedOrNot;
    @ApiModelProperty(value = "是否删除，0未删除，1已删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "收藏数")
    private Integer collection;
    @ApiModelProperty(value = "当前用户是否收藏")
    private boolean isCollectedOrNot;
    @ApiModelProperty(value = "评论数")
    private Integer comment;

    @ApiModelProperty(value = "转发数")
    private Integer forward;

    @ApiModelProperty(value = "帖子频道")
    private Integer channelId;

    @ApiModelProperty(value = "标签")
    private String labels;

    @ApiModelProperty(value = "浏览量")
    private Integer views;

    @ApiModelProperty(value = "热度")
    private Integer heat;

    @ApiModelProperty(value = "帖子状态，1审核失败,2审核通过，3已发布")
    private Integer status;

    @ApiModelProperty(value = "定时发布时间，不定时则为空")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "拒绝理由")
    private String reason;


}
