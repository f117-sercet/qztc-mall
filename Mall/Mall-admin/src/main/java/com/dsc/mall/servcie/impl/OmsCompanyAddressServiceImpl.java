package com.dsc.mall.servcie.impl;

import com.dsc.mall.mapper.OmsCompanyAddressMapper;
import com.dsc.mall.model.OmsCompanyAddress;
import com.dsc.mall.model.OmsCompanyAddressExample;
import com.dsc.mall.model.OmsOrderSetting;
import com.dsc.mall.servcie.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * @Author:estic
 * @Date: 2021/4/11 21:39
 */
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {

    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
