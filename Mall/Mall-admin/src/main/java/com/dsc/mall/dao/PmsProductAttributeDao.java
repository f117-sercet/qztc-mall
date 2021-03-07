package com.dsc.mall.dao;

import com.dsc.mall.dto.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品属性Dao
 * @Author:estic
 * @Date: 2021/3/7 10:53
 */
public interface PmsProductAttributeDao {
    /**
     * 获取商品属性信息
     * @param productCategoryId
     * @return
     */
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
