package com.dsc.mall.servcie;

import com.dsc.mall.model.CmsSubject;

import java.util.List;

/**
 * 商品专题管理Service
 * @Author:estic
 * @Date: 2021/3/8 22:11
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     * @return
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
}
