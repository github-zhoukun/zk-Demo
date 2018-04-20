package com.zk.demo.dubbocomsumer.models.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int satet;

    public int getSatet() {
        return satet;
    }

    public void setSatet(int satet) {
        this.satet = satet;
        notityAll();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notityAll(){
        for (Observer observer : observers) {
            observer.update(satet);
        }
    }
}
