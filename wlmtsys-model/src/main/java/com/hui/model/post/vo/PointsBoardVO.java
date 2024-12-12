package com.hui.model.post.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "积分榜单汇总信息")
public class PointsBoardVO {

    @ApiModelProperty("前100名上榜人信息")
    private List<PointsBoardItemVO> boardList;
}
