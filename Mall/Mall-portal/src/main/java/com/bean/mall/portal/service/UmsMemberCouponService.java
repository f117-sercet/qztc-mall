package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.CartPromotiomItem;
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

    List<SmsCouponHistory> list(List<CartPromotiomItem> cartPromotiomItems,Integer type);
}
