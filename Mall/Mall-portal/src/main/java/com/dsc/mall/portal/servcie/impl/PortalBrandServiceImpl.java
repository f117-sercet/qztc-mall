package com.dsc.mall.portal.servcie.impl;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.mapper.PmsBrandMapper;
import com.dsc.mall.mapper.PmsProductMapper;
import com.dsc.mall.model.PmsBrand;
import com.dsc.mall.model.PmsProduct;
import com.dsc.mall.model.PmsProductExample;
import com.dsc.mall.portal.dao.HomeDao;
import com.dsc.mall.portal.servcie.PortalBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前台品牌管理Service实现类
 * @author 60221
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {

    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum-1)*pageSize;
        return homeDao.getRecommendBrandList(offset,pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
