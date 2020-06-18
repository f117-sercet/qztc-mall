package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.HomeContentResult;
import com.bean.model.CmsSubject;
import com.bean.model.PmsProduct;
import com.bean.model.PmsProductCategory;

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

    /**
     * 获取商品分类
     * @param parentId 0；获取一级分类：其他，获取指定二级分类
     * @return
     */
   List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId  专题分类
     *
     *
     */
   List<CmsSubject> getSubjectList(Long cateId,Integer pageNum,Integer pageSize);

    /**
     *
     *
     *分页获取人气推荐商品
     *
     */
   List<PmsProduct> hotProductList(Integer pageNum,Integer pageSize);

    /**
     * 分页获取新商品推荐
     *
     *
     */
   List<PmsProduct> newPmsProductList(Integer pageNum, Integer pageSize);


}
