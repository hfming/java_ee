package com.hfm.mybatis.sqlsession;

import com.hfm.mybatis.config.MyConfiguration;
import com.hfm.mybatis.defaults.DefaultMySqlSessionFactory;
import com.hfm.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 10:16
 * @Description 用于创建 SqlSessionFactory 对象
 * @date 2020/10/22
 */
public class MySqlSessionFactoryBuilder {
    /**
     * 创建 SqlSessionFactory 实现类对象
     *
     * @param config
     * @return
     */
    public MySqlSessionFactory bulider(InputStream config) {
        // 创建 MyConfiguration 存储配置文件中的信息
        MyConfiguration myConfiguration = XMLConfigBuilder.loadMyConfiguration(config);

        // 返回一个默认 MySqlSessionFactory
        return new DefaultMySqlSessionFactory(myConfiguration);
    }
}
