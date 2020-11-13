package com.hfm.dao.impl;

import com.hfm.dao.UserDao;
import com.hfm.domain.User;
import com.hfm.domain.condition.UserCondition;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-21 18:54
 * @Description Dao 接口实现类
 * @date 2020/10/21
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("com.hfm.dao.UserDao.findAll");
        sqlSession.close();
        return users;
    }

    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.hfm.dao.UserDao.findById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public void save(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.hfm.dao.UserDao.save", user);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("com.hfm.dao.UserDao.save", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<User> findByName(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("com.hfm.dao.UserDao.findByName", username);
        sqlSession.close();
        return users;
    }

    @Override
    public Long count() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Long count = sqlSession.selectOne("com.hfm.dao.UserDao.count");
        sqlSession.close();
        return count;
    }

    @Override
    public void delete(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.hfm.dao.UserDao.delete", id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<User> findByUser(User user) {
        return null;
    }

    @Override
    public List<User> findByCondition(User user) {
        return null;
    }

    @Override
    public List<User> findByIntegers(UserCondition userCondition) {
        return null;
    }
}
