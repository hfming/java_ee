package com.hfm.test;

import com.hfm.dao.UserDao;
import com.hfm.dao.impl.UserDaoImpl;
import com.hfm.domain.User;
import com.hfm.domain.condition.UserCondition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 12:04
 * @Description 动态查询测试
 * @date 2020/10/23
 */
public class DynamicQueryTest {
    private SqlSessionFactory sqlSessionFactory;

    private UserDao userDao;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }

    /**
     * if 标签动态查询，根据输入的参数进行动态查询
     */
    @Test
    public void ifTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setAddress("%浙江%");

        List<User> users = mapper.findByUser(user);

        for (User myUser : users) {
            System.out.println(myUser);
        }

        sqlSession.close();
    }

    /**
     * where 标签
     */
    @Test
    public void whereTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setAddress("%浙江%");

        List<User> users = mapper.findByCondition(user);

        for (User myUser : users) {
            System.out.println(myUser);
        }

        sqlSession.close();
    }

    /**
     * 动态查询 foreach 标签
     */
    @Test
    public void foreachTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);

        UserCondition userCondition = new UserCondition();
        userCondition.setIds(ids);

        List<User> users = mapper.findByIntegers(userCondition);

        for (User myUser : users) {
            System.out.println(myUser);
        }

        sqlSession.close();
    }
}
