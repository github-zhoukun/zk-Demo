package com.zk.demo.dubboweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ftl")
public class FtlController {

    @RequestMapping(value = "")
    public String getForm(){
        return "well";
    }

    @RequestMapping(value = "say")
    @ResponseBody
    public String say(){
        return "sun碍难";
    }
}
