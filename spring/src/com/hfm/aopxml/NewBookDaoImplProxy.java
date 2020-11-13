package com.hfm.aopxml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:30
 * @Description
 * @date 2020/9/29
 */
public class NewBookDaoImplProxy {
    /**
     * 前置通知
     */
    public void before() {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    public void afterReturning() {
        System.out.println("后置通知");
    }

    /**
     * 最终通知
     */
    public void after() {
        System.out.println("后置通知");
    }

    /**
     * 异常通知
     */
    public void afterThrowing() {
        System.out.println("异常通知 ");
    }

    /**
     * 环绕通知
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前");
        // 被增强的方法执行
        // 环绕通知将前置与后置通知结合起来
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知后");
    }
}
