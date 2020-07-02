package com.bean.mall.portal.dao;

import com.bean.mall.portal.domain.SmsCouponHistoryDetail;
import com.bean.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);
    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus")Integer useStatus);
}

