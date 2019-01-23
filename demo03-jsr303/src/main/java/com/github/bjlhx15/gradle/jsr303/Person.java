package com.github.bjlhx15.gradle.jsr303;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 上午9:25
 */
@Matches(field = "password", verifyField = "confirmPassword",
        message = "{constraint.confirmNewPassword.not.match.newPassword}")
public class Person {
    @IDValidator(message = "身份证需要15或18位")
    private String id;
    private String password;
    private String confirmPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
