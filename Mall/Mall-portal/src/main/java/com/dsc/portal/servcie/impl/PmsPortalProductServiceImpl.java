package com.dsc.portal.servcie.impl;

import cn.hutool.core.util.StrUtil;
import com.dsc.mall.mapper.*;
import com.dsc.mall.model.PmsProduct;
import com.dsc.mall.model.PmsProductCategory;
import com.dsc.mall.model.PmsProductCategoryExample;
import com.dsc.mall.model.PmsProductExample;
import com.dsc.portal.dao.PortalProductDao;
import com.dsc.portal.domain.PmsPortalProductDetail;
import com.dsc.portal.domain.PmsProductCategoryNode;
import com.dsc.portal.servcie.PmsPortalProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 前台订单管理Service实现类
 */
@Service
public class PmsPortalProductServiceImpl implements PmsPortalProductService {

    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductLadderMapper productLadderMapper;
    @Autowired
    private PmsProductFullReductionMapper productFullReductionMapper;
    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort) {

        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (StrUtil.isNotEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        if (brandId !=null) {
            criteria.andBrandIdEqualTo(brandId);
        }
        if (productCategoryId!=null){
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        //1->按新商品；2->按照销量；3->价格低到高；4->价格从高到低
        if (sort==1){
            example.setOrderByClause("id desc");
        }else if (sort==2){
            example.setOrderByClause("sale desc");
        }else if (sort==3){
            example.setOrderByClause("price asc");
        }else if (sort==4){
            example.setOrderByClause("price desc");
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategoryNode> categoryTreeList() {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        List<PmsProductCategory> allList = productCategoryMapper.selectByExample(example);
        List<PmsProductCategoryNode> result = allList.stream()
                .filter(item ->item.getParentId().equals(0L))
                .map(item -> covert(item,allList))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 初始对象转化为节点对象
     * @param item
     * @param allList
     * @return
     */
    private PmsProductCategoryNode covert(PmsProductCategory item, List<PmsProductCategory> allList) {

        PmsProductCategoryNode node = new PmsProductCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<PmsProductCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }



    @Override
    public PmsPortalProductDetail detail(Long id) {
        return null;
    }
}
