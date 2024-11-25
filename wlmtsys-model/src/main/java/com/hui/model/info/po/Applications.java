package com.hui.model.info.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hui
 * @since 2024-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("applications")
@ApiModel(value="Applications对象", description="")
public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "application_id", type = IdType.AUTO)
    private Integer applicationId;

    private Integer userId;

    private Integer updateId;

    private String username;

    private String email;

    private String title;

    private Integer employId;

    private LocalDateTime createdTime;

    @ApiModelProperty(value = "申请状态：1为审核中，2为已通过，3为未通过")
    private Integer status;

    private String resumePath;

    private String others;


}
