package com.dsc.mall.portal.servcie;

import com.dsc.mall.model.OmsCartItem;
import com.dsc.mall.portal.domain.CartProduct;
import com.dsc.mall.portal.domain.CartPromotionItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车管理Service
 * @author 60221
 */
public interface OmsCartItemService {
    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     * @return
     * @param cartItem
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * 根据会员编号获取购物车列表
     * @return
     * @param memberId
     *
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * 获取包含促销活动信息的购物车列表
     * @return
     * @param memberId
     * @param cartIds
     */
    List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds);

    /**
     * 修改某个购物车商品的数量
     * @return
     * @param memberId
     * @param id
     * @param quantity
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * 批量删除购物车中的商品
     * @return
     * @param memberId
     * @param ids
     * @param
     */
    int delete(Long memberId,List<Long> ids);

    /**
     *获取购物车中用于选择商品规格的商品信息
     * @return
     * @param productId
     */
    CartProduct getCartProduct(Long productId);


    /**
     * &#x4FEE;&#x6539;&#x8D2D;&#x7269;&#x8F66;&#x4E2D;&#x5546;&#x54C1;&#x7684;&#x89C4;&#x683C;
     * @return
     * @param cartItem
     *
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * 清空购物车
     * @param memberId
     * @return
     */
    int clear(Long memberId);
}
