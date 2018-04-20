package com.zk.demo.dubbocomsumer.models.observer;

public class ThiefObserver extends Observer {

    public ThiefObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    void update(int satet) {
        System.out.println("警察来了？----" + satet);
    }
}
