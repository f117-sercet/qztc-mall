package com.dsc.mall.dao;

import com.dsc.mall.dto.OmsOrderDeliveryParam;
import com.dsc.mall.dto.OmsOrderDetail;
import com.dsc.mall.dto.OmsOrderQueryParam;
import com.dsc.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;
import sun.jvm.hotspot.debugger.linux.sparc.LinuxSPARCThreadContext;

import java.util.List;

/**
 * 订单自定义查询Dao
 * @Author:estic
 * @Date: 2021/3/2 21:38
 */
public interface OmsOrderDao{

    /**
     * 条件查询订单
     * @return
     * @param queryParam
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     * @param deliveryParamList
     * @return
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     * @return
     * @param id
     */
    OmsOrderDetail getDetail(@Param("id") Long id);

}
