package com.dsc.mall.dao;

import com.dsc.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

/**
 * 自定义商品管理Dao
 * @Author:estic
 * @Date: 2021/4/20 17:25
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
