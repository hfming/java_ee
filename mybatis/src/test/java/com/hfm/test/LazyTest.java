package com.hfm.test;

import com.hfm.dao.AccountDao3;
import com.hfm.dao.RoleDao;
import com.hfm.domain.Account;
import com.hfm.domain.Role;
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
 * @version 1.01 2020-10-23 21:13
 * @Description 延迟加载测试
 * @date 2020/10/23
 */
public class LazyTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 一对多延迟加载
     */
    @Test
    public void  oneToOneTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao3 mapper = sqlSession.getMapper(AccountDao3.class);

        List<Account> accounts = mapper.lazyFind();

        for (Account account : accounts) {
            System.out.println(account);
        }

        Account account = accounts.get(0);
        System.out.println(account.getUser());

        sqlSession.close();
    }

    /**
     * 多对多延迟查询
     */
    @Test
    public void manyToManyLazyTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        List<Role> roles = mapper.lazyFind();

        sqlSession.close();
    }
}
