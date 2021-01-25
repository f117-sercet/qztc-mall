package com.dsc.portal.repository;

import com.dsc.portal.domain.MemberRedHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRedHistoryRepository extends MongoRepository<MemberRedHistory,String> {
    /**
     * 寻找浏览历史
     * @param memberId
     * @param pageable
     * @return
     */
    Page<MemberRedHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId, Pageable pageable);

    /**
     * 删除所有
     * @param memberId
     */
    void deleteAllByMemberId(Long memberId);
}
