package com.hfm.mybatis.defaults;

import com.hfm.mybatis.config.MyConfiguration;
import com.hfm.mybatis.sqlsession.MySqlSession;
import com.hfm.mybatis.sqlsession.MySqlSessionFactory;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 11:01
 * @Description
 * @date 2020/10/22
 */
public class DefaultMySqlSessionFactory implements MySqlSessionFactory {
    private MyConfiguration myConfiguration;

    public DefaultMySqlSessionFactory(MyConfiguration configuration) {
        this.myConfiguration = configuration;
    }

    /**
     * 创建一个数据库连接操作对象
     * @return
     */
    @Override
    public MySqlSession openSession() {
        // 返回一个默认的 MySqlSession
        return new DefaultMySqlSession(myConfiguration);
    }
}
