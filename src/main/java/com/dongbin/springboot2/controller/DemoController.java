package com.dongbin.springboot2.controller;

import com.dongbin.springboot2.Demo;
import com.dongbin.springboot2.annotation.F2cMethodParamter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping
    public void test(@F2cMethodParamter Demo demo) {
        System.err.println(demo.getId());
    }
}
