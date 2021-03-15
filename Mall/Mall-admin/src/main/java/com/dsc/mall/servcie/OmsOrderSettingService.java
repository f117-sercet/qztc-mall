package com.dsc.mall.servcie;

import com.dsc.mall.model.OmsOrderSetting;

/**
 * 订单设置管理Service
 * @Author:estic
 * @Date: 2021/3/15 19:38
 */
public interface OmsOrderSettingService {
    /**
     * 获取指定位置
     * @param id
     * @return
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     * @param id
     * @param orderSetting
     * @return
     */
    int update(Long id,OmsOrderSetting orderSetting);
}
