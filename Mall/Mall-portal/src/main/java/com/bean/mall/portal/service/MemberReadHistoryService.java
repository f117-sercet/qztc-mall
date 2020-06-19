package com.bean.mall.portal.service;

import com.bean.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 会员浏览记录管理Service
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);
    /**
     * 批量删除记录
     */
    int delete(List<String> ids);

    /**
     * 分页获取用户浏览历史记录
     */
    Page <MemberReadHistory> List(Integer pageNum, Integer pageSize);
}
