package com.hfm.jpa;

import com.hfm.dao.Customer2Dao;
import com.hfm.dao.LinkMan2Dao;
import com.hfm.domain.Customer2;
import com.hfm.domain.LinkMan2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-11 12:02
 * @Description 一对多的关系
 * @date 2020/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private Customer2Dao customer2Dao;

    @Autowired
    private LinkMan2Dao linkMan2Dao;

    /**
     * 添加操作
     */
    @Test
    @Transactional(propagation = Propagation.REQUIRED) // 开启事务
    @Rollback(false) // 关闭回滚
    public void addTest() {
        Customer2 customer2 = new Customer2();
        customer2.setCustName("搜狐");

        LinkMan2 linkMan2 = new LinkMan2();
        linkMan2.setLkmName("小明");
        // 将联系人添加到客户中才能建立关系
        customer2.getLinkMan2().add(linkMan2);

        // 没有将联系人添加到客户中时客户与联系人独立添加到数据库中没有建立关系
        customer2Dao.save(customer2);
        linkMan2Dao.save(linkMan2);
    }

    /**
     * 删除操作
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  deleteTest(){
        customer2Dao.delete(1L);
    }
}
