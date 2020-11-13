package com.hfm.jpa;

import com.hfm.domain.Customer;
import com.hfm.utils.JPAUtil;
import org.hibernate.annotations.QueryHints;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.QueryHint;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-09 21:33
 * @Description
 * @date 2020/10/9
 */
public class JPQLTest {
    /**
     * 查询所有数据
     */
    @Test
    public void findAll() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 创建 Query 对象，接收 JPQL 语句
            Query query = entityManager.createQuery("from Customer ");
            // 查询数据库，获取集合对象
            List<Customer> resultList = query.getResultList();

            for (Customer customer : resultList) {
                System.out.println(customer);
            }

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // 关闭资源
            entityManager.close();
        }
    }

    /**
     * 排序查询
     */
    @Test
    public void orderQuery() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 创建 Query 对象，接收 JPQL 语句
            Query query = entityManager.createQuery("from Customer order by custId desc ");

            // 查询数据库，获取集合对象
            List<Customer> resultList = query.getResultList();

            for (Customer customer : resultList) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // 关闭资源
            entityManager.close();
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void pageQuery() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 创建 Query 对象，接收 JPQL 语句
            Query query = entityManager.createQuery("from Customer ");

            // 设置起始索引
            query.setFirstResult(0);
            // 设置每页记录数目
            query.setMaxResults(3);

            // 查询数据库，获取集合对象
            List<Customer> resultList = query.getResultList();

            for (Customer customer : resultList) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // 关闭资源
            entityManager.close();
        }
    }

    /**
     * 查询部分数据
     */
    @Test
    public void selectPartTest() {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            // 查询部分字段
            Query query = entityManager.createQuery("select custName from Customer ");

            List<String> custNames = query.getResultList();
            for (String custName : custNames) {
                System.out.println(custName);
            }

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    /**
     * 查询缓存
     */
    @Test
    public void  queryCatche(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            // 查询部分字段
            Query query = entityManager.createQuery("from Customer");

            // 设置缓存
            Query hint = query.setHint(QueryHints.CACHEABLE, true);

            // 第一次从数据库中查询
            List<Customer> customers = hint.getResultList();

            for (Customer customer : customers) {
                System.out.println(customer);
            }

            // 查询部分字段
            Query query2 = entityManager.createQuery("from Customer");

            // 设置缓存
            Query hint2 = query2.setHint(QueryHints.CACHEABLE, true);

            // 第二次从缓存中查询
            List<String> custNames2 = hint2.getResultList();
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    /**
     * 条件查询
     */
    @Test
    public void whereQuery() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 创建 Query 对象，接收 JPQL 语句
            Query query = entityManager.createQuery("from Customer where custId < ?1");

            query.setParameter(1, 100L);

            // 查询数据库，获取集合对象
            List<Customer> resultList = query.getResultList();

            for (Customer customer : resultList) {
                System.out.println(customer);
            }
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // 关闭资源
            entityManager.close();
        }
    }


    /**
     * 统计查询
     */
    @Test
    public void countQuery() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 创建 Query 对象，接收 JPQL 语句
            Query query = entityManager.createQuery("select count(1) from Customer");

            // getSingleResult 获取单个结果
            Long singleResult = (Long) query.getSingleResult();
            System.out.println(singleResult.intValue());

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // 关闭资源
            entityManager.close();
        }
    }
}
