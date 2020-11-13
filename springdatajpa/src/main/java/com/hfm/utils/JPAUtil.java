package com.hfm.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-09 19:52
 * @Description
 * @date 2020/10/9
 */
public  final  class JPAUtil {
    /**
     * JPA 的实体管理器工厂：相当于 Hibernate 的 SessionFactory
     */
    private static EntityManagerFactory entityManagerFactory;

    /**
     * 使用静态代码块赋值
     */
    static {
        // 注意：该方法参数必须和persistence.xml中persistence-unit标签name属性取值一致
        entityManagerFactory = Persistence.createEntityManagerFactory("myjpa");
    }

    /**
     * 使用管理器工厂生产一个管理器对象
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
