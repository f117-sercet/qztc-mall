package com.dsc.portal.servcie.impl;

import com.dsc.mall.exception.Asserts;
import com.dsc.mall.mapper.*;
import com.dsc.mall.model.SmsCoupon;
import com.dsc.mall.model.SmsCouponHistory;
import com.dsc.mall.model.SmsCouponHistoryExample;
import com.dsc.mall.model.UmsMember;
import com.dsc.portal.dao.SmsCouponHistoryDao;
import com.dsc.portal.domain.CartPromotionItem;
import com.dsc.portal.domain.SmsCouponHistoryDetail;
import com.dsc.portal.servcie.UmsMemberCouponService;
import com.dsc.portal.servcie.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 会员优惠券管理Service实现类
 * @author 60221
 */
@Service
public class UmsMemberCouponServiceImpl implements UmsMemberCouponService {

    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public void add(Long couponId) {
        UmsMember currentMember = memberService.getCurrentMember();
        //获取优惠券信息，判断数量
        SmsCoupon coupon = couponMapper.selectByPrimaryKey(couponId);
        if (coupon==null){
            Asserts.fail("优惠券不存在");
        }
        if(coupon.getCount()<=0){
            Asserts.fail("优惠券已经领完了");
        }
        Date now = new Date();
        if(now.before(coupon.getEnableTime())){
            Asserts.fail("优惠券还没到领取时间");
        }
        //判断用户领取的优惠券数量是否超过限制
        SmsCouponHistoryExample couponHistoryExample = new SmsCouponHistoryExample();
        couponHistoryExample.createCriteria().andCouponIdEqualTo(couponId).andMemberIdEqualTo(currentMember.getId());

    }

    @Override
    public List<SmsCouponHistory> listHistory(Integer useStatus) {
        UmsMember currentMember = memberService.getCurrentMember();
        SmsCouponHistoryExample couponHistoryExample = new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria =couponHistoryExample.createCriteria();
        criteria.andMemberIdEqualTo(currentMember.getId());
        if (useStatus!=null){
            criteria.andUseStatusEqualTo(useStatus);
        }
        return couponHistoryMapper.selectByExample(couponHistoryExample);
    }

    @Override
    public List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartPromotionItemList, Integer type) {
        return null;
    }

    @Override
    public List<SmsCoupon> listByProduct(Long productId) {
        return null;
    }

    @Override
    public List<SmsCoupon> list(Integer useStatus) {
        UmsMember member = memberService.getCurrentMember();
        return couponHistoryDao.getCouponList(member.getId(),useStatus);
    }
}
