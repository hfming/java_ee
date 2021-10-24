package com.hfm.first;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-12 20:49
 * @Description
 * @date 2021/10/12
 */
public class SpringFirstTest {
    @Test
    public void test(){
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("firstspring.xml");

        //2 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
