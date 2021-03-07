package com.dsc.mall.dao;

import com.dsc.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 * @Author:estic
 * @Date: 2021/3/7 10:54
 */
public interface PmsProductAttributeValueDao {
    /**
     * 批量创建
     * @param productAttributeValueList
     * @return
     */
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
