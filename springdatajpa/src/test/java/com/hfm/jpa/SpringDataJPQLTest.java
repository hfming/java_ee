package com.hfm.jpa;

import com.hfm.dao.CustomerDao;
import com.hfm.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-10 17:35
 * @Description
 * @date 2020/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJPQLTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * JPQL 查询
     */
    @Test
    public void testFindAll(){
        List<Customer> customers = customerDao.findCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testFindById(){
        Customer customer = customerDao.findCustomerById(2L);
        System.out.println(customer);
    }

    /**
     * JPQL 更新
     * SpringDataJPA 中使用 jpql 完成更新、删除操作必须添加手动事务操作，默认执行之后回滚事务
     */
    @Test
    @Transactional // 数据更新需要添加事务操作
    @Rollback(value = false) // 需要添加不自动回滚的注解
    public void testFindCustomerByIdAndName(){
        Customer customer = customerDao.findCustomerByIdAnCustName(1L, "百度");
        System.out.println(customer);
    }

    /**
     * 本地 sql 查询
     */
    @Test
    public void testFindSQL(){
        List<Customer> customers = customerDao.findSQL();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * 通过方法命名规则查询
     */
    @Test
    public void testByName(){
        Customer customer = customerDao.findByCustName("传智学院");
        System.out.println(customer);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testContaining(){
        Customer customer = customerDao.findByCustNameContaining("学");
        System.out.println(customer);
    }
}
