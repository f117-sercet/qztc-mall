package com.dsc.mall.servcie;

import com.dsc.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员尊享管理Service
 * @Author:estic
 * @Date: 2021/4/5 21:58
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员登录
     * @param defaultStatus
     * @return
     */
    List<UmsMemberLevel> list(Integer defaultStatus);

}

