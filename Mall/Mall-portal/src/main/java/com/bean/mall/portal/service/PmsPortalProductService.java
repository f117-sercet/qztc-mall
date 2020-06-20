package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.PmsPortalProductDetail;
import com.bean.mall.portal.domain.PmsProductCategoryNode;
import com.bean.model.PmsProduct;

import java.util.List;

/**
 *前台商品管理Service
 */
public interface PmsPortalProductService {
    /**
     *  综合搜索商品
     * @param keyword
     * @param brandId
     * @param productCategoryId
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    List<PmsProduct> search(String keyword,Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetail detail(Long id);
}
