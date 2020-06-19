package com.bean.mall.portal.service.impl;

import com.bean.mall.portal.domain.MemberBrandAttention;
import com.bean.mall.portal.repository.MemberBrandAttentionRepository;
import com.bean.mall.portal.service.MemberAttentionService;
import com.bean.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 会员关注实现类
 */
@Service
public class MemberAttentionServiceImpl implements MemberAttentionService {
    @Autowired
    private MemberBrandAttentionRepository memberBrandAttentionRepository;
    @Autowired
    private UmsMemberService memberService;
    @Override
    public int add(MemberBrandAttention memberBrandAttention) {
        return 0;
    }

    @Override
    public int delete(Long brandId) {
        return 0;
    }

    @Override
    public Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize) {
        return null;
    }
}
