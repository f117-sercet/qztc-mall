package com.dsc.portal.servcie;

import com.dsc.mall.model.CmsSubject;
import com.dsc.mall.model.PmsProduct;
import com.dsc.mall.model.PmsProductCategory;
import com.dsc.portal.domain.HomeContentResult;

import java.util.List;

/**
 * 首页内容管理
 * @author 60221
 *
 */
public interface HomeService {
    /**
     * 获取首页内容
     * @return
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     * @return
     * @param pageSize
     * @param pageNum
     */
    List<PmsProductCategory> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     * @return
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     * @return
     * @param pageSize
     * @param pageNum
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    /**
     * 分页获取人气推荐商品
     * @return
     * @param pageNum
     * @param pageSize
     */
    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * 分页获取新品推荐商品
     * @return
     * @param pageSize
     * @param pageNum
     */
    List<PmsProduct> newProductList(Integer pageNum, Integer pageSize);
}
