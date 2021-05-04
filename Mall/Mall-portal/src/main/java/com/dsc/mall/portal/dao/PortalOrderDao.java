package com.dsc.mall.portal.dao;

import com.dsc.mall.model.OmsOrderItem;
import com.dsc.mall.portal.domain.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台订单自定义
 * @author 60221
 */
public interface PortalOrderDao {
    /**
     * 获取订单及下单商品详情
     * @param orderId
     * @return
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * 修改 pms_sku_stock表的锁定库存及真实库存
     * @param orderItemList
     * @return
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     * @return
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * 批量修改订单状态
     * @param ids
     * @param status
     * @return
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
     * 解除取消订单的库存锁定
     * @param orderItemList
     * @return
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);

}

