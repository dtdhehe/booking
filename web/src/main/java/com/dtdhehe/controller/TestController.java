package com.dtdhehe.controller;

import com.dtdhehe.common.data.JsonResult;
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
    public JsonResult<String> hello(){
        return JsonResult.success("hello");
    }

}
