package com.hfm.dao;

import com.hfm.entity.Department;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 17:01
 * @Description
 * @date 2020/10/4
 */
public interface DepartmentDao {
    List<Department> findAll();

    Department findById(Integer id);

    Department findByName(String name);
}
