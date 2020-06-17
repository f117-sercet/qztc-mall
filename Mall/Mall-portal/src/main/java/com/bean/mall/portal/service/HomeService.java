package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.HomeContentResult;
import com.bean.model.PmsProduct;

import java.util.List;

/**
 * 首页内容管理
 */
public interface HomeService {
    /**
     *
     * 首页商品内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
   List<PmsProduct> recommendProductList(Integer pageSize,Integer pageNum);
}
