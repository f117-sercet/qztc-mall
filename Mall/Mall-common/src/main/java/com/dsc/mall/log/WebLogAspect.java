package com.dsc.mall.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 60221
 * 统一日志处理切面
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.dsc.mall.controller.*.*(..))||execution(public * com.dsc.mall.*.controller.*.*(..))")
    public void weblog() {
    }

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }

    @AfterReturning(value = "weblog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
    }


}
