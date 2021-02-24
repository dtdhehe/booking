package com.dtdhehe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/24 15:46
 * @description
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
