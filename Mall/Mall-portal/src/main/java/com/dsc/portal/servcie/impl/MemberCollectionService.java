package com.dsc.portal.servcie.impl;

import com.dsc.mall.model.UmsMember;
import com.dsc.portal.domain.MemberProductCollection;
import com.dsc.portal.repository.MemberProductCollectionRepository;
import com.dsc.portal.servcie.MemberCollectionServcie;
import com.dsc.portal.servcie.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 会员收藏Service实现类
 * @author 60221
 */
@Service
public class MemberCollectionService implements MemberCollectionServcie {

    @Autowired
    private MemberProductCollectionRepository productCollectionRepository;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public int add(MemberProductCollection productCollection) {
        int count = 0;
        UmsMember member = memberService.getCurrentMember();
        productCollection.setMemberId(member.getId());
        productCollection.setMemberNickname(member.getNickname());
        productCollection.setMemberIcon(member.getIcon());
        MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(productCollection.getMemberId(), productCollection.getProductId());
        if (findCollection == null) {
            productCollectionRepository.save(productCollection);
            count = 1;
        }
        return count;
    }


    @Override
    public int delete(Long productId) {
        UmsMember member = memberService.getCurrentMember();
        return productCollectionRepository.deleteByMemberIdAndProductId(member.getId(), productId);
    }

    @Override
    public Page<MemberProductCollection> List(Integer pageNum, Integer pageSize) {
        UmsMember member = memberService.getCurrentMember();
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
        return  productCollectionRepository.findByMemberId(member.getId(),pageable);

    }

    @Override
    public MemberProductCollection detail(Long productId) {
        UmsMember member = memberService.getCurrentMember();
        return productCollectionRepository.findByMemberIdAndProductId(member.getId(), productId);
    }

    @Override
    public void clear() {
        UmsMember member = memberService.getCurrentMember();
        productCollectionRepository.deleteAllByMemberId(member.getId());
    }
}
