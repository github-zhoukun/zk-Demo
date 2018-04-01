package com.zk.demo.dubbocomsumer.invock;

import com.zk.demo.dubboapi.api.UserService;
import com.zk.demo.dubboapi.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DubboTest {
    @Autowired
    private UserService userService;

    public void getUsers() {
        List<UserInfo> list = userService.getAll(null);
        System.out.println("-------");
    }
}
