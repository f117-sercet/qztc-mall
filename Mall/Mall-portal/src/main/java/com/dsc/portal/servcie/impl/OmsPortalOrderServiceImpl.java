package com.dsc.portal.servcie.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.dsc.mall.api.CommonPage;
import com.dsc.mall.exception.Asserts;
import com.dsc.mall.mapper.*;
import com.dsc.mall.model.*;
import com.dsc.mall.service.RedisService;
import com.dsc.portal.component.CancelOrderSender;
import com.dsc.portal.dao.PortalOrderDao;
import com.dsc.portal.dao.PortalOrderItemDao;
import com.dsc.portal.dao.SmsCouponHistoryDao;
import com.dsc.portal.domain.*;
import com.dsc.portal.servcie.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *前台会员管理Service
 * @author 60221
 */
public class OmsPortalOrderServiceImpl implements OmsPortalOrderServcie {
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
    private
    PortalOrderItemDao orderItemDao;
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
    public ConfirmOrderResult generatorConfirmOrder(List<Long> cartIds) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        //获取购物车信息
        UmsMember currentMember = memberService.getCurrentMember();
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),cartIds);
        result.setCartPromotionItemList(cartPromotionItemList);
        //获取用户收货地址列表
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.list();
        result.setMemberReceiveAddressList(memberReceiveAddressList);
        //获取用户可用优惠券列表
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList,1);
        result.setCouponHistoryDetailList(couponHistoryDetailList);
        //获取用户积分
        result.setMemberIntegration(currentMember.getIntegration());
        //获取积分使用规则
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        result.setIntegrationConsumeSetting(integrationConsumeSetting);
        //计算总金额，活动优惠，应付金额
        ConfirmOrderResult.CalcAmount calcAmount = calcCartAmount(cartPromotionItemList);
        result.setCalcAmount(calcAmount);
        return result;
    }

    /**
     * 计算购物车中商品的价格
     * @param cartPromotionItemList
     * @return
     */
    private ConfirmOrderResult.CalcAmount calcCartAmount(List<CartPromotionItem> cartPromotionItemList) {
        ConfirmOrderResult.CalcAmount calcAmount = new ConfirmOrderResult.CalcAmount();
        calcAmount.setFreightAmount(new BigDecimal(0));
        BigDecimal totalAmount = new BigDecimal("0");
        BigDecimal promotionAmount = new BigDecimal("0");
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            totalAmount = totalAmount.add(cartPromotionItem.getPrice().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
            promotionAmount = promotionAmount.add(cartPromotionItem.getReduceAmount().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
        }
        calcAmount.setTotalAmount(totalAmount);
        calcAmount.setPromotionAmount(promotionAmount);
        calcAmount.setPayAmount(totalAmount.subtract(promotionAmount));
        return calcAmount;
    }


    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        List<OmsOrderItem> orderItemList = new ArrayList<>();
        //获取购物车及优惠信息
        UmsMember currentMember = memberService.getCurrentMember();
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),orderParam.getCartIds());
        for (CartPromotionItem cartPromotionItem:cartPromotionItemList){
            //生成下单信息
            OmsOrderItem orderItem = new OmsOrderItem();
            orderItem.setProductId(cartPromotionItem.getProductId());
            orderItem.setProductName(cartPromotionItem.getProductName());
            orderItem.setProductPic(cartPromotionItem.getProductPic());
            orderItem.setProductAttr(cartPromotionItem.getProductAttr());
            orderItem.setProductBrand(cartPromotionItem.getProductBrand());
            orderItem.setProductSn(cartPromotionItem.getProductSn());
            orderItem.setProductPrice(cartPromotionItem.getPrice());
            orderItem.setProductQuantity(cartPromotionItem.getQuantity());
            orderItem.setProductSkuId(cartPromotionItem.getProductSkuId());
            orderItem.setProductSkuCode(cartPromotionItem.getProductSkuCode());
            orderItem.setProductCategoryId(cartPromotionItem.getProductCategoryId());
            orderItem.setPromotionAmount(cartPromotionItem.getReduceAmount());
            orderItem.setPromotionName(cartPromotionItem.getPromotionMessage());
            orderItem.setGiftIntegration(cartPromotionItem.getIntegration());
            orderItem.setGiftGrowth(cartPromotionItem.getGrowth());
            orderItemList.add(orderItem);
        }
        //判断购物车中商品是否都有库存
        if(!hashStock(cartPromotionItemList)){
            Asserts.fail("库存不足，无法下单");
        }
        //判断是否使用了优惠券
        if(orderParam.getCouponId() == null){
            //不用优惠券
            for(OmsOrderItem orderItem : orderItemList){
                orderItem.setCouponAmount(new BigDecimal(0));
            }
        }else {
            SmsCouponHistoryDetail couponHistoryDetail = getUseCoupon(cartPromotionItemList, orderParam.getCouponId());
            if (couponHistoryDetail == null) {
                Asserts.fail("该优惠券不可用");
            }
            //对下单商品的优惠券进行处理
            //对下单商品的优惠券进行处理
            handleCouponAmount(orderItemList, couponHistoryDetail);
        }
        //判断是否使用积分
        if (orderParam.getUseIntegration() == null ||orderParam.getUseIntegration().equals(0)){
            //不使用积分
            for (OmsOrderItem orderItem : orderItemList){
                orderItem.setIntegrationAmount(new BigDecimal(0));
            }
        }else {
            //使用积分
            BigDecimal totalAmount = calcTotalAmount(orderItemList);
            BigDecimal integrationAmount = getUseIntegrationAmount(orderParam.getUseIntegration(), totalAmount, currentMember, orderParam.getCouponId() != null);
            if (integrationAmount.compareTo(new BigDecimal(0)) == 0) {
                Asserts.fail("积分不可用");
        }else {
                for (OmsOrderItem orderItem : orderItemList) {
                    BigDecimal perAmount = orderItem.getProductPrice().divide(totalAmount, 3, RoundingMode.HALF_EVEN).multiply(integrationAmount);
                    orderItem.setIntegrationAmount(perAmount);
                }
            }
        }
        //计算order_item的实付金额
        handleRealAmount(orderItemList);
        //进行库存锁定
        lockStock(cartPromotionItemList);
        //根据商品合计，运费，活动优惠，优惠券，积分计算应付金额
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setDiscountAmount(new BigDecimal(0));
        omsOrder.setTotalAmount(calcTotalAmount(orderItemList));
        omsOrder.setFreightAmount(new BigDecimal(0));
        omsOrder.setPromotionAmount(calcPromotionAmount(orderItemList));
        omsOrder.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        if (orderParam.getCouponId() == null){
            omsOrder.setCouponAmount(new BigDecimal(0));
        }else{

            omsOrder.setCouponId(orderParam.getCouponId());
            omsOrder.setCouponAmount(calcCouponAmount(orderItemList));
        }
        if (orderParam.getUseIntegration() == null){
            omsOrder.setIntegration(0);
            omsOrder.setIntegrationAmount(new BigDecimal(0));
        }else{
            omsOrder.setIntegration(orderParam.getUseIntegration());
            omsOrder.setIntegrationAmount(calcIntegrationAmount(orderItemList));
        }
        omsOrder.setPayAmount(calcPayAmount(omsOrder));
        //转化为订单信息并插入数据库
        omsOrder.setMemberId(currentMember.getId());
        omsOrder.setCreateTime(new Date());
        omsOrder.setMemberUsername(currentMember.getUsername());
        //支付方式：0—>未支付；1->支付宝； 2->微信
        omsOrder.setPayType(omsOrder.getPayType());
        //订单来源：0->pc订单；1->app订单
        omsOrder.setSourceType(1);
        //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        omsOrder.setSourceType(0);
        //订单类型 0.正常订单 1.秒杀订单
        omsOrder.setOrderType(0);
        //收货人信息：姓名，电话，邮编，地址
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(orderParam.getMemberReceiveAddressId());
        omsOrder.setReceiverName(address.getName());
        omsOrder.setReceiverPhone(address.getPhoneNumber());
        omsOrder.setReceiverPostCode(address.getPostCode());
        omsOrder.setReceiverProvince(address.getProvince());
        omsOrder.setReceiverCity(address.getCity());
        omsOrder.setReceiverRegion(address.getRegion());
        omsOrder.setReceiverDetailAddress(address.getDetailAddress());
        // 0.未确认；1.已确认
        omsOrder.setConfirmStatus(0);
        omsOrder.setDeleteStatus(0);
        //计算赠送积分
        omsOrder.setIntegration(calcGifIntegration(orderItemList));
        //计算赠送成长值
        omsOrder.setGrowth(calcGifGrowth(orderItemList));
        //生成订单号
        omsOrder.setOrderSn(generateOrderSn(omsOrder));
        //设置自动收货天数
        List<OmsOrderSetting> orderSettings = orderSettingMapper.selectByExample(new OmsOrderSettingExample());
        if (CollUtil.isNotEmpty(orderSettings)){
            omsOrder.setAutoConfirmDay(orderSettings.get(0).getConfirmOvertime());
        }
        //插入order表和order_item表
        orderMapper.insert(omsOrder);
        for (OmsOrderItem orderItem:orderItemList){
            orderItem.setOrderId(omsOrder.getId());
            orderItem.setOrderSn(omsOrder.getOrderSn());

        }
        orderItemDao.insertList(orderItemList);
        //如果使用优惠券更新优惠券及使用状态
        if (orderParam.getCouponId()!=null){
            updateCouponStatus(orderParam.getCouponId(), currentMember.getId(), 1);
        }
        //如使用积分需扣除积分
        if (orderParam.getUseIntegration()!=null){
            omsOrder.setUseIntegration(orderParam.getUseIntegration());
            memberService.updateIntegration(currentMember.getId(), currentMember.getIntegration() - orderParam.getUseIntegration());
        }
        //删除购物车中的下单商品
        deleteCartItemList(cartPromotionItemList,currentMember);
        //发送延迟消息取消订单
        sendDelayMessageCancelOrder(omsOrder.getId());
        Map<String,Object> result = new HashMap<>();
        result.put("order",omsOrder);
        result.put("orderItemList",orderItemList);
        return result;
    }

    /**
     * 计算该订单赠送的成长值成长值
     * @param orderItemList
     * @return
     */
    private Integer calcGifGrowth(List<OmsOrderItem> orderItemList) {

        Integer sum = 0;
        for (OmsOrderItem orderItem:orderItemList){
            sum = sum + orderItem.getGiftGrowth() * orderItem.getProductQuantity();
        }
        return sum;

    }

    /**
     * 计算该订单赠送的积分
     * @param orderItemList
     * @return
     */
    private Integer calcGifIntegration(List<OmsOrderItem> orderItemList) {

        int sum = 0;
        for (OmsOrderItem orderItem : orderItemList) {
            sum += orderItem.getGiftIntegration() * orderItem.getProductQuantity();

        }
            return sum;


    }

    /**
     * 计算订单应付金额
     * @param omsOrder
     * @return
     */
    private BigDecimal calcPayAmount(OmsOrder omsOrder) {
        //总金额+运费——促销优惠-优惠券优惠-积分抵扣
        BigDecimal payAmount = omsOrder.getTotalAmount()
                .add(omsOrder.getFreightAmount())
                .subtract(omsOrder.getPromotionAmount())
                .subtract(omsOrder.getCouponAmount())
                .subtract(omsOrder.getIntegrationAmount());
        return payAmount;
    }

    /**
     * 计算订单优惠券金额
     * @param orderItemList
     * @return
     */
    private BigDecimal calcIntegrationAmount(List<OmsOrderItem> orderItemList) {

        BigDecimal integrationAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList){
            if (orderItem.getIntegrationAmount() != null) {
                integrationAmount = integrationAmount.add(orderItem.getIntegrationAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return integrationAmount;
        }

    /**
     * 计算订单优惠券金额
     * @param orderItemList
     * @return
     */
    private BigDecimal calcCouponAmount(List<OmsOrderItem> orderItemList) {

        BigDecimal couponAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem :orderItemList){
            if (orderItem.getCouponAmount()!=null){
                couponAmount = couponAmount.add(orderItem.getCouponAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return couponAmount;
            }

    /**
     * 获取订单促销的信息
     * @param orderItemList
     * @return
     */
    private String getOrderPromotionInfo(List<OmsOrderItem> orderItemList) {

        StringBuilder sb = new StringBuilder();
        for (OmsOrderItem orderItem:orderItemList){
            sb.append(orderItem.getPromotionName());
            sb.append(";");
        }
        String result = sb.toString();
        if (result.endsWith(";")){
            result = result.substring(0,result.length()-1);
        }
         return  result;
    }

    private BigDecimal calcPromotionAmount(List<OmsOrderItem> orderItemList) {

        BigDecimal promotionAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem:orderItemList){
            if (orderItem.getPromotionAmount()!=null){
                promotionAmount = promotionAmount.add(orderItem.getPromotionAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return promotionAmount;
        }


    private void lockStock(List<CartPromotionItem> cartPromotionItemList) {
    }

    /**
     * 获取可用积分抵扣金额
     * @param useIntegration
     * @param totalAmount
     * @param currentMember
     * @param b
     * @return
     */
    private BigDecimal getUseIntegrationAmount(Integer useIntegration, BigDecimal totalAmount, UmsMember currentMember, boolean b) {

        BigDecimal zeroAmount = new BigDecimal(0);
        //判断用户是否有这么多积分
        if(useIntegration.compareTo(currentMember.getIntegration())>0){
            return zeroAmount;
        }
        //根据积分使用规则判断是否可用
        //是否可与优惠券共用
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        if (hashCoupon && integrationConsumeSetting.getCouponStatus().equals(0)){
            //不可与优惠券共用
            return zeroAmount;
        }
        //是否达到最低使用积分门槛
        if (useIntegration.compareTo(integrationConsumeSetting.getUseUnit()) < 0) {
            return zeroAmount;
        }
        //是否超过订单抵用最高百分比
        BigDecimal integrationAmount = new BigDecimal(useIntegration).divide(new BigDecimal(integrationConsumeSetting.getUseUnit()), 2, RoundingMode.HALF_EVEN);
        BigDecimal maxPercent = new BigDecimal(integrationConsumeSetting.getMaxPercentPerOrder()).divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
        if (integrationAmount.compareTo(totalAmount.multiply(maxPercent)) > 0) {
            return zeroAmount;
        }
        return integrationAmount;
    }


    private void handleRealAmount(List<OmsOrderItem> orderItemList) {

        for (OmsOrderItem orderItem:orderItemList){
            //原价-促销优惠-优惠券抵扣-积分抵扣
            BigDecimal realAmount = orderItem.getProductPrice()
                    .subtract(orderItem.getPromotionAmount())
                    .subtract(orderItem.getCouponAmount())
                    .subtract(orderItem.getIntegrationAmount());
            orderItem.setRealAmount(realAmount);
        }
    }

    private BigDecimal calcTotalAmount(List<OmsOrderItem> orderItemList) {
    }

    private void handleCouponAmount(List<OmsOrderItem> orderItemList, SmsCouponHistoryDetail couponHistoryDetail) {
    }

    private SmsCouponHistoryDetail getUseCoupon(List<CartPromotionItem> cartPromotionItemList, Long couponId) {
    }

    /**
     * 判断下单商品是否有库存
     * @param cartPromotionItemList
     * @return
     */
    private boolean hashStock(List<CartPromotionItem> cartPromotionItemList) {
        for(CartPromotionItem cartPromotionItem:cartPromotionItemList){
            if (cartPromotionItem.getRealStock()==null||cartPromotionItem.getRealStock() <= 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer paySuccsess(Long orderId, Integer payType) {
        //修改订单状态
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setStatus(1);
        order.setPaymentTime(new Date());
        order.setPayType(payType);
        orderMapper.updateByPrimaryKeySelective(order);
        //恢复所有下单商品的锁定库存，扣减真实库存
        OmsOrderDetail orderDetail = portalOrderDao.getDetail(orderId);
        int count = portalOrderDao.updateSkuStock(orderDetail.getOrderItemList());
        return count;
    }

    @Override
    public Integer cancelTimeOutOrder() {
        Integer count=0;
        OmsOrderSetting omsOrderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        //查询超时，未支付的订单及订单详情
        List<OmsOrderDetail> timeOutOrders = portalOrderDao.getTimeOutOrders(omsOrderSetting.getNormalOrderOvertime());
        if (CollectionUtils.isEmpty(timeOutOrders)){
            return count;
        }
        //修改订单状态为建议取消
        List<Long> ids = new ArrayList<>();
        for (OmsOrderDetail timeOutOrder:timeOutOrders){
            ids.add(timeOutOrder.getId());
        }
        portalOrderDao.updateOrderStatus(ids,4);
        for (OmsOrderDetail timeOutOrder:timeOutOrders){
            //解除订单商品库存锁定
            portalOrderDao.releaseSkuStockLock(timeOutOrder.getOrderItemList());
            //修改订单商品库存
            updateCouponStatus(timeOutOrder.getCouponId(),timeOutOrder.getMemberId(),0);
            //返还积分
            if (timeOutOrder.getMemberUsername()!=null) {
                UmsMember member = memberService.getById(timeOutOrder.getMemberId());
                memberService.updateIntegration(timeOutOrder.getMemberId(), member.getIntegration() + timeOutOrder.getUseIntegration());
            }
            }


        return timeOutOrders.size();
    }

    @Override
    public void cancelOrder(Long orderId) {
        //查询未付款的取消订单
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andStatusEqualTo(0)
                .andDeleteStatusEqualTo(0);
        List<OmsOrder> cancelOrderList = orderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(cancelOrderList)){
            return;
        }
        OmsOrder cancelOrder =cancelOrderList.get(0);
        if (cancelOrder!=null){
            //修改订单取消状态
            cancelOrder.setStatus(4);
            orderMapper.updateByPrimaryKeySelective(cancelOrder);
            OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
            orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);
            //解除订单商品库存锁定
            if(!CollectionUtils.isEmpty(orderItemList)){
                portalOrderDao.releaseSkuStockLock(orderItemList);
            }
            //修改优惠券使用状态
            updateCouponStatus(cancelOrder.getCouponId(), cancelOrder.getMemberId(), 0);
            //返还使用积分
            if (cancelOrder.getUseIntegration() != null) {
                UmsMember member = memberService.getById(cancelOrder.getMemberId());
                memberService.updateIntegration(cancelOrder.getMemberId(), member.getIntegration() + cancelOrder.getUseIntegration());
            }
        }
    }

    /**
     * 将优惠券信息更改为指定状态
     * @param couponId 优惠券id
     * @param memberId 会员id
     * @param useStatus 0->未使用; 1->已使用
     */
    private void updateCouponStatus(Long couponId, Long memberId, int useStatus) {

        if (couponId == null) {
            return;
        }
        //查询第一张优惠券
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        example.createCriteria().andMemberIdEqualTo(memberId)
                .andCouponIdEqualTo(couponId).andUseStatusEqualTo(useStatus == 0 ? 1 : 0);
        List<SmsCouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(couponHistoryList)) {
            SmsCouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(new Date());
            couponHistory.setUseStatus(useStatus);
            couponHistoryMapper.updateByPrimaryKeySelective(couponHistory);
        }
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        long delayTimes = orderSetting.getNormalOrderOvertime()*60*1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId,delayTimes);

    }

    @Override
    public void confirmReceiveOrder(Long orderId) {
        UmsMember member = memberService.getCurrentMember();
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (!member.getId().equals(order.getMemberId())){
            Asserts.fail("无法确认订单");
        }
        if (order.getStatus()!=2){
            Asserts.fail("该订单的中所有商品还未发货");
        }
        order.setStatus(3);
        order.setConfirmStatus(1);
        order.setReceiveTime(new Date());
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize) {
      if (status==-1){
          status = null;
      }
      UmsMember member = memberService.getCurrentMember();
        PageHelper.startPage(pageNum,pageSize);
        OmsOrderExample orderExample = new OmsOrderExample();
        OmsOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0)
                .andMemberIdEqualTo(member.getId());
        if (status!=null){
            criteria.andStatusEqualTo(status);
        }
        orderExample.setOrderByClause("create_time desc");
        List<OmsOrder> orderList = orderMapper.selectByExample(orderExample);
        CommonPage<OmsOrder> orderPage =CommonPage.restPage(orderList);
        CommonPage<OmsOrderDetail> resultPage = new CommonPage<>();
        resultPage.setPageNum(orderPage.getPageNum());
        resultPage.setPageSize(orderPage.getPageSize());
        resultPage.setTotal(orderPage.getTotal());
        resultPage.setTotalPage(orderPage.getTotalPage());
        if(CollUtil.isEmpty(orderList)){
            return resultPage;
        }
        //设置数据信息
        List<Long> orderIds = orderList.stream().map(OmsOrder::getId).collect(Collectors.toList());
        OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
        orderItemExample.createCriteria().andOrderIdIn(orderIds);
        List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);
        List<OmsOrderDetail> orderDetailList = new ArrayList<>();
        for (OmsOrder omsOrder : orderList) {
            OmsOrderDetail orderDetail = new OmsOrderDetail();
            BeanUtil.copyProperties(omsOrder,orderDetail);
            List<OmsOrderItem> relatedItemList = orderItemList.stream().filter(item -> item.getOrderId().equals(orderDetail.getId())).collect(Collectors.toList());
            orderDetail.setOrderItemList(relatedItemList);
            orderDetailList.add(orderDetail);
        }
        resultPage.setList(orderDetailList);
        return resultPage;
    }

    @Override
    public OmsOrderDetail detail(Long orderId) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(orderId);
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(example);
        OmsOrderDetail orderDetail = new OmsOrderDetail();
        BeanUtil.copyProperties(omsOrder,orderDetail);
        orderDetail.setOrderItemList(orderItemList);
        return orderDetail;
    }

    @Override
    public void deleteOrder(Long orderId) {

        UmsMember member = memberService.getCurrentMember();
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (!member.getId().equals(order.getMemberId())) {
            Asserts.fail("不能删除他人订单！");
        }
        if (order.getStatus() == 3 || order.getStatus() == 4) {
            order.setDeleteStatus(1);
            orderMapper.updateByPrimaryKey(order);
        } else {
            Asserts.fail("只能删除已完成或已关闭的订单！");
        }
    }

    /**
     * 生成18位订单编号：8位日期+2位平台号码+2位支付方式+6位以上自增id
     * @param order
     * @return
     */
     private String generateOrderSn(OmsOrder order){
         StringBuilder sb = new StringBuilder();
         String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
         String key = REDIS_DATABASE+":"+ REDIS_KEY_ORDER_ID + date;
         Long increment = redisService.incr(key, 1);
         sb.append(date);
         sb.append(String.format("%02d", order.getSourceType()));
         sb.append(String.format("%02d", order.getPayType()));
         String incrementStr = increment.toString();
         if (incrementStr.length() <= 6) {
             sb.append(String.format("%06d", increment));
         } else {
             sb.append(incrementStr);
         }
         return sb.toString();
}

    /**
     * 删除下单商品的购物车信息
     * @param cartPromotionItemList
     * @param currentMember
     */
    private void deleteCartItemList(List<CartPromotionItem> cartPromotionItemList, UmsMember currentMember) {

        List<Long> ids = new ArrayList<>();
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            ids.add(cartPromotionItem.getId());
        }
        cartItemService.delete(currentMember.getId(), ids);
    }

}

