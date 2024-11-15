package com.hui.model.info.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(title = "LeaveApplicationVO", description = "请假申请返回对象")
public class LeaveApplicationVO {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "请假类型")
    private String leaveType;

    @Schema(description = "开始日期")
    private Date startDate;

    @Schema(description = "结束日期")
    private Date endDate;

    @Schema(description = "请假原因")
    private String reason;

    @Schema(description = "审批状态,0:待审批,1:已批准,2:已拒绝")
    private Integer status;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;
}