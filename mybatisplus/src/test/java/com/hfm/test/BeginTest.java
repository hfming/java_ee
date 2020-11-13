package com.hfm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 19:44
 * @Description
 * @date 2020/10/28
 */
public class BeginTest {
    /**
     * 环境测试
     * @throws SQLException
     */
    @Test
    public void begainTest() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = context.getBean("dataSource", DataSource.class);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
