package com.hfm.server;

import com.hfm.domain.Employee;
import org.springframework.data.domain.Page;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:41
 * @Description
 * @date 2020/10/16
 */
public interface EmployeeServer {
    /**
     * 分页功能
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Employee> getPage(Integer currentPage, Integer pageSize);

    /**
     * 名字是否已经存在
     *
     * @param lastName
     * @return
     */
    boolean nameIsExited(String lastName);

    /**
     * 添加与修改
     *
     * @param employee
     */
    void saveAndUpdate(Employee employee);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 通过 Id 查找用户
     * @param id
     * @return
     */
    Employee findById(Integer id);
}
