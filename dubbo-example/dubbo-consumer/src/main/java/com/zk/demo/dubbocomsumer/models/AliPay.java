package com.zk.demo.dubbocomsumer.models;

public class AliPay extends AbstractPay {
    @Override
    void proccessPay() {
        System.out.println("支付成功");
    }

    @Override
    public Boolean checkParam() {
        System.out.println("效验参数");
        return true;
    }
}
