package com.dsc.portal.servcie;

import com.dsc.portal.domain.OmsOrderReturnApplyParam;

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
