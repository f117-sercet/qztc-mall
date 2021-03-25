package com.dsc.mall.servcie;

import com.dsc.mall.model.PmsSkuStock;

import java.util.List;

/**
 * 商品SKU库存管理Service
 * @Author:estic
 * @Date: 2021/3/25 20:48
 */
public interface  PmsSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     * @param pid
     * @param keyword
     * @return
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存
     * @param pid
     * @param skuStockList
     * @return
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}
