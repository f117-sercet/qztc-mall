package com.dsc.portal.servcie;

import com.dsc.mall.model.PmsProduct;
import com.dsc.portal.domain.PmsPortalProductDetail;
import com.dsc.portal.domain.PmsProductCategoryNode;

import java.util.List;

/**
 * 前台商品管理Service
 * @author 60221
 */
public interface PmsPortalProductService {

    /**
     * 综合搜索商品
     * @param pageSize
     * @return
     * @param pageNum
     * @param productCategoryId
     * @param brandId
     * @param sort
     * @param keyword
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     * @return
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     * @return
     * @param id
     */
    PmsPortalProductDetail detail(Long id);
}
