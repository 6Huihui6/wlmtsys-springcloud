package com.hui.model.post.dto;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageDto extends PageQueryDto {
    @ApiModelProperty(value = "频道ID")
    private Integer channelId;
    // 排序 1:发布时间 2:热度
    @ApiModelProperty(value = "排序 1:发布时间 2:热度")
    private Integer order = 2;
    @ApiModelProperty(value = "内容")
    private String content;
}
