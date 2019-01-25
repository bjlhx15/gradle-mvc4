package com.github.bjlhx15.gradle.jsr303;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 上午11:22
 */
@RestController
@Validated
public class ValidateController {
    @RequestMapping(value = "/testM", method = RequestMethod.GET)
    public String paramCheck(@Length(min = 10,max = 12,message = "最小长度为10") @RequestParam String name) {
        System.out.println(name);
        return null;
    }
    @RequestMapping(value = "/testE", method = RequestMethod.GET)
    public ResponseEntity testE(@Length(min = 10,max = 12,message = "最小长度为10") @RequestParam String name) {
        System.out.println(name);
        int a=1/0;
        return ResponseEntity.ok("ok");
    }
}
