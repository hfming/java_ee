package com.hfm.test;

import com.hfm.dao.RoleDao;
import com.hfm.dao.UserDao;
import com.hfm.domain.Role;
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
 * @version 1.01 2020-10-23 22:14
 * @Description 缓存测试
 * @date 2020/10/23
 */
public class CacheTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 一级缓存测试
     */
    @Test
    public void firstCacheTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        // 第一次查询
        List<Role> first = mapper.findAll();

        // 第二次查询
        List<Role> second = mapper.findAll();

        sqlSession.close();
    }

    /**
     * 清空缓存
     */
    @Test
    public void cleanCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        // 第一次查询
        List<Role> first = mapper.findAll();

        // 清空缓存
        sqlSession.clearCache();

        // 第二次查询
        List<Role> second = mapper.findAll();

        sqlSession.close();
    }

    /**
     * 更新缓存
     */
    @Test
    public void updateCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        // 第一次查询
        User first = mapper.findById(52);
        first.setUsername("霍夫曼");

        // 更新数据
        mapper.update(first);

        // 第二次查询
        User second = mapper.findById(52);
        sqlSession.close();
    }

    /**
     * 二级缓存测试
     */
    @Test
    public void secondCacheTest(){
        // 第一个 SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserDao mapper1 = sqlSession1.getMapper(UserDao.class);

        // 第一次查询
        User first = mapper1.findById(52);
        sqlSession1.close();

        // 第二个 SqlSession
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao mapper2 = sqlSession2.getMapper(UserDao.class);

        // 第二次查询
        User second = mapper2.findById(52);
        sqlSession2.close();
    }
}
