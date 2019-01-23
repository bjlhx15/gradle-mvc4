package com.github.bjlhx15.gradle.jsr303;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 上午9:18
 */
@Documented
@Constraint(validatedBy = { IDConstraintValidator.class })
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IDValidator {
    //允许为空的属性
    boolean required() default true;
    //如果校验不通过返回的提示信息
    String message() default "{id}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
