package com.hfm.test;

import com.hfm.entity.Customer;
import com.hfm.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 21:42
 * @Description
 * @date 2020/9/20
 */
public class QBCTest {
    /**
     * 查询所有数据
     */
    @Test
    public void queryAll(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 Criteria 对象
            Criteria criteria = session.createCriteria(Customer.class);

            // 调用 list 方法查询所有数据
            List<Customer> list = criteria.list();

            for (Customer customer : list) {
                System.out.println(customer);
            }

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 条件查询
     */
    @Test
    public void where(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 Criteria 对象
            Criteria criteria = session.createCriteria(Customer.class);

            // 使用方法设置查询条件
            // add 方法表示设置条件值
            // Restrictions 条件对象有很多静态方法用于添加参数及参数值
            criteria.add(Restrictions.eq("cust_id", 1));

//            Restrictions.eq() 等于
//            Restrictions.gt 大于
//            Restrictions.lt() 小于

            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 模糊查询
     */
    @Test
    public void like(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 Criteria 对象
            Criteria criteria = session.createCriteria(Customer.class);

            // 使用方法设置查询条件
            // add 方法表示设置条件值
            // Restrictions 条件对象有很多静态方法用于添加参数及参数值
            criteria.add(Restrictions.like("cust_name", "%百%"));

            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 排序查询
     */
    @Test
    public void order(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 Criteria 对象
            Criteria criteria = session.createCriteria(Customer.class);

            // 使用方法设置查询条件
            // addOrder 方法表示设置排序查询
            criteria.addOrder(Order.desc("cust_name"));

            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 分页查询查询
     */
    @Test
    public void limit(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 Criteria 对象
            Criteria criteria = session.createCriteria(Customer.class);

            // 使用方法设置查询条件

            // 设置分页查询
            // 设置起始记录数
            criteria.setFirstResult(0);
            // 设置每页记录数
            criteria.setMaxResults(3);

            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 统计查询
     */
    @Test
    public void count(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 Criteria 对象
            Criteria criteria = session.createCriteria(Customer.class);

            // 使用 setProjection 设置统计查询方法
            // Projections 类有很多统计方法
            criteria.setProjection(Projections.rowCount());

            Long aLong = (Long) criteria.uniqueResult();
            System.out.println(aLong.intValue());

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 离线查询
     */
    @Test
    public void offLine(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();
            // 创建 DetachedCriteria 对象
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

            Criteria criteria = detachedCriteria.getExecutableCriteria(session);
            criteria.add(Restrictions.eq("cust_id", 1));

            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer);
            }

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
