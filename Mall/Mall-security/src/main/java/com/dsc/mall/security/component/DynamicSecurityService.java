package com.dsc.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author 60221
 * 动态权限相关业务
 */
public interface DynamicSecurityService {

    Map<String, ConfigAttribute> loadDataSource();
}
