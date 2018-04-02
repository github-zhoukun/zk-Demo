package com.zk.demo.dubboapi.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 自定义序列化规则 也可以写成内部类
 */
public class UserStateSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        String text = "";
        Integer state = (Integer) o;
        if (state == 1) {
            text = "正常";
        } else {
            text = "停用";
        }
        jsonSerializer.write(text);
    }
}
