package com.hui.model.post.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 积分榜单
 * </p>
 *
 * @author hui
 * @since 2024-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("points_board")
@ApiModel(value="PointsBoard对象", description="积分榜单")
public class PointsBoard implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "榜单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "帖子id")
    private Integer postId;//帖子id

    @ApiModelProperty(value = "积分值")
    private Integer points;

    @ApiModelProperty(value = "名次，只记录赛季前100")
    private Integer rank;

    @ApiModelProperty(value = "赛季，例如 1,就是第一赛季，2-就是第二赛季")
    private Integer season;


}
