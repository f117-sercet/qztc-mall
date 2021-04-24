package com.dsc.mall.servcie;

import com.dsc.mall.model.SmsHomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页专题推荐管理Service
 * @Author:estic
 * @Date: 2021/3/30 22:13
 */
public interface SmsHomeRecommendSubjectService {
    /**
     * 添加首页推荐
     * @param recommendSubjectList
     * @return
     */
    @Transactional
    int create(List<SmsHomeRecommendSubject> recommendSubjectList);


    /**
     * 修改推荐排序
     */
    int updateSort(Long id, Integer sort);

    /**
     * 批量删除推荐
     */
    int delete(List<Long> ids);

    /**
     * 更新推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询推荐
     */
    List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
