package com.hfm.jpa;

import com.hfm.dao.CustomerDao;
import com.hfm.domain.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-10 14:41
 * @Description
 * @date 2020/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class) // 声明 spring 提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml") //指定 Spring IOC 配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 查询所有数据
     */
    @Test
    public void testFindAll() {
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    /**
     * 通过 ID 查询
     */
    @Test
    public void testFindById() {
        Customer one = customerDao.findOne(1L);
        System.out.println(one);
    }

    /**
     * 添加
     */
    @Test
    public void testAdd() {
        Customer c = new Customer();
        c.setCustName("传智播客");
        // save 保存或者更新，根据传递的对象是否存在主键 id，如果没有id 主键属性则保存，如果存在id 主键属性，根据id 查询数据，更新数据
        // 类似于 Hibernate 中的saveAdnUpdate 方法，根据对象的状态(游离态、托管态、持久态) 对对象进行相应的操作
        customerDao.save(c);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate() {
        Customer one = customerDao.findOne(3L);

        one.setCustName("尚硅谷");
        customerDao.save(one);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        customerDao.delete(3L);
    }
}
