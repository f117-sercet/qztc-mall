package com.dsc.portal.servcie.impl;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.mapper.OmsOrderReturnApplyMapper;
import com.dsc.mall.model.OmsOrderReturnApply;
import com.dsc.portal.domain.ConfirmOrderResult;
import com.dsc.portal.domain.OmsOrderDetail;
import com.dsc.portal.domain.OmsOrderReturnApplyParam;
import com.dsc.portal.domain.OrderParam;
import com.dsc.portal.servcie.OmsPortalOrderReturnApplyService;
import com.dsc.portal.servcie.OmsPortalOrderServcie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单退货管理Service实现类
 * @author 60221
 */
@Service
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {
   @Autowired
   private OmsOrderReturnApplyMapper returnApplyMapper;


    @Override
    public int create(OmsOrderReturnApplyParam returnApplyParam) {
        OmsOrderReturnApply realApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(returnApplyParam,realApply);
        realApply.setCreateTime(new Date());
        realApply.setStatus(0);

        return returnApplyMapper.insert(realApply);
    }
}
