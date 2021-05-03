package com.dsc.mall.search.dao;

import com.dsc.mall.search.domain.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:estic
 * 搜索商品管理自定义Dao
 * @Date: 2021/2/27 11:30
 */
@Repository
public interface EsProductDao {
    /**
     * 获取指定ID的搜索商品
     * @param id
     * @return
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);

}
