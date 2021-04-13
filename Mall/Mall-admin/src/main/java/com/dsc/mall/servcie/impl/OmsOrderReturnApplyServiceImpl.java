package com.dsc.mall.servcie.impl;

import com.dsc.mall.dao.OmsOrderReturnApplyDao;
import com.dsc.mall.dto.OmsOrderReturnApplyResult;
import com.dsc.mall.dto.OmsReturnApplyQueryParam;
import com.dsc.mall.dto.OmsUpdateStatusParam;
import com.dsc.mall.mapper.OmsOrderReturnApplyMapper;
import com.dsc.mall.model.OmsOrderReturnApply;
import com.dsc.mall.model.OmsOrderReturnApplyExample;
import com.dsc.mall.servcie.OmsOrderReturnApplyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单退货管理Servcie实现类
 * @Author:estic
 * @Date: 2021/4/13 20:30
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyDao returnApplyDao;

    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);

        return returnApplyDao.getList(queryParam);
    }

    @Override
    public int delete(List<Long> ids) {

        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(3);
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        return 0;
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return returnApplyDao.getDetail(id);
    }
}
