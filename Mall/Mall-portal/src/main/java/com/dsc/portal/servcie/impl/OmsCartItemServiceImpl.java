package com.dsc.portal.servcie.impl;

import cn.hutool.core.collection.CollUtil;
import com.dsc.mall.mapper.OmsCartItemMapper;
import com.dsc.mall.model.OmsCartItem;
import com.dsc.mall.model.OmsCartItemExample;
import com.dsc.mall.model.UmsMember;
import com.dsc.portal.dao.PortalProductDao;
import com.dsc.portal.domain.CartProduct;
import com.dsc.portal.domain.CartPromotionItem;
import com.dsc.portal.servcie.OmsCartItemService;
import com.dsc.portal.servcie.OmsPromotionService;
import com.dsc.portal.servcie.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 购物车管理Service实现类
 * @author 60221
 */
@Service
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
    public int add(OmsCartItem cartItem) {
        int count = 0;
        UmsMember currentMember = memberService.getCurrentMember();
        cartItem.setMemberId(currentMember.getId());
        cartItem.setMemberNickname(currentMember.getNickname());
        cartItem.setDeleteStatus(0);
        OmsCartItem existCartItem = getCartItem(cartItem);
        if (existCartItem == null){
            cartItem.setCreateDate(new Date());
        }else {
            cartItem.setModifyDate(new Date());
            existCartItem.setQuantity(existCartItem.getQuantity()+cartItem.getQuantity());
             count = cartItemMapper.updateByPrimaryKey(existCartItem);
        }

        return count;
    }

    /**
     * 根据会员id，商品id和规格获取购物车的中的商品
     * @param cartItem
     * @return
     */
    private OmsCartItem getCartItem(OmsCartItem cartItem) {

        OmsCartItemExample example = new OmsCartItemExample();
        OmsCartItemExample.Criteria criteria = example.createCriteria().andMemberIdEqualTo(cartItem.getMemberId())
                .andProductIdEqualTo(cartItem.getProductCategoryId()).andDeleteStatusEqualTo(0);
        if (!StringUtils.isEmpty(cartItem.getProductSkuId())) {
            criteria.andProductSkuIdEqualTo(cartItem.getProductSkuId());
        }
        List<OmsCartItem> cartItems = cartItemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(cartItems)) {
            return cartItems.get(0);
        }
        return null;

    }

    @Override
    public List<OmsCartItem> list(Long memberId) {
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andMemberIdEqualTo(memberId);
        return cartItemMapper.selectByExample(example);
    }

    @Override
    public List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds) {
        List<OmsCartItem> cartItemList = list(memberId);
        if(CollUtil.isNotEmpty(cartIds)){
            cartItemList = cartItemList.stream().filter(item->cartIds.contains(item.getId())).collect(Collectors.toList());
        }
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(cartItemList)){
            cartPromotionItemList = promotionService.calcCartPromotion(cartItemList);
        }
        return cartPromotionItemList;
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
     OmsCartItem cartItem = new OmsCartItem();
     cartItem.setQuantity(quantity);
     OmsCartItemExample example = new OmsCartItemExample();
     example.createCriteria().andDeleteStatusEqualTo(0)
             .andIdEqualTo(id).andMemberIdEqualTo(memberId);
     return cartItemMapper.updateByExampleSelective(cartItem,example);
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andIdIn(ids).andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(record, example);
    }
    @Override
    public CartProduct getCartProduct(Long productId) {
        return productDao.getCartProduct(productId);
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        //删除原购物车信息
        OmsCartItem updateCart = new OmsCartItem();
        updateCart.setId(cartItem.getId());
        updateCart.setModifyDate(new Date());
        updateCart.setDeleteStatus(1);
        cartItemMapper.updateByPrimaryKeySelective(updateCart);
        cartItem.setId(null);
        add(cartItem);
        return 1;
    }

    @Override
    public int clear(Long memberId) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(record,example);
    }
}
