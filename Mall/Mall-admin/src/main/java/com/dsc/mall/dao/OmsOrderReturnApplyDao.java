package com.dsc.mall.dao;

import com.dsc.mall.dto.OmsOrderReturnApplyResult;
import com.dsc.mall.dto.OmsReturnApplyQueryParam;
import com.dsc.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单拖货申请自定义Dao
 * @Author:estic
 * @Date: 2021/3/7 10:38
 */
public interface OmsOrderReturnApplyDao {

    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
