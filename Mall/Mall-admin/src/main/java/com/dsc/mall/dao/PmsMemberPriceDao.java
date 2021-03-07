package com.dsc.mall.dao;

import com.dsc.mall.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员价格Dao
 * @Author:estic
 * @Date: 2021/3/7 10:43
 */
public interface PmsMemberPriceDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
