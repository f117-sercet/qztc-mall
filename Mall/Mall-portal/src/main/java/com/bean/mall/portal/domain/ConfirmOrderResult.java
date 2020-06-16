package com.bean.mall.portal.domain;

import com.bean.model.SmsCouponHistory;
import com.bean.model.UmsIntegrationConsumeSetting;
import com.bean.model.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 确认单信息封装
 */
public class ConfirmOrderResult {
    //包含优惠信息的购物车信息

    private List<CartPromotiomItem> cartPromotiomItemList;

    // 用户收货地址列表

    private  List<UmsMemberReceiveAddress>  umsMemberReceiveAddressList;

    //用户可用优惠券列表

    private List<SmsCouponHistoryDetail> couponHistoryDetailList;

    // 积分使用规则

    private UmsIntegrationConsumeSetting  integrationConsumeSetting;

    // 会员持有的积分
    private  Integer memberIntgration;

    //计算的金额

    private CalcAmount calcAmount;
}
