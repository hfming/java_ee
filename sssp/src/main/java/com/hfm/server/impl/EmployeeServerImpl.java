package com.hfm.server.impl;

import com.hfm.dao.EmployeeDao;
import com.hfm.domain.Employee;
import com.hfm.server.EmployeeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:43
 * @Description
 * @date 2020/10/16
 */
@Service(value = "employeeServer")
public class EmployeeServerImpl implements EmployeeServer {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true) // 只读型事务
    public Page<Employee> getPage(Integer currentPage, Integer pageSize) {
        // 当前页从 1 开始，但是 PageRequest 从 0 开始
        return employeeDao.findAll(new PageRequest(currentPage - 1, pageSize));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean nameIsExited(String lastName) {
        Employee employee = employeeDao.findByLastName(lastName);
        if (employee == null) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAndUpdate(Employee employee) {
        employee.setCreateTime(new Date());
        employeeDao.saveAndFlush(employee);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(Integer id) {
        return employeeDao.findOne(id);
    }
}
