package com.it.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author Lyle
 * @date 2021/4/19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String showHello(){
        return "Hello World!";
    }
}
