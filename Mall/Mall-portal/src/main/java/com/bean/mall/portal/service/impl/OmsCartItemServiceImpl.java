package com.bean.mall.portal.service.impl;

import com.bean.mall.portal.dao.PortalProductDao;
import com.bean.mall.portal.domain.CartProduct;
import com.bean.mall.portal.domain.CartPromotiomItem;
import com.bean.mall.portal.service.OmsCartItemService;
import com.bean.mall.portal.service.OmsPromotionService;
import com.bean.mall.portal.service.UmsMemberService;
import com.bean.mapper.OmsCartItemMapper;
import com.bean.model.OmsCartItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 购物车管理Service实现类
 */

public class OmsCartItemServiceImpl implements OmsCartItemService {
    @Autowired
    private OmsCartItemMapper cartItemMapper;
    @Autowired
    private PortalProductDao productDao;
    @Autowired
    private OmsPromotionService promotionService;
    @Autowired
    private UmsMemberService memberService;


    @Override
    public int addOr(OmsCartItem omsCartItem) {
        return 0;
    }

    @Override
    public List<OmsCartItem> list(Long memberId) {
        return null;
    }

    @Override
    public List<CartPromotiomItem> listPromotion(Long memberId, List<Long> cartIds) {
        return null;
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        return 0;
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        return 0;
    }

    @Override
    public CartProduct getCartProduct(Long productId) {
        return null;
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        return 0;
    }

    @Override
    public int clear(Long memberId) {
        return 0;
    }
}
