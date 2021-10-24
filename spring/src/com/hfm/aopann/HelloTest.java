package com.hfm.aopann;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 16:19
 * @Description
 * @date 2020/9/29
 */
public class HelloTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aopAnno.xml");

        Hello helloImpl = context.getBean("helloImpl", Hello.class);

        helloImpl.say();
    }

    /**
     * 完全注解式开发实现 aop 操作
     */
    @Test
    public void annotationTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Hello helloImpl = context.getBean("helloImpl", Hello.class);

        helloImpl.say();
    }
}
