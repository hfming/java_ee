package com.hfm.server.impl;

import com.hfm.dao.EmployeeDao;
import com.hfm.entity.Employee;
import com.hfm.server.EmployeeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 16:59
 * @Description
 * @date 2020/10/4
 */
@Service(value = "employeeServer")
public class EmployeeServerImpl implements EmployeeServer {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Employee findEmployeeById(Integer id) {
        return employeeDao.findEmployeeById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Employee findEmployeeByName(String name) {
        return employeeDao.findEmployeeByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean nameExited(String name) {
        return employeeDao.nameExisted(name);
    }

}
