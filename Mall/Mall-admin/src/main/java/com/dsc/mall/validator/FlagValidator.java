package com.dsc.mall.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 用户验证状态是否在指定范围内的注解
 * @Author:estic
 * @Date: 2021/3/6 19:53
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    String[] value() default {};
    String message() default "flag is not found";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
