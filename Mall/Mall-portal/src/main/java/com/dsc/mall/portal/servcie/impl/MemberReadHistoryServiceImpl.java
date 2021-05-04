package com.dsc.mall.portal.servcie.impl;

import com.dsc.mall.model.UmsMember;
import com.dsc.mall.portal.domain.MemberReadHistory;
import com.dsc.mall.portal.repository.MemberReadHistoryRepository;
import com.dsc.mall.portal.servcie.MemberReadHistoryService;
import com.dsc.mall.portal.servcie.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览记录管理Service实现类
 * @author 60221
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository  memberReadHistoryRepository;

    @Autowired
    private UmsMemberService memberService;

    @Override
    public int create(MemberReadHistory memberRedHistory) {
        UmsMember member = memberService.getCurrentMember();
        memberRedHistory.setMemberId(member.getId());
        memberRedHistory.setMemberNickname(member.getNickname());
        memberRedHistory.setMemberIcon(member.getIcon());
        memberRedHistory.setId(null);
        memberRedHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberRedHistory);
        return 1;



    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for (String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public Page<MemberReadHistory> List(Integer pageNum, Integer pageSize) {

        UmsMember member = memberService.getCurrentMember();
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(member.getId(),pageable);
    }

    @Override
    public void clear() {
        UmsMember member = memberService.getCurrentMember();
        memberReadHistoryRepository.deleteAllByMemberId(member.getId());

    }
}
