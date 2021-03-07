package com.dsc.mall.dao;

import com.dsc.mall.model.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品审核日志管理Dao
 * @Author:estic
 * @Date: 2021/3/7 11:20
 */
public interface PmsProductVertifyRecordDao {

    /**
     *批量创建
     * @param list
     * @return
     */
    int insertList(@Param("list") List<PmsProductVertifyRecord> list);
}
