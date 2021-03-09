package com.dsc.mall.servcie;

import com.dsc.mall.dto.OmsOrderReturnApplyResult;
import com.dsc.mall.dto.OmsReturnApplyQueryParam;
import com.dsc.mall.dto.OmsUpdateStatusParam;
import com.dsc.mall.model.OmsOrderReturnApply;

import java.util.List;

/**
 * 退货申请管理Service
 * @Author:estic
 * @Date: 2021/3/9 22:08
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     * @param id
     * @param statusParam
     * @return
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     * @param id
     * @return
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
