package com.dsc.mall.dao;

import com.dsc.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * @Author:estic
 * @Date: 2021/3/7 10:57
 */
public interface PmsProductCategoryDao {
    /**
     * 获取商品分类及其子分类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

}
