package com.hui.model.common.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.common.constants.Constant;
import com.hui.common.utils.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@ApiModel(description = "分页请求参数")
@Accessors(chain = true)
public class PageQuery {
    public static final Integer DEFAULT_PAGE_SIZE = 20;
    public static final Integer DEFAULT_PAGE_NUM = 1;

    @ApiModelProperty(value = "页码", example = "1")
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNo = DEFAULT_PAGE_NUM;

    @ApiModelProperty(value = "每页大小", example = "5")
    @Min(value = 1, message = "每页查询数量不能小于1")
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "是否升序", example = "true")
    private Boolean isAsc = true;

    @ApiModelProperty(value = "排序字段", example = "id")
    private String sortBy;

    public int from(){
        return (pageNo - 1) * pageSize;
    }

    public <T> Page<T> toMpPage(OrderItem ... orderItems) {
        Page<T> page = new Page<>(pageNo, pageSize);
        // 是否手动指定排序方式
        if (orderItems != null && orderItems.length > 0) {
            for (OrderItem orderItem : orderItems) {
                page.addOrder(orderItem);
            }
            return page;
        }
        // 前端是否有排序字段
        if (StringUtils.isNotEmpty(sortBy)){
            OrderItem orderItem = new OrderItem();
            orderItem.setAsc(isAsc);
            orderItem.setColumn(sortBy);
            page.addOrder(orderItem);
        }
        return page;
    }

    public <T> Page<T> toMpPage(String defaultSortBy, boolean isAsc) {
        if (StringUtils.isBlank(sortBy)){
            sortBy = defaultSortBy;
            this.isAsc = isAsc;
        }
        Page<T> page = new Page<>(pageNo, pageSize);
        OrderItem orderItem = new OrderItem();
        orderItem.setAsc(this.isAsc);
        orderItem.setColumn(sortBy);
        page.addOrder(orderItem);
        return page;
    }
    public <T> Page<T> toMpPageDefaultSortByCreateTimeDesc() {
        return toMpPage(Constant.DATA_FIELD_NAME_CREATE_TIME, false);
    }
    /**
     * 内容
     */
    @Schema(title = "内容1", description = "信息的详细内容")
    @TableField("content1")
    private String content1;

    @Schema(title = "内容2", description = "信息的详细内容")
    @TableField("content2")
    private String content2;
    @Schema(title = "地址", description = "地址")
    @TableField("address")
    private String address;
    /**
     * 职位要求
     */
    @Schema(title = "职位要求", description = "职位对应聘者的要求")
    @TableField("requirement")
    private String requirement;
    @Schema(title = "标题", description = "新闻的标题")
    @TableField("title")
    private String title;
    @Schema(description = "标签", example = "标签0为新闻,标签1为活动")
    private  Integer label;

    @Schema(title = "更新时间区间的开始时间", example = "2022-7-18 ")
//    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_TIME_FORMAT)
    private LocalDate beginTime;
    //    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_TIME_FORMAT)
    @Schema(title = "更新时间区间的结束时间", example = "2022-7-18 ")
    private LocalDate endTime;
    /**
     * 内容
     */
    @Schema(title = "内容", description = "新闻的详细内容")
    @TableField("content")
    private String content;
    /**
     * 描述
     */
    @Schema(title = "描述", description = "团队的详细描述")
    @TableField("`desc`")
    private String desc;
    @Schema(title = "部门", description = "1为行政部，2为运营部，3技术部，4为指导老师")
    @TableField("depart")
    private Integer depart;
    /**
     * 团队名称
     */
    @Schema(title = "名称", description = "团队的名称")
    @TableField("name")
    private String name;

}
