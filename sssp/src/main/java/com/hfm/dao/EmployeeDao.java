package com.hfm.dao;

import com.hfm.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:38
 * @Description
 * @date 2020/10/16
 */
public interface EmployeeDao extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    /**
     * 通过 名称查询是否存在用户
     * @param lastName
     * @return
     */
    Employee findByLastName(String lastName);
}
