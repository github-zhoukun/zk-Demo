package com.zk.demo.dubboprovider.dataSource;

/**
 * 动态数据源
 * @author zhoukun
 */
public class DataSourceHandler {
    private static ThreadLocal<String> ThreadLocalHandler = new ThreadLocal<>();

    public static void setDataSource(String dataSourceName){
        ThreadLocalHandler.set(dataSourceName);
    }

    public static String getDataSource(){
        return ThreadLocalHandler.get();
    }

    public static void clearDataSource(){
        ThreadLocalHandler.remove();
    }
}
