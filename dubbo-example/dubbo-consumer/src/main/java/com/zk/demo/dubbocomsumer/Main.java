package com.zk.demo.dubbocomsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动入口
 * @author zhoukun
 */
public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)throws Exception{
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        logger.info("dubbo-consumer 消费端启动成功!");
        ac.start();
        System.in.read();
    }
}
