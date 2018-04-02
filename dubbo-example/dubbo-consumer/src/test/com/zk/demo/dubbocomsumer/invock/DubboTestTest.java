package com.zk.demo.dubbocomsumer.invock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class DubboTestTest {
    @Autowired
    private DubboTest dubboTest;
    @Test
    public void getUsers() throws Exception {
        dubboTest.getUsers();
        System.out.println("杨柳岸，晓风残月!");
    }

}