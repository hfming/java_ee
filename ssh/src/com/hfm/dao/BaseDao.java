package com.hfm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-03 22:05
 * @Description
 * @date 2020/10/3
 */
@Repository
public abstract class BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取当前线程绑定的 session
     *
     * @return
     */
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> clazz = null;

    /**
     * 自动获取 clazz 对象
     * 子类继承后，获取的clazz 对象就是子类泛型父类的泛型参数类class 对象
     */ {
        // 获取当前类的泛型父类
        Type genericSuperclass = this.getClass().getGenericSuperclass();

        // 强制数据类型转化
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

        // 获取父类泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        // 获取泛型的第一个参数
        Type actualTypeArgument = actualTypeArguments[0];

        // 强制数据类型转化
        clazz = (Class<T>) actualTypeArgument;
    }

    private Query<T> gettQuery(Session session, String hql, Object[] args) {
        Query<T> query = session.createQuery(hql, clazz);

        // 参数设置
        if (args != null && args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
        return query;
    }

    /**
     * 查询单个对象
     *
     * @param session
     * @param hql
     * @param args
     * @return
     */
    public T querySingle(Session session, String hql, Object... args) {
        Query<T> query = gettQuery(session, hql, args);

        return query.list().get(0);
    }

    /**
     * 查询多个对象
     *
     * @param session
     * @param hql
     * @param args
     * @return
     */
    public List<T> queryList(Session session, String hql, Object... args) {
        Query<T> query = gettQuery(session, hql, args);

        List<T> list = query.list();
        return list;
    }

    /**
     * 更新数据（增、改）
     *
     * @param session
     * @param t
     */
    public void saveOrUpdate(Session session, T t) {
        session.saveOrUpdate(t);
    }

    /**
     * 删除数据
     *
     * @param session
     * @param t
     */
    public void delete(Session session, T t) {
        session.delete(t);
    }

    /**
     * 获取单个值
     *
     * @param session
     * @param hql
     * @param args
     * @return
     */
    public Object getValue(Session session, String hql, Object... args) {
        return null;
    }

    /**
     * 批量操作
     *
     * @param session
     * @param hql
     * @param batchArgs
     */
    public void banth(Session session, String hql, List<Object[]> batchArgs) {
        return;
    }
}
