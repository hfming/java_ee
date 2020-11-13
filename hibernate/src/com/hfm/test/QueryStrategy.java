package com.hfm.test;

import com.hfm.entity.Contact;
import com.hfm.entity.Customer;
import com.hfm.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;


/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-21 11:51
 * @Description 查询策略
 * @date 2020/9/21
 */
public class QueryStrategy {
    /**
     * 延迟查询
     */
    @Test
    public void load(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 根据id查询返回实体类对象，调用load方法不会马上发送语句
            Customer load = session.load(Customer.class, 1);

            Integer cust_id = load.getCust_id();
            System.out.println(cust_id);

            // 查询id 之外的字段才会发送语句进行重新
            String cust_name = load.getCust_name();
            System.out.println(cust_name);

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
     * 关联级别查询
     */
    @Test
    public void linkLazyload(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 根据id查询返回实体类对象，调用load方法不会马上发送语句
            Customer load = session.load(Customer.class, 1);

            Integer cust_id = load.getCust_id();
            System.out.println(cust_id);

            // 查询id 之外的字段才会发送语句进行重新
            Set<Contact> contacts = load.getContacts();

            // 关联级别延迟查询,没有获取关联数据时不会发送sql 语句
            System.out.println("============================= 分界线 ===================================");

            // 获取关联数据时发送 sql 语句
            System.out.println(contacts.size());
            for (Contact contact : contacts) {
                System.out.println(contact);
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
     * 批量抓取
     */
    @Test
    public void batch(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(Customer.class);

            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer);
                Set<Contact> contacts = customer.getContacts();
                for (Contact contact : contacts) {
                    System.out.println(contact);
                }
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
