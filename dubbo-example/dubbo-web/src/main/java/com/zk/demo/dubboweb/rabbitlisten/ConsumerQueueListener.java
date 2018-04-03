package com.zk.demo.dubboweb.rabbitlisten;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * Rabbit消费端监听
 * @author zhoukun
 */
public class ConsumerQueueListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Rabbit消息:"+new String(message.getBody(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
