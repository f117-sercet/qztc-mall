package com.dsc.mall.dao;

import com.dsc.mall.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员阶梯价格Dao
 * @Author:estic
 * @Date: 2021/3/7 11:19
 */
public interface PmsProductLadderDao {
    /**
     * 批量创建
     * @param productLadderList
     * @return
     */
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
