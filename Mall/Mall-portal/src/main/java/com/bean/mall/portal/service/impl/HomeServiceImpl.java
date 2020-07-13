package com.bean.mall.portal.service.impl;

import com.bean.mall.portal.dao.HomeDao;
import com.bean.mall.portal.domain.FlashPromotionProduct;
import com.bean.mall.portal.domain.HomeContentResult;
import com.bean.mall.portal.domain.HomeFlashPromotion;
import com.bean.mall.portal.service.HomeService;
import com.bean.mall.portal.util.DateUtil;
import com.bean.mapper.*;
import com.bean.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }


    private HomeFlashPromotion getHomeFlashPromotion(){
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotionSession flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotion flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartDate());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndDate());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {

            SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
            sessionExample.createCriteria()
                    .andStartTimeGreaterThan(date);
            sessionExample.setOrderByClause("start_time asc");
            List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
            if (!CollectionUtils.isEmpty(promotionSessionList)) {
                return promotionSessionList.get(0);
            }
            return null;
        }


    /**
     * 更具时间获取秒杀活动
     * @param date
     * @return
     */
    private SmsFlashPromotion getFlashPromotionSession(Date date) {
        Date currentDate = DateUtil.getDate(date);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(currentDate)
                .andEndDateGreaterThanOrEqualTo(currentDate);
        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotionList)) {
            return flashPromotionList.get(0);
        }
        return null;
    }

    /**
     * 根据时间获取秒杀场次
     * @param date
     * @return
     */
    private SmsFlashPromotionSession getFlashPromotion(Date date) {
        Date currentTime= DateUtil.getTime(date);
        SmsFlashPromotionSessionExample sessionExample =new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria().andStartTimeLessThanOrEqualTo(currentTime)
                .andEndTimeGreaterThanOrEqualTo(currentTime);

        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return  promotionSessionList.get(0);
        }
        return null;
    }
    }



