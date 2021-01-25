package com.dsc.portal.domain;

import com.dsc.mall.model.OmsOrder;
import com.dsc.mall.model.OmsOrderItem;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 * @author 60221
 *
 */
public class OmsOrderDetail extends OmsOrder {

    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
