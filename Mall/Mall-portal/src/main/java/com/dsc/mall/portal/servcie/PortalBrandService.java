package com.dsc.mall.portal.servcie;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.model.PmsBrand;
import com.dsc.mall.model.PmsProduct;

import java.util.List;

/**
 * @author 60221
 * 前台品牌管理Service
 */
public interface PortalBrandService {
    /**
     * 分页获取推荐品牌
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> recommendList(Integer pageNum,Integer pageSize);

    /**
     * 获取品牌详情
     * @param brandId
     * @return
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     * @param brandId
     * @param pageNum
     * @param pageSize
     * @return
     */
    CommonPage<PmsProduct> productList(Long brandId,Integer pageNum,Integer pageSize);
}
