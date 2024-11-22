package com.hui.model.mess;

import lombok.Data;

@Data
public class UpdatePostMess {

    /**
     * 修改文章的字段类型
      */
    private UpdatePostType type;
    /**
     * 帖子ID
     */
    private Long postId;
    /**
     * 修改数据的增量，可为正负
     */
    private Integer add;

    public enum UpdatePostType{
        COLLECTION,COMMENT,LIKES,VIEWS;
    }
}