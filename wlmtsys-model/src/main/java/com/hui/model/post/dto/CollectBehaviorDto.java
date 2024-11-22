package com.hui.model.post.dto;


import com.hui.model.annotation.IdEncrypt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CollectBehaviorDto {


    // 文章、动态、评论等ID.
    @IdEncrypt
    @Schema(description = "动态ID")
    Integer postsId;

    /**
     * 喜欢操作方式
     * 0 点赞
     * 1 取消点赞
     */
    @Schema(description = "1 收藏 ----0 取消收藏")
    Short operation;
}
