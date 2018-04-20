package com.zk.demo.dubbocomsumer.models.observer;

public abstract class Observer {
    Subject subject;

    abstract void update(int satet);
}
