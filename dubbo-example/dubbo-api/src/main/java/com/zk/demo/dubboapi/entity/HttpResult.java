package com.zk.demo.dubboapi.entity;

import java.io.Serializable;

public class HttpResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer statusCode;

    private String body;

    public HttpResult() {

    }

    public HttpResult(Integer statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }


    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "statusCode=" + statusCode +
                ", body='" + body + '\'' +
                '}';
    }
}
