package com.hfm.mybatis.sqlsession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 10:16
 * @Description mybatis 与数据库交互的核心类对象
 * 可以创建 dao 接口的代理类对象
 * @date 2020/10/22
 */
public interface MySqlSessionFactory {
    /**
     * 用于创建session 对象
     * @return
     */
    MySqlSession openSession();
}
