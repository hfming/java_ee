package com.hfm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-19 17:02
 * @Description
 * @date 2020/9/19
 */
public class HibernateUtilsFinal {
    /**
     * 配置文件对象
     */
    private static final Configuration configuration;
    /**
     * session 静态工厂
     */
    private static final SessionFactory sessionFactory;

    static {
        // 创建配置文件对象,自动寻找 src 目录下的 hibernate.cfg.xml 文件
        // 也可以指定加载特定目录下的配置文件
        configuration = new Configuration();
        // 自动加载配置文件
        configuration.configure();

        // 第二步 创建 SessionFactory 对象
        // 在过程中，加载配置文件中的依赖配置文件,根据映射关系，在配置数据库里面把表创建
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     * 返回与本地线程绑定的session
     * 不需要手动关闭,会自动关闭
     *
     * @return
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
