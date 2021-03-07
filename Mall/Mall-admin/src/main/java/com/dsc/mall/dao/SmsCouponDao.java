package com.dsc.mall.dao;

import com.dsc.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * 自定义优惠券管理Dao
 * @Author:estic
 * @Date: 2021/3/7 11:23
 */
public interface SmsCouponDao {
    /**
     * 获取优惠券详情包括绑定关系
     * @param id
     * @return
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
