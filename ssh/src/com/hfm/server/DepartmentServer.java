package com.hfm.server;

import com.hfm.entity.Department;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 16:59
 * @Description
 * @date 2020/10/4
 */
public interface DepartmentServer {
    List<Department> findAll();

    Department findById(Integer id);

    Department findByName(String name);
}
