package com.dsc.mall.dao;

import com.dsc.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义优惠券和商品分类关系管理Dao
 * @Author:estic
 * @Date: 2021/3/7 11:24
 */
public interface SmsCouponProductCategoryRelationDao {
    /**
     * 批量创建
     * @param productCategoryRelationList
     * @return
     */
    int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
