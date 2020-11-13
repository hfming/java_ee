package com.hfm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hfm.domain.Employee;


/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 19:59
 * @Description mapper 接口需要继承 BaseMapper 泛型接口，传入泛型类
 * @date 2020/10/28
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 自定义全局操作，添加crud 方法
     */
    void deleteAll();
}
