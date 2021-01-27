package com.dsc.portal.domain;

import com.dsc.mall.model.SmsCoupon;
import com.dsc.mall.model.SmsCouponHistory;
import com.dsc.mall.model.SmsCouponProductCategoryRelation;
import com.dsc.mall.model.SmsCouponProductRelation;

import java.util.List;

/**
 * @author 60221
 * 优惠券领取历史详情
 */
public class SmsCouponHistoryDetail extends SmsCouponHistory {

    /**相关优惠券信息
     *
     */
    private SmsCoupon coupon;
    /**优惠券关联商品
     *
     */
    private List<SmsCouponProductRelation> productRelationList;
    /**优惠券关联商品分类
     *
     */
    private List<SmsCouponProductCategoryRelation> categoryRelationList;

    public SmsCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(SmsCoupon coupon) {
        this.coupon = coupon;
    }

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<SmsCouponProductCategoryRelation> getCategoryRelationList() {
        return categoryRelationList;
    }

    public void setCategoryRelationList(List<SmsCouponProductCategoryRelation> categoryRelationList) {
        this.categoryRelationList = categoryRelationList;
    }
}