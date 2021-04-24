package com.dsc.mall.servcie.impl;

import com.dsc.mall.mapper.UmsMemberLevelMapper;
import com.dsc.mall.model.UmsMemberLevel;
import com.dsc.mall.model.UmsMemberLevelExample;
import com.dsc.mall.servcie.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * @Author:estic
 * @Date: 2021/4/24 10:57
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
