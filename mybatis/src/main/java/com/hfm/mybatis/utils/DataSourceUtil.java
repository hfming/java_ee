package com.hfm.mybatis.utils;

import com.hfm.mybatis.config.MyConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 11:23
 * @Description
 * @date 2020/10/22
 */
public class DataSourceUtil {
    /**
     * 创建数据库连接
     *
     * @param configuration
     * @return
     */
    public static Connection getConnection(MyConfiguration configuration) {
        Connection connection = null;
        try {
            String dirver = configuration.getDirver();
            String url = configuration.getUrl();
            String username = configuration.getUsername();
            String password = configuration.getPassword();

            // 注册数据库驱动
            Class.forName(dirver);
            // 获取数据库连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        } finally {
            return connection;
        }
    }
}
