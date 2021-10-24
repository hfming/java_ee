package com.hfm.dao;

import com.hfm.domain.UserFirst;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-21 14:27
 * @Description
 * @date 2021/10/21
 */
public interface UserFirstDao {
    /**
     * 查询所有数据
     * 接口中的抽象方法与 映射配置文件中的select 等标签动态绑定
     *
     * @return
     */
    @Select("select * from  mb_user")
    List<UserFirst> findAll();

    /**
     * 通过 Id 查询
     * 接口中的抽象方法与 映射配置文件中的select 等标签动态绑定
     *
     * @param id
     * @return
     */
    UserFirst findById(Integer id);
}
