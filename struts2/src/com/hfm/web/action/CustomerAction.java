package com.hfm.web.action;

import com.hfm.pojo.Customer;
import com.hfm.server.CustomerServer;
import com.hfm.server.impl.CustomerServerImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 20:29
 * @Description
 * @date 2020/9/22
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private CustomerServer customerServer = new CustomerServerImpl();

    private List<Customer> list;

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public String findAll() {
        list= customerServer.findAll();

        return "findAll";
    }

    /**
     * 创建成员
     */
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return this.customer;
    }

    /**
     * 添加用户
     *
     * @return
     */
    public String addCustomer() {
        // 添加用户
        customerServer.add(customer);
        return "saveSuccess";
    }

    /**
     * 跳转页面
     *
     * @return
     */
    public String toAddPage() {
        return "toAddPage";
    }
}
