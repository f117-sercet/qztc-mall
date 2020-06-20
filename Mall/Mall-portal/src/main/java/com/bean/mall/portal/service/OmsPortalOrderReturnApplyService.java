package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.OmsOrderReturnApplyParam;

/**
 * 订单退货管理
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * 退订申请
     * @param returnApply
     * @return
     */
     int create(OmsOrderReturnApplyParam returnApply);
}
