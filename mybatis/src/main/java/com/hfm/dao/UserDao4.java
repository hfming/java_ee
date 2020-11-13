package com.hfm.dao;

import com.hfm.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 16:21
 * @Description
 * @date 2020/10/23
 */
public interface UserDao4 {
    /**
     * 查询所有
     *
     * @return
     */
    @Select(value = "select * from mb_user")
    @Results(id = "userMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "sex", property = "sex"),
                    @Result(column = "address", property = "address"),
                    @Result(column = "birthday", property = "birthday"),
                    @Result(column = "id",
                            property = "accounts",
                            many = @Many(
                                    select = "com.hfm.dao.AccountDao4.findByUId",
                                    fetchType = FetchType.LAZY
                            )
                    )
            })
    List<User> findAll();

    /**
     * 通过 id 查找
     *
     * @param id
     * @return
     */
    @Select(value = "select * from mb_user where id = #{id}")
    @ResultMap(value = "userMap")
    User findById(Integer id);
}
