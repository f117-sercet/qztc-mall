package com.dsc.mall.servcie;

import com.dsc.mall.dto.SmsCouponParam;
import com.dsc.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 优惠券管理Service
 * @Author:estic
 * @Date: 2021/3/25 20:53
 */
public interface SmsCouponService {

    /**
     * 添加优惠券
     * @param couponParam
     * @return
     */
    @Transactional
    int create(SmsCouponParam couponParam);

    /**
     * 根据优惠券id删除优惠券
     * @param id
     * @return
     */
    @Transactional
    int delete(Long id);

    /**
     * 根据优惠券id更新优惠券信息
     * @param id
     * @param couponParam
     * @return
     */
    @Transactional
    int update(Long id, SmsCouponParam couponParam);


    /**
     * 分页获取优惠券列表
     * @param name
     * @param type
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 获取优惠券详情
     * @param id
     * @return
     */
    SmsCouponParam getItem(Long id);
}
