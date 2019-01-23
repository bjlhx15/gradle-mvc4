package com.github.bjlhx15.gradle.jsr303;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public String testDataValid(@Valid Order order){
        System.out.println(order);
        return "resultPage";
    }

    @RequestMapping("/person")
    public String person(
           @Valid @RequestBody Person person){
        System.out.println(person.toString());
        return "resultPage";
    }
}
