package com.hfm.test;

import com.hfm.dao.AccountDao3;
import com.hfm.dao.UserDao3;
import com.hfm.domain.Account;
import com.hfm.domain.User;
import com.hfm.domain.subject.AccountSubject;
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
 * @version 1.01 2020-10-23 17:37
 * @Description
 * @date 2020/10/23
 */
public class OneToManyTest {
    private SqlSessionFactory sqlSessionFactory;

    private AccountDao3 accountDao3;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 通过子类实现 一对多查询
     */
    @Test
    public void subjectTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao3 mapper = sqlSession.getMapper(AccountDao3.class);

        List<AccountSubject> all = mapper.findAll();
        for (AccountSubject accountSubject : all) {
            System.out.println(accountSubject);
        }

        sqlSession.close();
    }


    /**
     *  一对多查询
     */
    @Test
    public void oneToManyTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountDao3 mapper = sqlSession.getMapper(AccountDao3.class);

        List<Account> all = mapper.findAll2();
        for (Account account : all) {
            System.out.println(account);
            User user = account.getUser();
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 多对一关系
     */
    @Test
    public void  manyToOne(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao3 mapper = sqlSession.getMapper(UserDao3.class);

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
}
