package com.hfm.server.impl;

import com.hfm.dao.CustomerDao;
import com.hfm.dao.impl.CustomerDaoImpl;
import com.hfm.pojo.Customer;
import com.hfm.server.CustomerServer;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 20:39
 * @Description CustomerServer 接口实现类
 * @date 2020/9/22
 */
public class CustomerServerImpl
        implements CustomerServer {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
    }
}
