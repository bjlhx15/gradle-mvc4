package com.github.bjlhx15.gradle.jsr303;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.groups.Default;

/**
 * @author lihongxu
 * @since 2019/1/10 上午11:05
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("message","Hello from server");
        return "resultPage";
    }
    @RequestMapping("/data")
    public String testDataValid(@Valid @RequestBody Order order){
        System.out.println(order);
        return "resultPage";
    }

    @RequestMapping("/person")
    public String person(
           @Valid @RequestBody Person person){
        System.out.println(person.toString());
        return "resultPage";
    }


    /**
     * 添加一个Person对象
     * 此处启用PersonAddView 这个验证规则
     * 备注：此处@Validated(PersonAddView.class) 表示使用PersonAndView这套校验规则，若使用@Valid 则表示使用默认校验规则，
     * 若两个规则同时加上去，则只有第一套起作用
     */
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void addPerson(@RequestBody @Validated({PersonAddView.class, Default.class}) Person person) {
        System.out.println(person.toString());
    }

    /**
     * 修改Person对象
     * 此处启用PersonModifyView 这个验证规则
     */
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public void modifyPerson(@RequestBody @Validated(value = {PersonModifyView.class}) Person person) {
        System.out.println(person.toString());
    }
}
