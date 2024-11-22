package com.hui.model.post.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author hui
 * @since 2024-11-19
 */
@Data
@ApiModel(value="PostDto对象", description="帖子表")
public class PostDto implements Serializable {

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
    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private List<String> image;

    @ApiModelProperty(value = "帖子频道")
    private Integer channelId;

    @ApiModelProperty(value = "标签")
    private String labels;

    @ApiModelProperty(value = "帖子状态，1审核失败,2审核通过，3已发布")
    private Integer status;

    @ApiModelProperty(value = "定时发布时间，不定时则为空")
    private LocalDateTime publishTime;



}
