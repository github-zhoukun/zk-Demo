package com.zk.demo.rabbitproducer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消息发送测试类
 */
public class ProducerClient {

    public static void main(String[] args)throws Exception {
        ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:spring.xml");
        RabbitTemplate rabbitTemplate =   ac.getBean("rabbitTemplate", RabbitTemplate.class);
        //第二个参数为路由key(routingKey)的值，当路由可以为test321.hello.test123时，两个消费队列都可以收到消息，当值为test321.hello.aaa时，只有绑定了test321.#的队列才可以收到消息，当值为ta1.hello.test123，只有绑定了*.*.test123的队列才可收到消息
        rabbitTemplate.send("rabbit-mq-exchange", "123.321.queue1", new Message("你好".getBytes("UTF-8"), new MessageProperties()));
    }
}
