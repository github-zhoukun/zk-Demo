package com.zk.demo.dubbocomsumer.models.observer;

public class PoliceObserver extends Observer{
    public PoliceObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    void update(int satet) {
        System.out.println("发现小偷--------"+satet);
    }
}
