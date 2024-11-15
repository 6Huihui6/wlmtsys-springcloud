package com.hui.model.info.dtos;



import com.hui.model.annotation.IdEncrypt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class CollectionBehaviorDto {

    // 文章、动态ID
    @IdEncrypt
    Long articleId;
    /**
     * 收藏内容类型
     * 0文章
     * 1动态
     */
    Short type;

    /**
     * 操作类型
     * 0收藏
     * 1取消收藏
     */
    @Schema(description = "0收藏 1取消收藏")
    Short operation;


    Date publishedTime;

}