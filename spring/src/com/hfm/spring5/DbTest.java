package com.hfm.spring5;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 17:14
 * @Description
 * @date 2020/9/28
 */
public class DbTest {
    /**
     * 获取数据库连接
     *
     * @throws SQLException
     */
    @Test
    public void getConnection() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);

        System.out.println(dataSource.getConnection());
    }
}
