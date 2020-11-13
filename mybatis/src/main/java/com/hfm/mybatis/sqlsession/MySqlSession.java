package com.hfm.mybatis.sqlsession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 10:19
 * @Description
 * @date 2020/10/22
 */
public interface MySqlSession {
    /**
     * 根据参数创建代理类对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 关闭资源
     */
    void close();
}
