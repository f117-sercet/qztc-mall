package com.dsc.mall.search.service;

import com.dsc.mall.search.dao.EsProduct;
import com.dsc.mall.search.domain.EsProductRelatedInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author:estic
 * @Date: 2021/2/27 11:33
 * 搜索商品管理Service
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     * @param
     * @return
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     * @param ids
     *
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据关键字搜索名称或者副标题复合查询
     * @return
     * @param pageSize
     * @param pageNum
     * @param sort
     * @param keyword
     * @param brandId
     * @param productCategoryId
     */

    Page<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize,Integer sort);

    /**
     * 根据商品id推荐相关商品
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    Page<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize);

    /**
     * 获取搜索词相关品牌、分类、属性
     * @return
     * @param keyword
     *
     */
    EsProductRelatedInfo searchRelatedInfo(String keyword);
}

