package com.hfm.server.impl;

import com.hfm.dao.DepartmentDao;
import com.hfm.domain.Department;
import com.hfm.server.DepartmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-17 9:56
 * @Description
 * @date 2020/10/17
 */
@Service(value = "departmentServer")
public class DepartmentServerImpl implements DepartmentServer {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
