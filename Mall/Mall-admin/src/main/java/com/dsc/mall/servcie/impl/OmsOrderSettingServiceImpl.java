package com.dsc.mall.servcie.impl;

import com.dsc.mall.mapper.OmsOrderSettingMapper;
import com.dsc.mall.model.OmsOrderSetting;
import com.dsc.mall.servcie.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单设置管理Service实现类
 * @Author:estic
 * @Date: 2021/4/17 13:23
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {

    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;


    @Override
    public OmsOrderSetting getItem(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);

    }

    @Override
    public int update(Long id, OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        return orderSettingMapper.updateByPrimaryKey(orderSetting);
    }
}
