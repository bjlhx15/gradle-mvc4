package com.github.bjlhx15.gradle.jsr303;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 上午9:19
 */
public class IDConstraintValidator implements ConstraintValidator<IDValidator, String> {
    //默认值_false，用于接收注解上自定义的 required
    private boolean required = false;
    //1、初始化方法：通过该方法我们可以拿到我们的注解
    @Override
    public void initialize(IDValidator idValidator) {
        //idValidator.required() 接收我们自定义的属性，是否为空
        required = idValidator.required();
    }
    //2、逻辑处理
    @Override
    public boolean isValid(String id, ConstraintValidatorContext ctx) {
        //2.1、如果允许为空的话，直接返回结果
        if(required){
            if(StringUtils.isBlank(id)){
                return false;
            }
            int length = id.length();
            if (NumberUtils.isDigits(id) && (length == 15 || length == 18)) {
                return true;
            }
            return false;
        }else{
            if(StringUtils.isBlank(id)){
                return true;
            }else{
                int length = id.length();
                if (NumberUtils.isDigits(id) && (length == 15 || length == 18)) {
                    return true;
                }
                return false;
            }
        }
    }
}
