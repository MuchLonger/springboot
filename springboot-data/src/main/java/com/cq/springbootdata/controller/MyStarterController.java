package com.cq.springbootdata.controller;

import com.cqy.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Time: 2019/3/21 14:25
 */
@RestController
public class MyStarterController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHello("hah");
    }

}
