package com.hfm.diann;

import org.springframework.stereotype.Repository;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 19:35
 * @Description
 * @date 2020/9/28
 */
@Repository(value = "employeeDaoImpl1")
public class EmployeeDaoImpl1 implements EmployeeDao {
    @Override
    public void add(Employee employee) {
        System.out.println("Dao 层");
        System.out.println("EmployeeDaoImpl1");
        System.out.println("添加员工:" + employee.getEmpName());
    }
}
