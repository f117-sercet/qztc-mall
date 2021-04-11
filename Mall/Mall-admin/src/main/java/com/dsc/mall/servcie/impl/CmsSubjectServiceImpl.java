package com.dsc.mall.servcie.impl;

import com.dsc.mall.mapper.CmsSubjectMapper;
import com.dsc.mall.model.CmsSubject;
import com.dsc.mall.model.CmsSubjectExample;
import com.dsc.mall.servcie.CmsSubjectService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品管理Service实现类
 * @Author:estic
 * @Date: 2021/4/10 22:07
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {

    @Autowired

    private CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
       CmsSubjectExample example = new CmsSubjectExample();
       CmsSubjectExample.Criteria criteria = example.createCriteria();
       if (!StringUtils.isEmpty(keyword)) {
           criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }
}
