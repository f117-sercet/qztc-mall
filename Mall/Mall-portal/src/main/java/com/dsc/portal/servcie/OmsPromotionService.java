package com.dsc.portal.servcie;

import com.dsc.mall.model.OmsCartItem;
import com.dsc.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * @author 60221
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     *
     * @param cartItemList
     * @return
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
