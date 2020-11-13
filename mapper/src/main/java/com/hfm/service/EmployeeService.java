package com.hfm.service;

import com.hfm.domain.Employee;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 10:37
 * @Description
 * @date 2020/10/27
 */
public interface EmployeeService {
    /**
     * 通过 id 查找数据
     *
     * @param id
     * @return
     */
    Employee findById(Integer id);
}
