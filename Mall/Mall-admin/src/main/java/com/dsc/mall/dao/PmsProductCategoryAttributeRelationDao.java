package com.dsc.mall.dao;

import com.dsc.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品分类和属性关系Dao
 * @Author:estic
 * @Date: 2021/3/7 10:55
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * 批量创建
     * @param productCategoryAttributeRelationList
     * @return
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
