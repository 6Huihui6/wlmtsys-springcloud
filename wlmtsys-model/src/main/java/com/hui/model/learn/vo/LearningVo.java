package com.hui.model.learn.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 学习资料表
 * </p>
 *
 * @author hui
 * @since 2024-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("learning")
@ApiModel(value="Learning对象", description="学习资料表")
public class LearningVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资料ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "分类ID")
    private Integer channelId;
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "上传者")
    private String uploader;

    @ApiModelProperty(value = "上传时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "文件类型 0为网络资源，1为自己投稿")
    private Integer fileType;
    @ApiModelProperty(value = "类型--0为内部资源，1为外部资源")
    private Integer type;

    @ApiModelProperty(value = "文件大小（字节）")
    private Integer fileSize;

    @ApiModelProperty(value = "文件存储路径")
    private String url;

    @ApiModelProperty(value = "点赞数")
    private Integer likes;
    @ApiModelProperty(value = "收藏数")
    private Integer collects;
    @ApiModelProperty(value = "浏览数")
    private Integer views;

    @ApiModelProperty(value = "封面图片")
    private String image;

    @ApiModelProperty(value = "当前用户是否收藏")
    private Boolean collectOrNot;

    @ApiModelProperty(value = "当前用户是否点赞")
    private Boolean likeOrNot;


}
