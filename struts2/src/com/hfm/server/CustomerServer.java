package com.hfm.server;

import com.hfm.pojo.Customer;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 20:38
 * @Description
 * @date 2020/9/22
 */
public interface CustomerServer {
    List<Customer> findAll();

    void add(Customer customer);
}
