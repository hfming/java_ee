package com.hfm.first;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-12 21:39
 * @Description
 * @date 2021/10/12
 */
public class LoadXmlTest {
    /**
     * Spring 配置文件的类路径加载
     */
    @Test
    public void classPathXmlApplicationContext(){
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("firstspring.xml");

        //2 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    /**
     * Spring 配置文件的绝对路径
     */
    @Test
    public void fileSystemXmlApplicationContext() {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\Code\\java_ee\\spring\\src\\firstSpring.xml");
        //2 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
