package com.hfm.dao;

import com.hfm.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:38
 * @Description
 * @date 2020/10/16
 */
public interface DepartmentDao extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
}
