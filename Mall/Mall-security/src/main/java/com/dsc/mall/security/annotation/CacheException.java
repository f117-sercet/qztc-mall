package com.dsc.mall.security.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author 60221
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
