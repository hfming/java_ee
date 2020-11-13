package com.hfm.server.impl;

import com.hfm.dao.DepartmentDao;
import com.hfm.entity.Department;
import com.hfm.server.DepartmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 17:00
 * @Description
 * @date 2020/10/4
 */
@Service(value = "departmentServer")
public class DepartmentServerImpl implements DepartmentServer {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly=true)
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly=true)
    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly=true)
    public Department findByName(String name) {
        return departmentDao.findByName(name);
    }
}
