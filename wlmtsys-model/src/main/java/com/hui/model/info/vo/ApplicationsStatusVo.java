package com.hui.model.info.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hui
 * @since 2024-11-24
 */
@Data
public class ApplicationsStatusVo implements Serializable {


    @ApiModelProperty(value = "申请状态：1为招新中，2未招新")
    private Integer status;




}
