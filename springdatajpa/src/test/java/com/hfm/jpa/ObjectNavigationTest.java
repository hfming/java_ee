package com.hfm.jpa;

import com.hfm.dao.Customer2Dao;
import com.hfm.dao.LinkMan2Dao;
import com.hfm.domain.Customer2;
import com.hfm.domain.LinkMan2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-12 10:09
 * @Description
 * @date 2020/10/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectNavigationTest {
    @Autowired
    private Customer2Dao customer2Dao;
    @Autowired
    private LinkMan2Dao linkMan2Dao;

    /**
     * 对象导航测试
     */
    @Test
    @Transactional // 由于是在java代码中测试，为了解决no session问题，将操作配置到同一个事务中
    public void objectTest() {
        Customer2 customer = customer2Dao.findOne(1L);
        Set<LinkMan2> linkMans = customer.getLinkMan2();//对象导航查询
        for (LinkMan2 linkMan : linkMans) {
            System.out.println(linkMan);
        }
    }

    @Test
    @Transactional
    public void ObjectTest2() {
        LinkMan2 one = linkMan2Dao.findOne(1L);

        Customer2 customer2 = one.getCustomer2();
        System.out.println(customer2);
    }

    /**
     * 动态查询
     */

    @Test
    public void testFind() {
        List<LinkMan2> list = linkMan2Dao.findAll((root, query, cb) -> {
            // Join代表链接查询，通过root对象获取
            // 创建的过程中，第一个参数为关联对象的属性名称，第二个参数为连接查询的方式（left，inner，right）
            // JoinType.LEFT : 左外连接,JoinType.INNER：内连接,JoinType.RIGHT：右外连接
            Join<LinkMan2, Customer2> join = root.join("customer2", JoinType.INNER);
            return cb.like(join.get("custName").as(String.class), "%传智%");
        });

        for (LinkMan2 linkMan : list) {
            System.out.println(linkMan);
        }
    }
}
