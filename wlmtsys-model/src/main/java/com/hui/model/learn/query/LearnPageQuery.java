package com.hui.model.learn.query;


import com.hui.model.post.dto.PageQueryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "分页查询条件")
public class LearnPageQuery extends PageQueryDto {
    // 用户端查询条件
    @ApiModelProperty(value = "搜索关键字,邮箱或姓名")
    private String keyword;
    // 后台管理查询条件
    @ApiModelProperty(value = "是否为内部资源，0：是，1：否")
    private Integer type;

    @ApiModelProperty(value = "channelID")
    private Integer channelId;


}
