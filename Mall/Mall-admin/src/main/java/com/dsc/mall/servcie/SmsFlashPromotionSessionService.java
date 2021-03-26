package com.dsc.mall.servcie;

import com.dsc.mall.dto.SmsFlashPromotionSessionDetail;
import com.dsc.mall.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * 限时购场次管理Service
 * @Author:estic
 * @Date: 2021/3/26 9:52
 */
public interface SmsFlashPromotionSessionService {

    /**
     * 添加场次
     * @param promotionSession
     * @return
     */

    int create(SmsFlashPromotionSession promotionSession);


    /**
     * 修改场次
     * @param id
     * @param promotionSession
     * @return
     */

    int update(Long id, SmsFlashPromotionSession promotionSession);

    /**
     * 修改场次启用状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Long id, Integer status);

    /**
     * 删除场次
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 获取详情
     * @param id
     * @return
     */
    SmsFlashPromotionSession getItem(Long id);

    /**
     * 根据启用状态获取场次列表
     * @return
     */
    List<SmsFlashPromotionSession> list();

    /**
     *  获取全部可选场次及其数量
     * @param flashPromotionId
     * @return
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
