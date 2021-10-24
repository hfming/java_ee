package com.hfm.test;

import com.hfm.dao.CRUDUserDao;
import com.hfm.dao.UserDao;
import com.hfm.dao.UserFirstDao;
import com.hfm.domain.CRUDUser;
import com.hfm.domain.User;
import com.hfm.domain.UserFirst;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
 * @version 1.01 2021-10-21 19:56
 * @Description
 * @date 2021/10/21
 */
public class CRUDTest {
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
     *
     * @throws IOException
     */
    @Test
    public void findAll() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        // 5.使用代理对象执行方法
        List<CRUDUser> users = mapper.findAll();

        for (CRUDUser user : users) {
            System.out.println(user);
        }

        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 保存用户
     *
     * @throws IOException
     */
    @Test
    public void saveTest() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        CRUDUser user = new CRUDUser();
        user.setUsername("hfm");
        user.setBirthday(new Date());
        user.setAddress("浙江");
        user.setSex("男");

        mapper.save(user);

        // 手动提交事务，默认开启手动事务，关闭自动提交事务
        sqlSession.commit();
        // 6.关闭资源
        sqlSession.close();
    }

    /**
     * 修改用户
     *
     * @throws IOException
     */
    @Test
    public void updateTest() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        CRUDUser user = mapper.findById(52);
        user.setUsername("霍夫曼");

        mapper.update(user);

        // 手动提交事务，默认开启手动事务，关闭自动提交事务
        sqlSession.commit();
        // 6.关闭资源
        sqlSession.close();
    }

    /**
     * 通过 id 查询
     *
     * @throws IOException
     */
    @Test
    public void findById() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserFirstDao mapper = sqlSession.getMapper(UserFirstDao.class);

        // 5.使用代理对象执行方法
        UserFirst user = mapper.findById(41);

        System.out.println(user);

        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 通过名称模糊查询
     *
     * @throws IOException
     */
    @Test
    public void findByName() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        // 5.使用代理对象执行方法
        List<CRUDUser> users = mapper.findByName("%二%");

        for (CRUDUser user : users) {
            System.out.println(user);
        }
        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 统计查询
     *
     * @throws IOException
     */
    @Test
    public void countTest() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        // 5.使用代理对象执行方法
        Long count = mapper.count();
        System.out.println(count.intValue());

        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 通过 Id 查询
     */
    @Test
    public void delete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CRUDUserDao mapper = sqlSession.getMapper(CRUDUserDao.class);

        mapper.deleteById(53);

        sqlSession.close();
    }
}
