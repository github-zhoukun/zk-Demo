package com.zk.demo.dubbocomsumer.models.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new ThiefObserver(subject);
        new PoliceObserver(subject);
        subject.setSatet(123456789);
    }
}
