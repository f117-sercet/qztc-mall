package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.CartPromotiomItem;
import com.bean.mall.portal.domain.SmsCouponHistoryDetail;
import com.bean.model.SmsCoupon;
import com.bean.model.SmsCouponHistory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户优惠券管理
 */
public interface UmsMemberCouponService {
/**
 * 会员添加优惠券
 */
@Transactional
    void add(Long couponId);

    /**
     *获取优惠列表
     * @param userStatus 优惠券的使用状态
     * @return
     */
    List<SmsCouponHistory> list(Integer userStatus);

    List<SmsCouponHistoryDetail> list(List<CartPromotiomItem> cartPromotiomItems,Integer type);
    /**
     * 获取当前商品相关优惠券
     */
    List<SmsCoupon> listByProduct(Long productId);

    /**
     * 获取用户优惠券列表
     */
    List<SmsCoupon> listHistory(Integer userStatus);
}
