package com.zk.demo.dubboprovider.dataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * aop
 * @author zhoukun
 */
@Order(1)
@Aspect
@Component
public class DataSourceHandlerAop {

    @Pointcut("@within(com.zk.demo.dubboprovider.dataSource.DynamicSwitchDB) || @annotation(com.zk.demo.dubboprovider.dataSource.DynamicSwitchDB)")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        DynamicSwitchDB dynamicSwitchDB = method.getAnnotation(DynamicSwitchDB.class);
        if(dynamicSwitchDB == null){
            dynamicSwitchDB =  joinPoint.getTarget().getClass().getAnnotation(DynamicSwitchDB.class);
            if(dynamicSwitchDB == null){
                return;
            }
        }
        String dbName = dynamicSwitchDB.db();
        if(dbName != null && !"".equals(dbName)){
            DataSourceHandler.setDataSource(dbName);
        }
    }

    @After("pointCut()")
    public void after(){
        DataSourceHandler.clearDataSource();
    }

    @Around("execution(public * com.zk.demo.dubboprovider.impl.*.*(..))")
    public void test(){

    }
}
