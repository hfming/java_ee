package com.hfm.service.impl;

import com.hfm.domain.Employee;
import com.hfm.mapper.EmployeeMapper;
import com.hfm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 10:37
 * @Description
 * @date 2020/10/27
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public Employee findById(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }
}
