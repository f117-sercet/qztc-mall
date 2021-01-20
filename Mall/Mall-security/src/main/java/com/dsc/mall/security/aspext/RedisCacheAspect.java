package com.dsc.mall.security.aspext;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Redis缓存切面，防止Redis宕机影响正常业务
 * @author 60221
 */
@Aspect
@Component
@Order(2)
public class RedisCacheAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Pointcut("execution(public * com.dsc.mall.portal.service.*CacheService.*(..)) || execution(public * com.dsc.mall.service.*CacheService.*(..))")
    public void cacheAspect() {
    }

}
