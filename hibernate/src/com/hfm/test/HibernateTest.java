package com.hfm.test;

import com.hfm.entity.*;
import com.hfm.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-19 16:07
 * @Description
 * @date 2020/9/19
 */
public class HibernateTest {
    @Test
    public void test() {
//        第一步 加载hibernate核心配置文件
        // 会自动到 src 下找到 hibernate.cfg.xml 文件
        Configuration configuration = new Configuration();
        // 自动加载配置文件
        configuration.configure();

//        第二步 创建 SessionFactory 对象
        // 在过程中，根据映射关系，在配置数据库里面把表创建
        // Hibernate 4.0 之前
        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        第三步 使用SessionFactory创建session对象
        // 类似于连接 数据库
        Session session = sessionFactory.openSession();

//        第四步 开启事务
        Transaction transaction = session.beginTransaction();

//        第五步 写具体逻辑 crud操作
        // 添加功能
        User user = new User();
        user.setUsername("小王");
        user.setPassword("250");
        user.setAddress("日本");
        // 调用session的方法实现添加
        session.save(user);

//        第六步 提交事务
        transaction.commit();

//        第七步 关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testUtils() {
        // 使用工具类加载配置文件,创建 SessionFactory 对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // 使用 SessionFactory 对象创建 session 对象
        Session session = sessionFactory.openSession();
        // 使用 session 对象开启事务
        Transaction transaction = session.beginTransaction();

        User2 user = new User2();
        user.setUsername("大王");
        user.setPassword("250");
        user.setAddress("日本");
        session.save(user);

        transaction.commit();

        session.close();
    }

    @Test
    public void getTest() {
        // 使用工具类加载配置文件,创建 SessionFactory 对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // 使用 SessionFactory 对象创建 session 对象
        Session session = sessionFactory.openSession();

        User2 user2 = session.get(User2.class, "40281f3174a659ff0174a65a059a0000");

        System.out.println(user2);
        session.close();
    }

    @Test
    public void saveAndUpdate() {
        // 使用工具类加载配置文件,创建 SessionFactory 对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // 使用 SessionFactory 对象创建 session 对象
        Session session = sessionFactory.openSession();
        // 获取事务对象
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUsername("hfm");
        user.setPassword("17111711");
        user.setAddress("浙江");

        // 瞬时态对象 转换成 持久态对象
        session.saveOrUpdate(user);

        session.close();
    }

    @Test
    public void cacheTest() {
        // 使用工具类加载配置文件,创建 SessionFactory 对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // 使用 SessionFactory 对象创建 session 对象
        Session session = sessionFactory.openSession();

        User user1 = session.get(User.class, 1);
        System.out.println(user1);

        User user2 = session.get(User.class, 1);
        System.out.println(user2);
        session.close();
    }

    @Test
    public void cacheFeature() {
        // 使用工具类加载配置文件,创建 SessionFactory 对象
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        // 使用 SessionFactory 对象创建 session 对象
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 查询缓存中的数据,没有找到就从数据库中查询,查询后放入一级缓存中
        User user1 = session.get(User.class, 1);
        System.out.println(user1);
        user1.setUsername("newName");

        // 先到一级缓存中查找,找到即返回
        User user2 = session.get(User.class, 1);
        System.out.println(user2);

        // 对比快照区中的数据,如果不一样则提交修改
        transaction.commit();
        session.close();
    }

