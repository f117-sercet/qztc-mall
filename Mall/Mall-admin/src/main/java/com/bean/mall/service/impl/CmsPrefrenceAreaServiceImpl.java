package com.bean.mall.service.impl;

import com.bean.mall.service.CmsPrefrenceAreaService;
import com.bean.mapper.CmsPrefrenceAreaMapper;
import com.bean.model.CmsPrefrenceArea;
import com.bean.model.CmsPrefrenceAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper PrefrenceAreaMapper;
    @Override
    public List<CmsPrefrenceArea> listAll() {
        return PrefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
