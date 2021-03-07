package com.dsc.mall.dao;

import com.dsc.mall.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单操作记录自定义Dao
 * @Author:estic
 * @Date: 2021/3/7 10:35
 */
public interface OmsOrderOperateHistoryDao {
    /**
     * 批量创建
     * @param orderOperateHistoryList
     * @return
     */
    int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistoryList);
}
