package com.dsc.mall.dao;

import com.dsc.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义优惠券和商品关系关系Dao
 * @Author:estic
 * @Date: 2021/3/7 11:25
 */
public interface SmsCouponProductRelationDao {

    /**
     * 批量创建
     * @param productRelationList
     * @return
     */
    int insertList(@Param("list") List<SmsCouponProductRelation> productRelationList);
}
