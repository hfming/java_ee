package com.hfm.dao;

import com.hfm.pojo.Customer;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 20:37
 * @Description CustomerDao 接口
 * @date 2020/9/22
 */
public interface CustomerDao {
    List<Customer> findAll();

    void add(Customer customer);
}
