package com.bean.mall.portal.service;

import com.bean.mall.common.api.CommonPage;
import com.bean.mall.portal.domain.ConfirmOrderResult;
import com.bean.mall.portal.domain.OmsOrderDetail;
import com.bean.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 前台订单管理
 */
public interface OmsPortalOrderService {
    /**
     * 根据用户购物车信息生成确认信息
     * @param cartIds
     * @return
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

    /**
     * 根据提交信息生成订单
     * @param orderParam
     * @return
     */

    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     *  支付成功后的回调
     * @return
     */
    @Transactional
    Integer PaySuccess(Long orderId, Integer payType);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 确认收货
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * 分页获取用户订单
     * @return
     */
    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据订单ID获取订单详情
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * 用户根据订单ID删除订单
     */
    void deleteOrder(Long orderId);


}
