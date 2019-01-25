package com.github.bjlhx15.gradle.jsr303;

import com.github.bjlhx15.gradle.jsr303.validator.IDValidator;
import com.github.bjlhx15.gradle.jsr303.validator.ListNotHasNull;
import com.github.bjlhx15.gradle.jsr303.validator.Matches;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 上午9:25
 */
@Data
@Matches(field = "password", verifyField = "confirmPassword",
        message = "{constraint.confirmNewPassword.not.match.newPassword}")
public class Person {
    @IDValidator(message = "身份证需要15或18位")
    private String id;
    private String password;
    private String confirmPassword;
    /**
     * 添加groups 属性，说明只在特定的验证规则里面起作用，不加则表示在使用Deafault规则时起作用
     */

    @NotNull(groups = {PersonAddView.class, PersonModifyView.class}, message = "添加、修改用户时名字不能为空"
    )//,payload = ValidateErrorLevel.Info.class)
    @ListNotHasNull.List({
            @ListNotHasNull(groups = {PersonAddView.class}, message = "添加上Name不能为空"),
            @ListNotHasNull(groups = {PersonModifyView.class}, message = "修改时Name不能为空")})
    private String name;

    @NotNull(groups = {PersonAddView.class}, message = "添加用户时地址不能为空")
    private String address;

    @Min(value = 18, groups = {PersonAddView.class}, message = "年龄不能低于18岁")
    @Max(value = 30, groups = {PersonModifyView.class}, message = "年龄不能超过30岁")
    private int age;
}
