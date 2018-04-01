package com.zk.demo.dubboprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 程序入口
 *
 * @author zhoukun
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        logger.info("dubbo-provider 服务提供者 应用启动成功！");
        context.start();
        System.in.read();

    }
}
