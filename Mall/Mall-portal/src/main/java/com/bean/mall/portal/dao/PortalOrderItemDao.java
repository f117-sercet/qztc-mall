package com.bean.mall.portal.dao;

import com.bean.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单商品自定义Dao
 */
public interface PortalOrderItemDao {

    int insertList(@Param("list") List<OmsOrderItem> list);
}
