package com.bean.mall.dao;

import com.bean.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品和和商品操作关系
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量创建
     */

    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}

