package com.hfm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.hfm.dao.UserDao;
import com.hfm.dao.UserDao2;
import com.hfm.dao.impl.UserDaoImpl;
import com.hfm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-21 17:16
 * @Description mybatis 入门案例
 * @date 2020/10/21
 */
public class UserDaoTest {
    @Test
    public void findAll() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        // 5.使用代理对象执行方法
        List<User> users = mapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        // 6.释放资源
        sqlSession.close();
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
     * dao 接口实现类测试
     */
    @Test
    public void daoImplTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);

        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void findById() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        // 5.使用代理对象执行方法
        User user = mapper.findById(41);

        System.out.println(user);

        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 保存用户
     *
     * @throws IOException
     */
    @Test
    public void saveTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("hfm");
        user.setBirthday(new Date());
        user.setAddress("浙江");
        user.setSex("男");

        mapper.save(user);

        // 手动提交事务，默认开启手动事务，关闭自动提交事务
        sqlSession.commit();
        // 6.关闭资源
        sqlSession.close();
    }

    /**
     * 修改用户
     *
     * @throws IOException
     */
    @Test
    public void updateTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = mapper.findById(52);
        user.setUsername("霍夫曼");

        mapper.update(user);

        // 手动提交事务，默认开启手动事务，关闭自动提交事务
        sqlSession.commit();
        // 6.关闭资源
        sqlSession.close();
    }

    /**
     * 通过名称模糊查询
     *
     * @throws IOException
     */
    @Test
    public void findByName() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        // 5.使用代理对象执行方法
        List<User> users = mapper.findByName("%二%");

        for (User user : users) {
            System.out.println(user);
        }
        // 6.释放资源
        sqlSession.close();
    }


    /**
     * 统计查询
     *
     * @throws IOException
     */
    @Test
    public void countTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        // 5.使用代理对象执行方法
        Long count = mapper.count();
        System.out.println(count.intValue());

        // 6.释放资源
        sqlSession.close();
    }
}
