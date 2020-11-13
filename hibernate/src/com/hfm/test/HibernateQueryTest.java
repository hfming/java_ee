package com.hfm.test;

import com.hfm.entity.Contact;
import com.hfm.entity.Customer;
import com.hfm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 20:11
 * @Description Hibernate 数据查询
 * @date 2020/9/20
 */
public class HibernateQueryTest {
    /**
     * 对象导航查询
     */
    @Test
    public void objectQuery() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 查询指定 ID 的用户
            Customer customer = session.get(Customer.class, new Integer(1));

            // 直接获取 customer 中的 set 数据
            Set<Contact> contacts = customer.getContacts();

            // 打印输出 set 集合数据
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
     * 根据 id 查询数据
     */
    @Test
    public void oid(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 查询指定 ID 的用户
            Customer customer = session.get(Customer.class, new Integer(1));

            System.out.println(customer);

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
