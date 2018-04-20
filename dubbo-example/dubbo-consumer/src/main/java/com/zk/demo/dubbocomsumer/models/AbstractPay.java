package com.zk.demo.dubbocomsumer.models;

public abstract class AbstractPay implements Pay {

    String execute() {
        if (checkParam()) {
            proccessPay();
        } else {
            return "参数效验失败";
        }
        return "嗯哼";
    }

    abstract void  proccessPay();
}
