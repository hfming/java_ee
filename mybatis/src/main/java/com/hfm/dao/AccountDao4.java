package com.hfm.dao;

import com.hfm.domain.Account;
import com.hfm.domain.subject.AccountSubject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 16:36
 * @Description
 * @date 2020/10/23
 */
@CacheNamespace(blocking = true) // 开启二级缓存
public interface AccountDao4 {
    /**
     * 查询所有
     *
     * @return
     */
    @Select(value = "select * from mb_account")
    @Results(id = "accountMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "uid", property = "uid"),
                    @Result(column = "money", property = "money"),
                    @Result(column = "uid",
                            property = "user",
                            one = @One(select = "com.hfm.dao.UserDao4.findById",
                                    fetchType = FetchType.LAZY) // 懒加载
                    )
            })
    List<Account> findAll();


    /**
     * 通过 id 查询
     *
     * @return
     */
    @Select(value = "select * from mb_account where uid = #{uid}")
    @ResultMap(value = "accountMap")
    Account findByUId(Integer id);
}
