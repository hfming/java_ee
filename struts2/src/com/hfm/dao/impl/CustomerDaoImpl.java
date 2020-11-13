package com.hfm.dao.impl;

import com.hfm.dao.CustomerDao;
import com.hfm.pojo.Customer;
import com.hfm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 20:37
 * @Description CustomerDao 接口实现类
 * @date 2020/9/22
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<Customer> customers = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();

            // HQL 查询
            Query query = session.createQuery("from Customer ");

            customers = query.list();

            // 提交
            transaction.commit();
        } catch (Exception e) {
            // 回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return customers;
        }
    }

    @Override
    public void add(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(customer);

            // 提交
            transaction.commit();
        } catch (Exception e) {
            // 回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
