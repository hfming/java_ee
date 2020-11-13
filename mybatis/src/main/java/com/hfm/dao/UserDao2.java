package com.hfm.dao;

import com.hfm.domain.User;
import com.hfm.mybatis.annotation.MySelect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-21 16:02
 * @Description
 * @date 2020/10/21
 */
public interface UserDao2 {
    /**
     * 查询所有
     *
     * @return
     */
    @Select(value = "select * from mb_user")
    @MySelect(value = "select * from mb_user")
    // 自定义 mybatis 框架 注解
    List<User> findAll();

    /**
     * 根据 ID 查询
     *
     * @param id
     * @return
     */
    @Select(value = "select * from  mb_user where id = #{id}")
    User findById(Integer id);

    /**
     * 更新
     *
     * @param user
     */
    @Update(value = "update mb_user set username = #{username} ,address = #{address},sex =#{sex} ,birthday = #{birthday} where id = ${id}")
    void update(User user);

    /**
     * 删除
     *
     * @param id
     */
    @Delete(value = "delete from mb_user where id = #{id}")
    void delete(Integer id);

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Insert(value = "insert into mb_user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void save(User user);

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
    @Select(value = "select * from mb_user where username like #{username}")
    List<User> findByName(String username);

    /**
     * 查询数值
     * @return
     */
    @Select(value = "select count(1) from mb_user")
    Integer count();
}
