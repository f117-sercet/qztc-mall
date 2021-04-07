package com.dsc.mall.servcie.impl;

import com.dsc.mall.dao.CmsPrefrenceAreaProductRelationDao;
import com.dsc.mall.mapper.CmsPrefrenceAreaMapper;
import com.dsc.mall.model.CmsPrefrenceArea;
import com.dsc.mall.model.CmsPrefrenceAreaExample;
import com.dsc.mall.servcie.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选管理Servcie实现类
 * @Author:estic
 * @Date: 2021/4/7 21:51
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {

    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;
    @Override
    public List<CmsPrefrenceArea> listAll() {

        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
