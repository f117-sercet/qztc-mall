package com.dsc.mall.servcie;

import com.dsc.mall.model.OmsOrderReturnReason;

/**
 * 退货原因管理Service
 * @Author:estic
 * @Date: 2021/3/12 22:04
 */
public interface OmsOrderReturnReasonService {
    /**
     * 添加退货原因
      * @param returnReason
     * @return
     */
    int  create(OmsOrderReturnReason returnReason);
}
