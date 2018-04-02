package com.zk.demo.dubboweb.entity;

/**
 * 统一响应信息类
 */
public class ResultInfo<T> {
    public static final Integer SUCCESS = 200;
    public static final Integer FAIL = 500;

    private Integer state = SUCCESS;
    private T rows;
    private Integer total;

    public ResultInfo(T rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public ResultInfo(Integer state, Exception e) {
        this.state = state;
        this.rows = (T)e.getMessage();
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
