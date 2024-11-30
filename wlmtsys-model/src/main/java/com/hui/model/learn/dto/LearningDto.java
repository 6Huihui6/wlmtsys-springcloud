package com.hui.model.learn.dto;

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
public class LearningDto implements Serializable {

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


    @ApiModelProperty(value = "文件类型--0为网络资源url，1为自己投稿")
    private Integer fileType;

    @ApiModelProperty(value = "类型--0为内部资源，1为外部资源")
    private Integer type;

    @ApiModelProperty(value = "文件大小（字节）")
    private Integer fileSize;

    @ApiModelProperty(value = "文件存储路径")
    private String url;

    @ApiModelProperty(value = "封面图片")
    private String image;


}
