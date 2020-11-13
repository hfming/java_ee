package com.hfm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 10:19
 * @Description 开发环境测试
 * @date 2020/10/27
 */
public class BeginTest {
    @Test
    public void beginTest() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = context.getBean("dataSource", DataSource.class);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
