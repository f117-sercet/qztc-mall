package com.dsc.mall.servcie;

import com.dsc.mall.model.PmsProductAttribute;

import java.util.List;

/**
 * 商品管理属性Service
 * @Author:estic
 * @Date: 2021/3/21 20:37
 */
public interface PmsProductAttributeService {
    /**
     * 根据分页获取商品属性
     * @param cid 分类id
     * @param type 0->属性; 2->参数
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);
}
