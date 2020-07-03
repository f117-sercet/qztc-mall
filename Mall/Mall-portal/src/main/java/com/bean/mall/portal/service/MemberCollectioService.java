package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * 会员收藏Service
 */
public interface MemberCollectioService {
    int delete(Long productId);
    int add(MemberProductCollection productCollection);
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    MemberProductCollection detail(Long productId);

    void clear();
}
