package com.ydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ligeng on 17/1/15.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("index")
    public String index(){
        return "这是测试主页";
    }
}
