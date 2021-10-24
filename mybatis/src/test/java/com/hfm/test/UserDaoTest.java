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
}
