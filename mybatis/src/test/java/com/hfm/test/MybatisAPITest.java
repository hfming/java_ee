package com.hfm.test;

import com.hfm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-24 16:18
 * @Description 基于 Mybatis API 方式实现 CRUD
 * @date 2020/10/24
 */
public class MybatisAPITest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 查询所有
     */
    @Test
    public void  selectListTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("com.hfm.dao.UserDao.findAll", null);

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 根据 id 查询
     */
    @Test
    public void selectOneTet(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("com.hfm.dao.UserDao.findById", 41);

        System.out.println(user);
        sqlSession.close();
    }
}
