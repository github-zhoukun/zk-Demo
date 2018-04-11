package com.zk.demo.dubboprovider.dataSource;

import java.lang.annotation.*;

/**
 * 动态切换-注解
 * @author zhoukun
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSwitchDB {
    String db() default "";
}
