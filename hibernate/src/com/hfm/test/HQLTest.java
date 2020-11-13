package com.hfm.test;

import com.hfm.entity.Customer;
import com.hfm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 19:55
 * @Description
 * @date 2020/9/20
 */
public class HQLTest {
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

            // 创建 query 对象
            Query query = session.createQuery("from Customer ");

            // 查询所有数据
            List<Customer> list = query.list();

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

            // 创建 query 对象
            // hibernate4.1之后已经对HQL查询参数中的占位符做了改进,占位符后需要加入数字
            Query query = session.createQuery("from Customer where cust_id = ?1 and  cust_name = ?2 and cust_level = ?3");

            // 填充占位符也需要数字指定占位符的位置
            // 参数一:参数位置
            // 参数二:参数值
            query.setParameter(1, 1);
            query.setParameter(2, "百度");
            query.setParameter(3, "普通客户");

            // 查询所有数据
            List<Customer> list = query.list();

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

            // 创建 query 对象
            Query query = session.createQuery("from Customer order by cust_id desc ");

            // 查询所有数据
            List<Customer> list = query.list();

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
     * 分页查询
     */
    @Test
    public void limit(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            Query query = session.createQuery("from Customer ");

            // 分页查询设置
            // 设置起始位置
            query.setFirstResult(1);
            // 设置
            query.setMaxResults(1);

            // 查询所有数据
            List<Customer> list = query.list();

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
     * 字段查询
     */
    @Test
    public void getSingle(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            Query query = session.createQuery("select cust_name from Customer ");

            // 查询所有数据
            List<Object> list = query.list();

            for (Object object : list) {
                System.out.println(object);
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
     * 字段查询
     */
    @Test
    public void getSingle2(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            Query query = session.createQuery("select cust_name,cust_level from Customer ");

            // 查询所有数据
            List<Object> list = query.list();

            for (Object object : list) {
                System.out.println(object);
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
    public void getCount(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            Query query = session.createQuery("select count(*) from Customer ");

            // 查询所有数据
            // 默认返回 long 类型
            Long aLong = (Long) query.uniqueResult();
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
     * 内连接
     */
    @Test
    public void innerJoin(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            // 内连接查询的实体一定要起别名
            Query query = session.createQuery("from Customer as c inner join c.contacts  ");

            // 内连接默认返回的集合存储的是数组数据
            List<Object[]> list = query.list();

            for (Object[] objs  : list) {
                System.out.println(Arrays.toString(objs));
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
     * 迫切内连接
     * 直接封装成对象
     */
    @Test
    public void innerJoinFetch(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            // 内连接查询的实体一定要起别名
            Query query = session.createQuery("from Customer as c inner join fetch  c.contacts  ");

            // 迫切内连接直接返回对象集合
            List<Customer> list = query.list();

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
     * 左外连接
     */
    @Test
    public void leftJoin(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            // 内连接查询的实体一定要起别名
            Query query = session.createQuery("from Customer as c left outer join   c.contacts  ");

            List<Object[]> list = query.list();

            for (Object[] objs  : list) {
                System.out.println(Arrays.toString(objs));
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
     * 迫切左外连接
     */
    @Test
    public void leftJoinFetch(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            // 内连接查询的实体一定要起别名
            Query query = session.createQuery("from Customer as c left outer join  fetch c.contacts  ");

            // 迫切内连接直接返回对象集合
            List<Customer> list = query.list();

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
     * 右外连接
     */
    @Test
    public void rightJoinFetch(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 创建 query 对象
            // 内连接查询的实体一定要起别名
            Query query = session.createQuery("from Customer as c right outer join  c.contacts  ");

            // 迫切内连接直接返回对象集合
            List<Object[]> list = query.list();

            for (Object[] objs  : list) {
                System.out.println(Arrays.toString(objs));
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
