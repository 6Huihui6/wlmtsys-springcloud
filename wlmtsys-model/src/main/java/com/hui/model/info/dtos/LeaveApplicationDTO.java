package com.hui.model.info.dtos;


import com.hui.model.annotation.IdEncrypt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(title = "LeaveApplicationDTO", description = "请假申请DTO")
public class LeaveApplicationDTO {

    @Schema(title = "userId",description = "主键id")
    @IdEncrypt
    private Long userId;

    @Schema(description = "请假类型")
    private String leaveType;

    @Schema(description = "开始日期")
    private Date startDate;

    @Schema(description = "结束日期")
    private Date endDate;

    @Schema(description = "请假原因")
    private String reason;
}