package com.hfm.test;

import com.hfm.dao.RoleDao;
import com.hfm.dao.RoleUserDao;
import com.hfm.domain.Role;
import com.hfm.domain.RoleUser;
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
 * @version 1.01 2020-10-23 20:03
 * @Description
 * @date 2020/10/23
 */
public class ManyToManyTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 单向多对多测试
     */
    @Test
    public void  manyToManyTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RoleDao mapper = sqlSession.getMapper(RoleDao.class);

        List<Role> all = mapper.findAll();
        for (Role role : all) {
            System.out.println(role);
            List<RoleUser> users = role.getUsers();
            for (RoleUser user : users) {
                System.out.println(user);
            }
        }
        sqlSession.close();
    }

    /**
     * 单向多对多测试
     */
    @Test
    public void  doubleTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RoleUserDao mapper = sqlSession.getMapper(RoleUserDao.class);

        List<RoleUser> all = mapper.findAll();
        for (RoleUser roleUser : all) {
            System.out.println(roleUser);
            List<Role> roles = roleUser.getRoles();
            for (Role role : roles) {
                System.out.println(role);
            }
        }
        sqlSession.close();
    }
}
