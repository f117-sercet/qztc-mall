package com.bean.mall.service.impl;

import com.bean.mall.dao.OmsOrderDao;
import com.bean.mall.dao.OmsOrderOperateHistoryDao;
import com.bean.mall.dto.*;
import com.bean.mall.service.OmsOrderService;
import com.bean.mapper.OmsOrderMapper;
import com.bean.mapper.OmsOrderOperateHistoryMapper;
import com.bean.model.OmsOrder;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 订单管理Service实现类
 */
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderDao orderDao;
    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;
    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;
    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        return 0;
    }

    @Override
    public int close(List<Long> ids, String note) {
        return 0;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return null;
    }

    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        return 0;
    }

    @Override
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
        return 0;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        return 0;
    }
}
