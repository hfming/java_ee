package com.hfm.dixml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 16:49
 * @Description 自动装配, 自动依赖注入
 * @date 2020/9/28
 */
public class DIAutoTest {
    /**
     * 通过属性名自动依赖注入
     */
    @Test
    public void byNameTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
        System.out.println(emp.getDept());
    }

    /**
     * 通过属性类型自动依赖注入
     */
    @Test
    public void byTypeTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
        System.out.println(emp.getDept());
    }
}
