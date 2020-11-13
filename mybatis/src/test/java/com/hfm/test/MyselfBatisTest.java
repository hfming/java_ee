package com.hfm.test;

import com.hfm.dao.UserDao;
import com.hfm.dao.UserDao2;
import com.hfm.domain.User;
import com.hfm.mybatis.io.MyResources;
import com.hfm.mybatis.sqlsession.MySqlSession;
import com.hfm.mybatis.sqlsession.MySqlSessionFactory;
import com.hfm.mybatis.sqlsession.MySqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 11:29
 * @Description 自定义 Mybatis 测试
 * @date 2020/10/22
 */
public class MyselfBatisTest {
    /**
     * xml 方式
     *
     * @throws IOException
     */
    @Test
    public void mybatisTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = MyResources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        MySqlSessionFactoryBuilder sqlSessionFactoryBuilder = new MySqlSessionFactoryBuilder();
        MySqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.bulider(resourceAsStream);

        MySqlSession mySqlSession = sqlSessionFactory.openSession();

        UserDao mapper = mySqlSession.getMapper(UserDao.class);

        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 注解方式
     *
     * @throws IOException
     */
    @Test
    public void annoTest() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = MyResources.getResourceAsStream("SqlMapConfig");

        // 2.创建 SqlSessionFactory 工厂类对象
        MySqlSessionFactoryBuilder sqlSessionFactoryBuilder = new MySqlSessionFactoryBuilder();
        MySqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.bulider(resourceAsStream);

        MySqlSession mySqlSession = sqlSessionFactory.openSession();

        UserDao2 mapper = mySqlSession.getMapper(UserDao2.class);

        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
