package com.dsc.portal.repository;

import com.dsc.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 寻找浏览历史
     * @param memberId
     * @param pageable
     * @return
     */
    Page<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId, Pageable pageable);

    /**
     * 删除所有
     * @param memberId
     */
    void deleteAllByMemberId(Long memberId);
}
