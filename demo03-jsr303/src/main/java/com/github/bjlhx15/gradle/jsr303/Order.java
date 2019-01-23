package com.github.bjlhx15.gradle.jsr303;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/22 下午2:44
 */
@Data  //lombok 注解
public class Order {
    // 必须不为 null, 大小是 10
    @NotNull(message = "不能为空")
    @Size(min = 10, max = 10)
    private String orderId;
    // 必须不为空
    @NotEmpty(message = "不能为空")
    private String customer;
    // 必须是一个电子信箱地址
    @NotNull(message = "邮箱不为空")
    @Email(message = "邮件格式不对")
    private String email;
    // 必须不为空
    @NotEmpty(message = "不能为空")
    private String address;
    // 必须不为 null, 必须是下面四个字符串'created', 'paid', 'shipped', 'closed'其中之一
    // @Status 是一个定制化的 contraint
//    @NotNull
//    @Status
//    private String status;
//    // 必须不为 null
//    @NotNull
//    private Date createDate;
//    // 嵌套验证
//    @Valid
//    private Product product;
}

