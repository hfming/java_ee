package com.hfm.test;

import com.hfm.dao.UserFirstDao;
import com.hfm.domain.UserFirst;
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
public class FirstMybatisTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig");
        // 通过 SqlSessionFactoryBuilder 创建 SqlSessionFactory 对象
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    /**
     * 根据 id 查询
     * 只需要有映射配置文件即可，使用对应的映射配置文件中的名称空间及其 select 的id 即可找到对应的 sql 语句进行相应的查询。
     */
    @Test
    public void selectOneTet() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询单条数据
        UserFirst user = sqlSession.selectOne("com.hfm.dao.UserFirstDao.findById", 41);

        System.out.println(user);
        sqlSession.close();
    }
    /**
     * 查询所有
     */
    @Test
    public void selectListTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询所有数据
        List<UserFirst> users = sqlSession.selectList("com.hfm.dao.UserFirstDao.findAll", null);

        for (UserFirst user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 通过 Mapper 接口生成代理类 Mapper 进行查询一个联系人
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
     * 通过 Mapper 接口生成代理类 Mapper 进行查询所有联系人
     * 需要在映射配置文件中
     * @throws IOException
     */
    @Test
    public void findAll() throws IOException {
        // 3.使用工厂创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.使用SqlSession 创建 Dao 接口的代理对象
        UserFirstDao mapper = sqlSession.getMapper(UserFirstDao.class);
        System.out.println(mapper);

        // 5.使用代理对象执行方法
        List<UserFirst> users = mapper.findAll();

        for (UserFirst user : users) {
            System.out.println(user);
        }

        // 6.释放资源
        sqlSession.close();
    }

    /**
     * 通过 @Select  注解查询一条数据
     */
    @Test
    public void  selectById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserFirstDao mapper = sqlSession.getMapper(UserFirstDao.class);

        UserFirst userFirst = mapper.findById(41);
        System.out.println(userFirst);

        sqlSession.close();
    }

    /**
     * 通过 @Select 注解查询所有数据
     */
    @Test
    public void selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserFirstDao mapper = sqlSession.getMapper(UserFirstDao.class);

        List<UserFirst> all = mapper.findAll();
        for (UserFirst userFirst : all) {
            System.out.println(userFirst);
        }
        sqlSession.close();
    }
}
