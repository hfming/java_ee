package com.hfm.diann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 17:53
 * @Description
 * @date 2020/9/28
 */
@Service(value = "employeeServerImpl")
public class EmployeeServerImpl implements EmployeeServer {
    /**
     * 有多个子类或实现类必须指定一个
     */
    @Autowired
    @Qualifier(value = "employeeDaoImpl1")
    private EmployeeDao employeeDao;

    @Override
    public void add(Employee employee) {
        System.out.println("Server 层");
        employeeDao.add(employee);
    }
}
