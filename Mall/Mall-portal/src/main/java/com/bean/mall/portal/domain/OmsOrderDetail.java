package com.bean.mall.portal.domain;

import com.bean.model.OmsOrder;
import com.bean.model.OmsOrderItem;

import java.util.List;

public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

}
