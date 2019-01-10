package com.github.bjlhx15.gradle.gradlemvc4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihongxu
 * @since 2019/1/10 上午11:05
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public Object test(){
        return "test";
    }
}
