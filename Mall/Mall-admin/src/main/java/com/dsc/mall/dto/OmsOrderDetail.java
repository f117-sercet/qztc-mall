package com.dsc.mall.dto;

import com.dsc.mall.model.OmsOrder;
import com.dsc.mall.model.OmsOrderItem;
import com.dsc.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * @Author:estic
 * @Date: 2021/3/2 22:00
 */
public class OmsOrderDetail extends OmsOrder {

    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
