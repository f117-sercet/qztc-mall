package com.dsc.mall.servcie;

import com.dsc.mall.model.SmsFlashPromotion;

import java.util.List;

/**
 * 限时购活动管理Service
 * @Author:estic
 * @Date: 2021/3/26 9:44
 */
public interface SmsFlashPromotionService {

    /**
     * 添加活动
     * @param flashPromotion
     * @return
     */
    int create(SmsFlashPromotion flashPromotion);

    /**
     * 删除单个活动
     * @param id
     * @param flashPromotion
     * @return
     */
    int update(Long id, SmsFlashPromotion flashPromotion);

    /**
     * 删除单个活动
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改下线状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取详情信息
     * @param id
     * @return
     */

    SmsFlashPromotion getItem(Long id);

    /**
     * 分页查询活动
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);




}
