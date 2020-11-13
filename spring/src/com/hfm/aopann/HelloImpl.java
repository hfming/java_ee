package com.hfm.aopann;

import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 15:38
 * @Description 被代理类
 * 可以被增强的方法称为 连接点
 *
 * @date 2020/9/29
 */
@Component(value = "helloImpl")
public class HelloImpl implements Hello{
    /**
     * 实际被增强的方法称为 切入点
     */
    @Override
    public void say(){
        System.out.println("hello world!");
    }
}
