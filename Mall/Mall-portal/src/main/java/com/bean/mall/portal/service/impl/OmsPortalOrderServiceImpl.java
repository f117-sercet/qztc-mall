package com.bean.mall.portal.service.impl;

import com.bean.mall.common.api.CommonPage;
import com.bean.mall.portal.compoent.CancelOrderSender;
import com.bean.mall.portal.dao.PortalOrderDao;
import com.bean.mall.portal.dao.PortalOrderItemDao;
import com.bean.mall.portal.dao.SmsCouponHistoryDao;
import com.bean.mall.portal.domain.CartPromotiomItem;
import com.bean.mall.portal.domain.ConfirmOrderResult;
import com.bean.mall.portal.domain.OmsOrderDetail;
import com.bean.mall.portal.domain.OrderParam;
import com.bean.mall.portal.service.*;
import com.bean.mapper.*;
import com.bean.model.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

/**
 * 前台订单管理
 */
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;
    @Autowired
    private UmsMemberCouponService memberCouponService;
    @Autowired
    private UmsIntegrationConsumeSettingMapper integrationConsumeSettingMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private PortalOrderItemDao orderItemDao;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Autowired
    private PortalOrderDao portalOrderDao;
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public ConfirmOrderResult generateConfirmOrder(List<Long> cartIds) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        //获取购物车信息
        UmsMember currentMember =memberService.getCurrentMember();
        List<CartPromotiomItem> cartPromotiomItemList=cartItemService.listPromotion(currentMember.getId(),cartIds);
        result.setCartPromotionItemList(cartPromotiomItemList);
        return null;
    }

    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        return null;
    }

    @Override
    public Integer PaySuccess(Long orderId, Integer payType) {
        return null;
    }

    @Override
    public Integer cancelTimeOutOrder() {
        return null;
    }

    @Override
    public void cancelOrder(Long orderId) {

    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {

    }

    @Override
    public void confirmReceiveOrder(Long orderId) {

    }

    @Override
    public CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public OmsOrderDetail detail(Long orderId) {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {

    }
}
