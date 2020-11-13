package com.hfm.mybatis.defaults;

import com.hfm.mybatis.config.MyMapper;
import com.hfm.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 11:11
 * @Description
 * @date 2020/10/22
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * key 是全限定类名 + 方法名
     */
    private Map<String, MyMapper> mappers;

    private Connection connection;

    public MyInvocationHandler(Map<String, MyMapper> mappers, Connection connection) {
        this.connection = connection;
        this.mappers = mappers;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1.获取方法名
        String name = method.getName();

        // 2.获取方法所在的名称
        String className = method.getDeclaringClass().getName();

        // 3.拼接组合
        String key = className + "." + name;

        // 4.获取对应的值
        MyMapper myMapper = mappers.get(key);

        // 5.判断mapper是否为空
        if (myMapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        // 6.调用工具类查询所有

        return new Executor().selectList(myMapper, connection);
    }
}
