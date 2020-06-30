package com.bean.mall.portal.service.impl;

import com.bean.mall.portal.domain.OmsOrderReturnApplyParam;
import com.bean.mall.portal.service.OmsPortalOrderReturnApplyService;
import com.bean.mapper.OmsOrderReturnApplyMapper;
import com.bean.model.OmsOrderReturnApply;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 订单退货管理实现Service实现类
 */
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {
@Autowired
private OmsOrderReturnApplyMapper returnApplyMapper;

    @Override
    public int create(OmsOrderReturnApplyParam returnApply) {
        OmsOrderReturnApply realApply=new OmsOrderReturnApply();
        BeanUtils.copyProperties(returnApply,realApply);
        realApply.setStatus(0);
        realApply.setCreateTime(new Date());
        return  returnApplyMapper.insert(realApply);
    }
}
