package com.hfm.diann;

import org.springframework.stereotype.Service;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-02 9:47
 * @Description
 * @date 2020/10/2
 */
@Service(value = "employeeServer")
public interface EmployeeServer {
    /**
     * 添加员工
     * @param employee
     */
    void add(Employee employee);
}
