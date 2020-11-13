package com.hfm.mybatis.defaults;

import com.hfm.mybatis.config.MyConfiguration;
import com.hfm.mybatis.sqlsession.MySqlSession;
import com.hfm.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 11:03
 * @Description
 * @date 2020/10/22
 */
public class DefaultMySqlSession implements MySqlSession {
    private MyConfiguration myConfiguration;

    private Connection connection;

    public DefaultMySqlSession(MyConfiguration configuration) {
        this.myConfiguration = configuration;
        connection = DataSourceUtil.getConnection(myConfiguration);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        // 创建代理类对象
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MyInvocationHandler(myConfiguration.getMappers(), connection));
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
