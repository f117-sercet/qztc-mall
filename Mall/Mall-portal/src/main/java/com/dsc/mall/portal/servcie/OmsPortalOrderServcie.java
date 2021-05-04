package com.dsc.mall.portal.servcie;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.portal.domain.ConfirmOrderResult;
import com.dsc.mall.portal.domain.OmsOrderDetail;
import com.dsc.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 60221
 * 前台订单管理Service
 */
public interface OmsPortalOrderServcie {
    /**
     * 根据用户购物车信息生成确认单信息
     * @param cartIds
     * @return
     */
    ConfirmOrderResult generatorConfirmOrder(List<Long> cartIds);

    /**
     * 根据提交订单生成信息
     * @param orderParam
     * @return
     */
    @Transactional
    Map<String,Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     * @param orderId
     * @param payType
     * @return
     */
    @Transactional
    Integer paySuccsess(Long orderId,Integer payType);

    /**
     * 自动取消订单
     * @return
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * 取消单个订单超时
     * @param orderId
     */
    @Transactional
    void  cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     * @param orderId
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 确认收货
     * @param orderId
     *
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * 分页获取用户订单
     * @param pageNum
     * @param pageSize
     */
    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据订单ID获取订单详情
     * @param orderId
     * @return
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * 用户根据订单ID删除订单
     * @param orderId
     */
    void deleteOrder(Long orderId);


}
