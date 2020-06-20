package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.CartPromotiomItem;
import com.bean.model.OmsCartItem;

import java.util.List;

/**
 * 促销管理Service
 */
public interface OmsPromotionService {

    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList
     * @return
     */
    List<CartPromotiomItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}

