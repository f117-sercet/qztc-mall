package com.dsc.portal.servcie;

import com.dsc.mall.model.SmsCoupon;
import com.dsc.mall.model.SmsCouponHistory;
import com.dsc.portal.domain.CartPromotionItem;
import com.dsc.portal.domain.SmsCouponHistoryDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 60221
 * 用户优惠券管理Service
 */
public interface UmsMemberCouponService {
    /**
     * 会员添加优惠券
     * @param couponId
     * @
     */
    @Transactional
    void add(Long couponId);

    /**
     * 获取优惠券历史列表
     * @param useStatus
     * @return
     *
     */
    List<SmsCouponHistory> listHistory(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     * @param cartPromotionItemList
     * @param type
     * @return
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartPromotionItemList,Integer type);

    /**
     * 获取当前商品相关优惠券
     * @param productId
     * @return
     */
    List<SmsCoupon> listByProduct(Long productId);

    /**
     * 获取用户优惠券
     * @param useStatus
     * @return
     */
    List<SmsCoupon> list(Integer useStatus);


}