    /**
     * Hibernate 事务处理格式
     */
    @Test
    public void transactionTest() {
        Session session = null;
        Transaction transaction = null;
        try {
            // 使用工具类直接获取session 对象
            session = HibernateUtils.getSession();

            // 开启是数据库事务
            transaction = session.beginTransaction();

            // CRUD 操作

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 出现错误,事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {
            // 确保关闭 session
            HibernateUtils.closeSession(session);
        }
    }

    /**
     * Query 查询方法
     */
    @Test
    public void queryTest() {
        Session currentSession = null;
        Transaction transaction = null;
        try {
            currentSession = HibernateUtils.getCurrentSession();
            transaction = currentSession.beginTransaction();

            // 创建 Query 对象
            Query query = currentSession.createQuery("from User2");

            // 查询表中所有数据
            List<User2> list = query.list();

            System.out.println(list);

            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 出现错误,事务回滚
            transaction.rollback();
            e.printStackTrace();

        } finally {

        }
    }

    /**
     * 使用 criteria 对象查询所有数据
     * 方法已经淘汰
     */
    @Test
    public void criteriTest() {
        Session currentSession = null;
        Transaction transaction = null;
        try {
            currentSession = HibernateUtils.getCurrentSession();
            transaction = currentSession.beginTransaction();

            // 获取 criteri 对象
            Criteria criteria = currentSession.createCriteria(User2.class);

            List list = criteria.list();

            System.out.println(list);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 出现错误,事务回滚
            transaction.rollback();
            e.printStackTrace();

        } finally {

        }
    }

    @Test
    public void sqlQueryTest() {
        Session currentSession = null;
        Transaction transaction = null;
        try {
            currentSession = HibernateUtils.getCurrentSession();
            transaction = currentSession.beginTransaction();

            // 创建 SQL Query 对象
            NativeQuery sqlQuery = currentSession.createSQLQuery("select * from t_user2 ");

            // 设置结果的存储实体
            sqlQuery.addEntity(User2.class);

            // 默认返回的 list 集合是数组结构
            List list = sqlQuery.list();
//            List<Object[]> list = sqlQuery.list();
//            for (Object[] os : list) {
//                System.out.println(Arrays.toString(os));
//            }
            System.out.println(list);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            // 出现错误,事务回滚
            transaction.rollback();
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 一对多的关系
     */
    @Test
    public void oneToMany() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    /**
     * 一对多级联更新
     * 复杂方式
     */
    @Test
    public void updateCase1() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCust_name("百度");
            customer.setCust_level("普通客户");
            customer.setCust_source("网络");
            customer.setCust_phone("110");
            customer.setCust_mobile("999");

            Contact contact = new Contact();
            contact.setCont_name("小宏");
            contact.setCont_gender("男");
            contact.setCont_phone("911");

            // 把联系人放到客户里面
            customer.getContacts().add(contact);
            // 把客户放到联系人中
            contact.setCustomer(customer);

            // 保存到数据库中
            session.save(customer);
            session.save(contact);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 一对多级联更新,简化方式
     */
    @Test
    public void updateCase2() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCust_name("宏基");
            customer.setCust_level("高级客户");
            customer.setCust_source("网络");
            customer.setCust_phone("112");
            customer.setCust_mobile("92739");

            Contact contact = new Contact();
            contact.setCont_name("小拿");
            contact.setCont_gender("女");
            contact.setCont_phone("2018");

            // 只需要把联系人放到客户里面
            customer.getContacts().add(contact);

            // 只需要将客户保存到数据库中
            session.save(customer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 一对多 自动级联删除
     */
    @Test
    public void deleteCase() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 先获取需要删除的对象
            Customer customer = session.get(Customer.class, 2);

            // 在调用 session 的 delete 方法删除对象
            session.delete(customer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 一对多 自动级联修改
     */
    @Test
    public void changeCase() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 先获取需要修改的对象
            Customer customer = session.get(Customer.class, 1);

            // 获取需要修改的联系人
            Contact contact = session.get(Contact.class, 5);

            // 当前对象都是持久态对象,持久态对象修改属性值时会自动保存到数据库中
            // 将新的联系人加入到客户中
            customer.getContacts().add(contact);

            // 将客户加入到联系人中
            contact.setCustomer(customer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 多对多自动建表
     */
    @Test
    public void mtm(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 多对多级联保存
     */
    @Test
    public void caseSave(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            NewUser user1 = new NewUser();
            user1.setUser_name("lucy");
            user1.setUser_password("123");

            NewUser user2 = new NewUser();
            user2.setUser_name("mary");
            user2.setUser_password("456");

            Role r1 = new Role();
            r1.setRole_name("总经理");
            r1.setRole_memo("总经理");

            Role r2 = new Role();
            r2.setRole_name("秘书");
            r2.setRole_memo("秘书");

            Role r3 = new Role();
            r3.setRole_name("保安");
            r3.setRole_memo("保安");

            //2 建立关系，把角色放到用户里面
            // user1 -- r1/r2
            user1.getRoles().add(r1);
            user1.getRoles().add(r2);

            // user2 -- r2/r3
            user2.getRoles().add(r2);
            user2.getRoles().add(r3);

            //3 保存用户
            session.save(user1);
            session.save(user2);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 多对多 自动级联删除
     */
    @Test
    public void caseDelete(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 获取需要删除的对象
            NewUser newUser = session.get(NewUser.class, new Long(1));

            // 删除数据
            session.delete(newUser);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 维护第三张表
     * 用户添加角色
     */
    @Test
    public void addTest(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 查询需要添加角色的用户
            NewUser newUser = session.get(NewUser.class, new Long(3));

            // 需要添加的角色
            Role role = session.get(Role.class, new Long(6));

            // 将角色添加到用户中
            newUser.getRoles().add(role);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 维护第三张表
     * 用户添加角色
     */
    @Test
    public void deleteTest(){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            // 开启事务
            transaction = session.beginTransaction();

            // 查询需要添加角色的用户
            NewUser newUser = session.get(NewUser.class, new Long(3));

            // 需要添加的角色
            Role role = session.get(Role.class, new Long(6));

            // 用户删除角色
            newUser.getRoles().remove(role);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
