package com.dsc.mall.servcie;

import com.dsc.mall.dto.PmsProductAttributeCategoryItem;
import com.dsc.mall.model.PmsProduct;
import com.dsc.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类管理Service
 * @Author:estic
 * @Date: 2021/3/16 20:04
 */
public interface PmsProductAttributeCategoryService {
    /**
     * 创建属性分类
     * @param name
     * @return
     */
    int create(String name);

    /**
     * 删除属性分类
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 获取属性分类详情
     * @param id
     * @return
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     *更新数据
     * @param id
     * @param name
     * @return
     */
    public int update(Long id, String name);

    /**
     * 分页查询属性分类
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取包含属性的属性分类
     * @return
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
