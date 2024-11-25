package com.hui.model.info.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarouselDTO {
//    private String imgUrl;
    @ApiModelProperty(value = "图片类型必填---type为“top”或“footer”")
    private String type;
    private String url;
    private String username;
    private String label;


}
