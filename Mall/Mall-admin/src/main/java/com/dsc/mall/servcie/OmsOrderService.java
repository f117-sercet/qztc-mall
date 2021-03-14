package com.dsc.mall.servcie;

import com.dsc.mall.dto.*;
import com.dsc.mall.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理Service
 * @Author:estic
 * @Date: 2021/3/14 21:10
 */
public interface OmsOrderService {

    /**
     *订单查询
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     * @param deliveryParamList
     * @return
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     * @param ids
     * @param note
     * @return
     */
    @Transactional
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 获取指定订单详情
     * @param id
     * @return
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     * @param receiverInfoParam
     * @return
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
      * @param moneyInfoParam
     * @return
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     * @param id
     * @param note
     * @param status
     * @return
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);

}
