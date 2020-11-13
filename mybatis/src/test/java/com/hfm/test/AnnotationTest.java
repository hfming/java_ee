package com.hfm.test;

import com.hfm.dao.AccountDao4;
import com.hfm.dao.UserDao2;
import com.hfm.dao.UserDao4;
import com.hfm.domain.Account;
import com.hfm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-24 10:22
 * @Description 注解式开发
 * @date 2020/10/24
 */
public class AnnotationTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    /**
     * 注解式开发 mybatis
     *
     * @throws IOException
     */
    @Test
    public void annoTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);

        // 5.使用代理对象执行方法
        List<User> users = mapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 根据 id 查询
     */
    @Test
    public void findByIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);

        User user = mapper.findById(52);

        System.out.println(user);

        sqlSession.close();
    }

    /**
     * 保存用户
     */
    @Test
    public void saveTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);
        User user = new User();
        user.setUsername("hfm");
        user.setBirthday(new Date());
        user.setAddress("浙江");
        user.setSex("男");

        mapper.save(user);
        sqlSession.close();
    }

    /**
     * 通过用户名模糊查询
     */
    @Test
    public void findByNameTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);

        List<User> users = mapper.findByName("%王%");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 查询数值
     */
    @Test
    public void  countTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao2 mapper = sqlSession.getMapper(UserDao2.class);

        Integer count = mapper.count();
        System.out.println(count.intValue());

        sqlSession.close();
    }

    /**
     * 一对多
     */
    @Test
    public void oneToManyTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao4 mapper = sqlSession.getMapper(UserDao4.class);

        List<User> all = mapper.findAll();

        for (User user : all) {
            System.out.println(user);
            List<Account> accounts = user.getAccounts();
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
        sqlSession.close();
    }

    /**
     * 多对一，一对一
     */
    @Test
    public void oneToOneTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao4 mapper = sqlSession.getMapper(AccountDao4.class);

        List<Account> all = mapper.findAll();

        for (Account account : all) {
            System.out.println(account);
            User user = account.getUser();
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     *
     */
    @Test
    public void cacheTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao4 mapper = sqlSession.getMapper(AccountDao4.class);

        List<Account> all = mapper.findAll();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        AccountDao4 mapper2 = sqlSession2.getMapper(AccountDao4.class);

        List<Account> all2 = mapper2.findAll();
    }
}
