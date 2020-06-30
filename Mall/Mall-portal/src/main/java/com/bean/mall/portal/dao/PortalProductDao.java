package com.bean.mall.portal.dao;

import com.bean.mall.portal.domain.CartProduct;
import com.bean.mall.portal.domain.PromotionProduct;
import com.bean.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义Dao
 */
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId, @Param("productCategoryId")Long productCategoryId);
}
