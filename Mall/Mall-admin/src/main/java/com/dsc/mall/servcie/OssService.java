package com.dsc.mall.servcie;

import com.dsc.mall.dto.OssCallbackResult;
import com.dsc.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Service
 * @Author:estic
 * @Date: 2021/4/17 17:57
 */
public interface OssService {
    /**
     * oss上传策略生成
     * @return
     */
    OssPolicyResult policy();
    /**
     * oss上传成功回调
     * @param request
     * @return
     */
    OssCallbackResult callback(HttpServletRequest request);
}

