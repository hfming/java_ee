package com.hfm.aopann;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 15:39
 * @Description 代理类对象
 * @date 2020/9/29
 */
@Component(value = "helloProxy")
@Aspect // 生成代理类
@Order(value = 1)
public class HelloProxy {
    /**
     * 前置通知
     *
     * @Before 表示前置通知, 切入点表达式表示对具体的类的方法进行增强
     */
    @Before(value = "execution(* com.hfm.aopann.HelloImpl.say(..))")
    public void before() {
        System.out.println("Before 前置通知");
    }

    /**
     * 后置通知
     *
     * @AfterReturning 表示后置通知
     */
    @AfterReturning(value = "execution(* com.hfm.aopann.HelloImpl.say(..))")
    public void afterReturning() {
        System.out.println("AfterRunning 后置通知");
    }

    /**
     * 最终通知
     *
     * @After 表示最终通知
     */
    @After(value = "execution(* com.hfm.aopann.HelloImpl.say(..))")
    public void after() {
        System.out.println("After 后置通知");
    }

    /**
     * 异常通知
     *
     * @AfterThrowing 表示异常通知
     */
    @AfterThrowing(value = "execution(* com.hfm.aopann.HelloImpl.say(..))")
    public void afterThrowing() {
        System.out.println("AfterThrowing 异常通知 ");
    }

    /**
     * 环绕通知
     *
     * @Around 表示环绕通知
     */
    @Around(value = "common()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前");
        // 被增强的方法执行
        // 环绕通知将前置与后置通知结合起来
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知后");
    }

    /**
     * 公共切入点抽取
     * 将切入点表达式相同的提取出来
     */
    @Pointcut(value = "execution(* com.hfm.aopann.HelloImpl.say(..))")
    public void common(){

    }
}
