package com.dsc.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 修改订单费用信息参数
 * @Author:estic
 * @Date: 2021/3/2 21:54
 */
@Getter
@Setter
public class OmsMoneyInfoParam {

    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("运费金额")
    private BigDecimal freifreightAmount;
    @ApiModelProperty("管理员后台调整订单使所使用的折扣金额")
    private BigDecimal discountAmount;
    @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;
}
