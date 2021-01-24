package com.dsc.portal.dao;

import com.dsc.mall.model.SmsCoupon;
import com.dsc.portal.domain.CartProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品系统自定义商品Dao
 * @author 60221
 */
public interface PortalProductDao {
    /**
     * 获取购物车商品信息
     * @return
     * @param id
     *
     */
    CartProduct getCartProduct(@Param("id") Long id);

    /**
     * 获取促销商品信息列表
     * @param ids
     * @param
     * @return
     */
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    /**
     * 获取可用优惠券列表
     * @return
     * @param productCategoryId
     * @param productId
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId, @Param("productCategoryId") Long productCategoryId);
}

