package com.zk.demo.dubboweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("")
    public String getForm(){
        return "hello";
    }
}
