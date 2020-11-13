package com.hfm.test;

import com.hfm.dao.UserDao;
import com.hfm.dao.impl.UserDaoImpl;
import com.hfm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 20:35
 * @Description UserDaoImpl 实现类测试
 * @date 2020/10/22
 */
public class UserDaoImplTest {
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
     * 查询所有
     */
    @Test
    public void findAllTest() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 通过 id 查询
     */
    @Test
    public void findByIdTest() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * 通过名称模糊查询
     */
    @Test
    public void findByNameTest() {
        List<User> user = userDao.findByName("%二%");
        System.out.println(user);
    }

    /**
     * 保存用户
     */
    public void saveTest() {
        User user = new User();
        user.setUsername("葡糖糖");
        user.setSex("女");
        user.setAddress("北极星");
        user.setBirthday(new Date());

        userDao.save(user);
    }

    /**
     * 更新用户
     */
    public void update() {
        User user = userDao.findById(53);
        user.setUsername("胖嘟嘟");

        userDao.update(user);
    }

    /**
     * 删除用户
     */
    public void delete() {
        userDao.delete(53);
    }
}
