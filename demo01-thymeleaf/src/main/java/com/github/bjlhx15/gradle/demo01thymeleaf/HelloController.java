package com.github.bjlhx15.gradle.demo01thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihongxu
 * @since 2019/1/10 上午11:05
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "resultPage";
    }
}
