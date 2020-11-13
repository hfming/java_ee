package com.hfm.test;

import com.hfm.dao.CustomerDao;
import com.hfm.dao.impl.CustomerDaoImpl;
import com.hfm.pojo.Customer;
import org.junit.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 21:04
 * @Description
 * @date 2020/9/22
 */
public class CustomerDaoTest {
    @Test
    public void addTest(){
        Customer customer = new Customer(null, "百度", "", "", "高级客户", "13112121", "0577-1212232");
        CustomerDao customerDao = new CustomerDaoImpl();

        customerDao.add(customer);
    }
}
