package com.hui.model.post.dto;


import com.hui.model.common.query.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageDto extends PageQuery {
    private Integer channelId;
    // 排序 1:发布时间 2:热度
    private Integer order = 2;
}
