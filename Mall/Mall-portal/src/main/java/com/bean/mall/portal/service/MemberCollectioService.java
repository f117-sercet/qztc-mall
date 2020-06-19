package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * 会员收藏Service
 */
public interface MemberCollectioService {
    int add(MemberProductCollection productCollection);

    int delete(Long productId);

    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);
}
