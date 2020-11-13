package com.hfm.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-26 17:46
 * @Description 自定义插件
 * @date 2020/10/26
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "parameterize", args = Statement.class)
})// 通过注解配置拦截的对象及方法等参数
public class MyInterceptor implements Interceptor {
    /**
     * 拦截目标方法执行
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行后的返回值
        Object proceed = invocation.proceed();
        return proceed;
    }

    /**
     * 生成动态代理对象，可以使用MyBatis提供的Plugin类的wrap方法
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        // 借助 Plugin 的 wrap 方法创建代理类
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    /**
     * 注入插件配置时设置的属性
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {


    }
}
