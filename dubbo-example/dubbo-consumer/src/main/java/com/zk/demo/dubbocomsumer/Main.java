package com.zk.demo.dubbocomsumer;

import com.zk.demo.dubbocomsumer.area.AreaApi;
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
        AreaApi areaApi =   ac.getBean("areaApi", AreaApi.class);
        areaApi.aa(null);
        System.out.println("-------------");
        ac.start();
        System.in.read();
    }
}
