package com.bean.mall.portal.service.impl;

import com.bean.mall.portal.dao.HomeDao;
import com.bean.mall.portal.domain.FlashPromotionProduct;
import com.bean.mall.portal.domain.HomeContentResult;
import com.bean.mall.portal.domain.HomeFlashPromotion;
import com.bean.mall.portal.service.HomeService;
import com.bean.mapper.*;
import com.bean.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 首页内容管理Service实现类
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result=new HomeContentResult();
        //获取广告首页
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐商品
        result.setBrandList(homeDao.getRecomendBrand(0,4));
        //获取秒杀商品信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新商品推荐
        result.setNewProductList(homeDao.getNewProductList(0,4));
        //获取人气推荐
        result.setHotProductList(homeDao.getHotProductList(0,4));
        //获取推荐专题
        result.setSubjectList(homeDao.getRecommendSubjectList(0,4));
        return result;
    }


    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        //暂时默认推荐所有商品
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example=new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andPublishStatusEqualTo(1);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        PmsProductCategoryExample example=new PmsProductCategoryExample();
        example.createCriteria().andShowStatusEqualTo(1).andParentIdEqualTo(parentId);
        example.setOrderByClause("sort desc");
        return  productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        if (cateId!=null){
            criteria.andCategoryIdEqualTo(cateId);
        }
         return  subjectMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return homeDao.getHotProductList(offset, pageSize);
    }

    @Override
    public List<PmsProduct> newPmsProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return homeDao.getNewProductList(offset, pageSize);
    }
    private HomeFlashPromotion getHomeFlashPromotion(){
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<aFlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

}

