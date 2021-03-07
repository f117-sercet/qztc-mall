package com.dsc.mall.dao;

import com.dsc.mall.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品满减Dao
 * @Author:estic
 * @Date: 2021/3/7 11:18
 */
public interface PmsProductFullReductionDao {
    /**
     * 批量创建
     * @param productFullReductionList
     * @return
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
