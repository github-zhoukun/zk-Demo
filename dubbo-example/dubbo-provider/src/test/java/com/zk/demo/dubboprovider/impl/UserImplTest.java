package com.zk.demo.dubboprovider.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zk.demo.dubboapi.entity.UserInfo;
import com.zk.demo.dubboapi.param.UserParamInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class UserImplTest {
    @Autowired
    private UserImpl service;

    @Test
    public void create() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("ss");
        userInfo.setPassword("mima");
        userInfo.setSalt("12313");
        userInfo.setState(0);
        userInfo.setNote("创建");
        try {
            service.create(userInfo);
            System.out.println("------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteById() {
        try {
            service.deleteById(2L);
            System.out.println("---");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3);
        userInfo.setName("jj");
        userInfo.setPassword("mima");
        userInfo.setSalt("12313");
        userInfo.setState(0);
        userInfo.setNote("update");
        try {
            service.update(userInfo);
            System.out.println("------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() throws Exception {
        try {
            UserParamInfo info = new UserParamInfo();
            info.setPage(1);
            info.setRows(2);
            List<UserInfo> list = service.getAll(info);
            System.out.println("是谁送你来到我身边！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}