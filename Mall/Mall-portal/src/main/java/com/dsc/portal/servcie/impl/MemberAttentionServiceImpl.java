package com.dsc.portal.servcie.impl;

import com.dsc.portal.domain.MemberBrandAttention;
import com.dsc.portal.repository.MemberBrandAttentionRepository;
import com.dsc.portal.servcie.MemberAttentionService;
import com.dsc.portal.servcie.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * 会员关注Service实现类
 * @author 60221
 */
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
    public Page<MemberBrandAttention> lsit(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public MemberBrandAttention detail(Long brandId) {
        return null;
    }

    @Override
    public void clear() {

    }
}
