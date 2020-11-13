package com.hfm.dao.impl;

import com.hfm.dao.BaseDao;
import com.hfm.dao.DepartmentDao;
import com.hfm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 17:01
 * @Description
 * @date 2020/10/4
 */
@Repository(value = "departmentDao")
public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao {
    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return queryList(getCurrentSession(), hql, null);
    }

    @Override
    public Department findById(Integer id) {
        String hql = "from Department where id = ? ";
        return querySingle(getCurrentSession(), hql, id);
    }

    @Override
    public Department findByName(String name) {
        String hql = "from Department where departmentName = ? ";
        return querySingle(getCurrentSession(), hql, name);
    }
}
