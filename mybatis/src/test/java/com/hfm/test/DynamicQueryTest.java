package com.hfm.test;

import com.hfm.dao.CRUDUserDao;
import com.hfm.domain.CRUDUser;
import com.hfm.domain.condition.CRUDUserCondition;
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

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * if 标签动态查询，根据输入的参数进行动态查询
     */
    @Test
    public void ifTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        CRUDUser user = new CRUDUser();
        user.setAddress("%浙江%");

        List<CRUDUser> users = mapper.findByUser(user);

        for (CRUDUser myUser : users) {
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
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        CRUDUser user = new CRUDUser();
        user.setAddress("%浙江%");

        List<CRUDUser> users = mapper.findByCondition(user);

        for (CRUDUser myUser : users) {
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
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);

        CRUDUserCondition userCondition = new CRUDUserCondition();
        userCondition.setIds(ids);

        List<CRUDUser> users = mapper.findByIntegers(userCondition);

        for (CRUDUser myUser : users) {
            System.out.println(myUser);
        }

        sqlSession.close();
    }
}
