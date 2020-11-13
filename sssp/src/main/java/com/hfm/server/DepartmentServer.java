package com.hfm.server;

import com.hfm.domain.Department;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:41
 * @Description
 * @date 2020/10/16
 */
public interface DepartmentServer {
    List<Department> findAll();
}
