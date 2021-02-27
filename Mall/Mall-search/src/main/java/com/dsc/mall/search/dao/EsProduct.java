package com.dsc.mall.search.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:estic
 * 搜索商品管理自定义Dao
 * @Date: 2021/2/27 11:30
 */
public interface EsProduct {
    /**
     * 获取指定ID的搜索商品
     * @param id
     * @return
     */
    List<EsProduct> getAllEsproductList(@Param("id") Long id);

}
