package com.zk.demo.dubboweb.aop;

import com.zk.demo.dubboweb.entity.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 控制层切面 基于CGlib
 * 注意: 开启配置必须配置在mvc上下文中
 *
 * @author zhoukun
 */
@Aspect
@Component
public class ControllerAop {
    public static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    /**
     * 配置切点
     */
    @Pointcut(value = "execution(public com.zk.demo.dubboweb.entity.ResultBean com.zk.demo.dubboweb.controller..*.*(..))")
    public void pointcut(){
    }

    @Around(value = "pointcut()")
    public Object handleController(ProceedingJoinPoint pjp){
        ResultBean<?> result;
        try {
            result = (ResultBean<?>)pjp.proceed();
        } catch (Throwable throwable) {
            result =  handleException(pjp, throwable);
        }
        return result;
    }
    public ResultBean<?> handleException(ProceedingJoinPoint pjp, Throwable e){
        if(e instanceof NullPointerException){
            e.printStackTrace();
        }
        Object[] logInfo = {pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), e.getMessage()};
        logger.error("控制器异常 - 类:{} - 方法:{} - errMsg:{}", logInfo);
        return new ResultBean<String>(e);
    }
}
