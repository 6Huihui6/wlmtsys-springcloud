package com.hui.model.info.dtos;

import com.hui.model.annotation.IdEncrypt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReadBehaviorDto {

    // 文章、动态、评论等ID
    @IdEncrypt
    Long articleId;

    /**
     * 阅读次数
     */
    @Schema(description = "阅读次数")
    Short count;

    /**
     * 阅读时长（S)
     */
    @Schema(description = "阅读时长（S）")
    Integer readDuration;

    /**
     * 阅读百分比
     */
    @Schema(description = "阅读百分比")
    Short percentage;

    /**
     * 加载时间
     */
    @Schema(description = "加载时间")
    Short loadDuration;

}