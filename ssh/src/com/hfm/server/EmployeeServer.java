package com.hfm.server;

import com.hfm.entity.Employee;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 16:58
 * @Description
 * @date 2020/10/4
 */
public interface EmployeeServer {
    Employee findEmployeeById(Integer id);

    Employee findEmployeeByName(String name);

    List<Employee> findAll();

    void update(Employee employee);

    void add(Employee employee);

    void delete(Integer id);

    boolean nameExited(String name);
}
