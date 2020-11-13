package com.hfm.jpa;

import com.hfm.dao.CustomerDao;
import com.hfm.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-10 16:56
 * @Description
 * @date 2020/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJPATest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * count 方法统计总记录数目
     */
    @Test
    public void testCount(){
        long count = customerDao.count();
        System.out.println(count);
    }

    /**
     * exists 方法查询是否存在
     */
    @Test
    public void testExit(){
        boolean exists = customerDao.exists(1L);
        System.out.println(exists);
    }

    /**
     * getOne 方法获取一个指定对象
     * findOne 与 getOne 的区别，getOne 底层使用 JPA 的 getReference 方法实现延迟查询，findOne 底层使用 JPA find 方法实现立即查询
     * getOne 返回动态代理对象，什么时候使用什么时候查询数据库
     * 需要加上事务注解
     */
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void testGetOn(){
        Customer one = customerDao.getOne(1L);
        System.out.println(one);
    }
}
