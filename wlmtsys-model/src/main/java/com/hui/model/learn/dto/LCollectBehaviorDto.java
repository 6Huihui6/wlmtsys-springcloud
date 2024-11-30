package com.hui.model.learn.dto;


import com.hui.model.annotation.IdEncrypt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LCollectBehaviorDto {


    // 文章、动态、评论等ID.
    @IdEncrypt
    @Schema(description = "资料ID")
    Integer  learningId;

    /**
     * 喜欢操作方式
     * 0 点赞
     * 1 取消点赞
     */
    @Schema(description = "1 收藏 ----0 取消收藏")
    Short operation;
}
