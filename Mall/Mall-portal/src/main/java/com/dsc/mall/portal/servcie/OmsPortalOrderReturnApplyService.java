package com.dsc.mall.portal.servcie;

import com.dsc.mall.portal.domain.OmsOrderReturnApplyParam;

/**
 * 前台订单退库哦管理Service
 * @author 60221
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     * @param returnApplyParam
     * @return
     */
    int create(OmsOrderReturnApplyParam returnApplyParam);
}
