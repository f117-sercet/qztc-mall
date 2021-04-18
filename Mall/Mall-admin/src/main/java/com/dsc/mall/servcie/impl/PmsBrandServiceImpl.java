package com.dsc.mall.servcie.impl;

import com.dsc.mall.dto.PmsBrandParam;
import com.dsc.mall.mapper.PmsBrandMapper;
import com.dsc.mall.mapper.PmsProductMapper;
import com.dsc.mall.model.PmsBrand;
import com.dsc.mall.model.PmsBrandExample;
import com.dsc.mall.servcie.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:estic
 * @Date: 2021/4/18 21:45
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;


    @Override
    public List<PmsBrand> lsitAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());

    }

    @Override
    public int createBrand(PmsBrandParam pmsBrandParam) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return null;
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        return 0;
    }

    @Override
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        return 0;
    }
}
