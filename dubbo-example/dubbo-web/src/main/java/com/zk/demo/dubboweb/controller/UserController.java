package com.zk.demo.dubboweb.controller;

import com.zk.demo.dubboapi.api.UserService;
import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{page}/{pageSize}")
    public List<UserInfo> getAll(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize){
        UserParamInfo paramInfo = new UserParamInfo();
        if(page == null || pageSize == null){
            paramInfo.setPage(0);
            paramInfo.setRows(10);
        }else {
            paramInfo.setPage(page);
            paramInfo.setRows(pageSize);
        }
        return userService.getAll(paramInfo);
    }
}
