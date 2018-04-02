package com.zk.demo.dubbocomsumer.invock;

import com.zk.demo.dubboapi.api.UserService;
import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DubboTest {
    @Autowired
    private UserService userService;

    public void getUsers() {
        UserParamInfo paramInfo = new UserParamInfo();
        paramInfo.setPage(1);
        paramInfo.setRows(2);
        List<UserInfo> list = userService.getAll(paramInfo);
        System.out.println("-------");
    }
}
