package com.hfm.service.impl;

import com.hfm.beans.User;
import com.hfm.mapper.UserMapper;
import com.hfm.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hfm
 * @since 2020-10-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public void test(){
        // ServiceImpl 已经注入 Mapper对象，可以直接使用CRUD 方法
        save(new User());
    }
}
