package com.hfm.jpa;

import com.hfm.domain.Customer;
import com.hfm.utils.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-09 14:44
 * @Description
 * @date 2020/10/9
 */
public class JPATest {
    @Test
    public void testSave() {
        // 1.加载配置文件创建实体管理类工厂对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myjpa");

        // 2.通过实体管理器工厂获取实体管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 3.开启事务，获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        // 4.完成 CRUD 操作
        Customer customer = new Customer();
        customer.setCustName("百度");
        customer.setCustIndustry("搜索");

        // 5.提交事务/回滚事务
        entityManager.persist(customer);

        transaction.commit();
        // 6.关闭资源

        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * 保存操作
     */
    @Test
    public void testSave2() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;

        // 保存操作
        Customer customer = new Customer();

        customer.setCustName("传智学院");
        customer.setCustLevel("VIP客户");
        customer.setCustSource("网络");
        customer.setCustIndustry("IT教育");
        customer.setCustAddress("昌平区北七家镇");
        customer.setCustPhone("010-84389340");
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(customer);

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
     * 修改操作
     */
    @Test
    public void testUpdate() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 通过id 查询实体对象
            Customer customer = entityManager.find(Customer.class, 1L);
            customer.setCustAddress("北京");

            // 修改实体对象
            entityManager.merge(customer);

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
     * 删除操作
     */
    @Test
    public void testDelete(){
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 按照id 查询实体对象
            Customer customer = entityManager.getReference(Customer.class, 1L);

            // 删除实体对象
            entityManager.remove(customer);

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
     * 通过 ID 查询对象，立即加载
     */
    @Test
    public void testFindById() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 通过 Id 查询实体对象
            // class 实体类的字节码
            // id 主键的值
            Customer customer = entityManager.find(Customer.class, 1L);
            System.out.println(customer);

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
     * 延迟加载
     */
    @Test
    public void testReference() {
        // 通过 JPA 工具类获取实体管理器对象
        EntityManager entityManager = null;

        // 获取实体事务对象
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 通过 Id 查询实体对象
            // class 实体类的字节码
            // id 主键的值
            Customer customer = entityManager.getReference(Customer.class, 1L);
            System.out.println(customer);

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
