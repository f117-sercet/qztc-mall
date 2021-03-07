package com.dsc.mall.dao;

import com.dsc.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品SKU管理Dao
 * @Author:estic
 * @Date: 2021/3/7 11:22
 */
public interface PmsSkuStockDao {
    /**
     * 批量插入操作
     * @param skuStockList
     * @return
     */
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     * @param skuStockList
     * @return
     */
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}
