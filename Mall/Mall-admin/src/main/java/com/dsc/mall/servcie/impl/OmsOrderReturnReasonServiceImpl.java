package com.dsc.mall.servcie.impl;

import com.dsc.mall.mapper.OmsOrderReturnReasonMapper;
import com.dsc.mall.model.OmsOrderReturnReason;
import com.dsc.mall.servcie.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 订单原因管理Service实现类
 * @Author:estic
 * @Date: 2021/4/14 22:10
 */
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {

    @Autowired
    private OmsOrderReturnReasonMapper returnReasonMapper;


    @Override
    public int create(OmsOrderReturnReason returnReason) {

        returnReason.setCreateTime(new Date());

        return returnReasonMapper.insert(returnReason);
    }

    @Override
    public int update(Long id, OmsOrderReturnReason returnReason) {

        returnReason.setId(id);

        return returnReasonMapper.updateByPrimaryKey(returnReason);
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        return 0;
    }

    @Override
    public OmsOrderReturnReason getItem(Long id) {
        return null;
    }
}
