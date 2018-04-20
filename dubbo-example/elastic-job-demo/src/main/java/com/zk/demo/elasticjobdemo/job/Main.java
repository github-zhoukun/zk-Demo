package com.zk.demo.elasticjobdemo.job;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        ac.start();
        System.in.read();
    }
}
