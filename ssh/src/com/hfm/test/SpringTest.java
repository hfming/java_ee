package com.hfm.test;

import com.hfm.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-15 12:18
 * @Description
 * @date 2021/10/15
 */
@RunWith(SpringJUnit4ClassRunner.class) // 指定使用测试框架的版本
@ContextConfiguration(value = "classpath:applicationContext.xml") // 指定加载配置文件
public class SpringTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Department departMent = context.getBean("department", Department.class);
        System.out.println(departMent);
    }
}
