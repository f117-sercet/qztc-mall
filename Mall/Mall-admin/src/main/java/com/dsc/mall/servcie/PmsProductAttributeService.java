package com.dsc.mall.servcie;

import com.dsc.mall.dto.PmsProductAttributeParam;
import com.dsc.mall.dto.ProductAttrInfo;
import com.dsc.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 添加商品属性是、
      * @param pmsProductAttributeParam
     * @return
     */
    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);

    /**
     * 修改商品属性
     * @param id
     * @param productAttributeParam
     * @return
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * 获取单个商品属性信息
     * @param id
     * @return
     */
     PmsProductAttribute getItem(Long id);

    /**
     * 删除商品属性
     * @param ids
     * @return
     */
     @Transactional
     int delete(List<Long> ids);

    /**
     * 获取商品信息列表
     * @param productCategoryId
     * @return
     */
    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
