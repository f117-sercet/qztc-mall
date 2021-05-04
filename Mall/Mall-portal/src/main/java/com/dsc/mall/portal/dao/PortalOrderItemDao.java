package com.dsc.mall.portal.dao;

import com.dsc.mall.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单商品信息自定义Dao
 * @author 60221
 */
public interface PortalOrderItemDao {
    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertList(@Param("List")List<OmsOrderItem> list);
}
