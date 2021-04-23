package com.dsc.mall.servcie.impl;

import com.dsc.mall.mapper.SmsFlashPromotionMapper;
import com.dsc.mall.model.SmsFlashPromotion;
import com.dsc.mall.model.SmsFlashPromotionExample;
import com.dsc.mall.servcie.SmsFlashPromotionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 限时购物活动管理Service实现类
 * @Author:estic
 * @Date: 2021/4/23 14:27
 */
@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService {
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;

    @Override
    public int create(SmsFlashPromotion flashPromotion) {
        flashPromotion.setCreateTime(new Date());
        return flashPromotionMapper.insert(flashPromotion);
    }

    @Override
    public int update(Long id, SmsFlashPromotion flashPromotion) {
       flashPromotion.setId(id);
        return flashPromotionMapper.updateByPrimaryKey(flashPromotion);
    }
    @Override
    public int delete(Long id){
        return flashPromotionMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int updateStatus(Long id, Integer status) {
     SmsFlashPromotion flashPromotion = new SmsFlashPromotion();
     flashPromotion.setId(id);
     flashPromotion.setStatus(status);
        return flashPromotionMapper.updateByPrimaryKeySelective(flashPromotion);
    }

    @Override
    public SmsFlashPromotion getItem(Long id) {
        return flashPromotionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andTitleLike("%" + keyword + "%");
        }
        return flashPromotionMapper.selectByExample(example);
    }
}
