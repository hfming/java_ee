package com.hfm.dao.impl;

import com.hfm.dao.BaseDao;
import com.hfm.dao.EmployeeDao;
import com.hfm.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 17:01
 * @Description
 * @date 2020/10/4
 */
@Repository(value = "employeeDao")
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    @Override
    public Employee findEmployeeById(Integer id) {
        String hql = "from Employee where id = ?1";
        return querySingle(getCurrentSession(), hql, id);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        String hql = "from Employee where employeeName = ?1";
        return querySingle(getCurrentSession(), hql, name);
    }

    @Override
    public List<Employee> findAll() {
        String hql = "from Employee as e LEFT OUTER JOIN FETCH e.department";
        return queryList(getCurrentSession(), hql, null);
    }

    @Override
    public void update(Employee employee) {
        saveOrUpdate(getCurrentSession(), employee);
    }

    @Override
    public void add(Employee employee) {
        saveOrUpdate(getCurrentSession(), employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            delete(getCurrentSession(), employee);
        }
    }

    @Override
    public boolean nameExisted(String name) {
        String hql = "from Employee where lastName =?1";
        Employee employee = querySingle(getCurrentSession(), hql, name);

        if (employee == null) {
            return false;
        }
        return true;
    }
}
