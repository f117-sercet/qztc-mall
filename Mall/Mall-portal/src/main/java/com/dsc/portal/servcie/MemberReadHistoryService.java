package com.dsc.portal.servcie;

import com.dsc.portal.domain.MemberRedHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 会员浏览记录管理Service
 * @author 60221
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     * @param memberRedHistory
     * @return
     */
    int create(MemberRedHistory memberRedHistory);

    /**
     * 批量删除用户浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 分页获取用户浏览历史记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberRedHistory> List(Integer pageNum,Integer pageSize);

    /**
     * 清空浏览记录
     */
    void clear();
}
