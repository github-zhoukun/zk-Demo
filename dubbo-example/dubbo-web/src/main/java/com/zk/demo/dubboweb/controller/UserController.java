package com.zk.demo.dubboweb.controller;

import com.zk.demo.dubboapi.api.UserService;
import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import com.zk.demo.dubboweb.entity.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 控制器
 *
 * @author zhoukun
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "")
    public String getForm() {
        return "user/user";
    }

    @RequestMapping(value = "get/data")
    @ResponseBody
    public ResultBean<List<UserInfo>> getAll(String search, String order, int offset, int limit) {
        UserParamInfo paramInfo = new UserParamInfo();
        paramInfo.setPage(offset / limit + 1);
        paramInfo.setRows(limit);
        List<UserInfo> list = userService.getAll(paramInfo);
        return new ResultBean<>(list, list.size());
    }
}
