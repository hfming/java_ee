package com.hfm.dao;

import com.hfm.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository(value = "userMapper")
public interface UserMapper extends Mapper<User> {
}