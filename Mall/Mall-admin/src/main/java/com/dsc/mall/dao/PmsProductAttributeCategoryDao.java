package com.dsc.mall.dao;

import com.dsc.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * @Author:estic
 * @Date: 2021/3/7 10:51
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     * @return
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
