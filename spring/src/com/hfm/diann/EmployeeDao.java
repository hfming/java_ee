package com.hfm.diann;

import org.springframework.stereotype.Repository;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 19:03
 * @Description
 * @date 2020/9/28
 */
@Repository(value = "employeeDao")
public interface EmployeeDao {
    /**
     * 添加员工
     * @param employee
     */
    void add(Employee employee);
}
