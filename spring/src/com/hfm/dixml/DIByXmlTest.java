package com.hfm.dixml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 20:18
 * @Description 属性注入方式
 * @date 2020/10/1
 */
public class DIByXmlTest {
    /**
     * set 方式注入属性
     */
    @Test
    public void setTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        DIBookBySet book = context.getBean("diBookBySet", DIBookBySet.class);
        System.out.println(book);
    }

    /**
     * 有参构造函数方式注入属性值
     */
    @Test
    public void constructorTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        DIBookByConstructor book = context.getBean("diBookByConstructor", DIBookByConstructor.class);
        System.out.println(book);
    }

    /**
     * p 名称空间方式注入
     */
    @Test
    public void pTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        DIBookByP book = context.getBean("diBookByP", DIBookByP.class);
        System.out.println(book);
    }
}
