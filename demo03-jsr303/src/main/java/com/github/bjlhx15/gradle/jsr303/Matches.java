package com.github.bjlhx15.gradle.jsr303;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 上午9:49
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchesValidator.class)
@Documented
public @interface Matches {
    String message() default "{constraint.not.matches}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
    String verifyField();
}
