package com.zk.demo.dubbocomsumer.models;

public class Test {

    public static void main(String[] args) {
        AbstractPay a = new AliPay();
        a.execute();
    }
}
