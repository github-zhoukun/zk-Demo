package com.zk.demo.dubboapi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zk.demo.dubboapi.serializer.UserStateSerializer;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * user信息实体类
 */
@Alias("User")
public class UserInfo implements Serializable {

    private Integer id;

    private String name;

    private String password;

    @JSONField(serializeUsing = UserStateSerializer.class)
    private Integer state;

    private String salt;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
