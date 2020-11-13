package com.hfm.mapper;

import com.hfm.domain.Employee;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 10:34
 * @Description mapper 接口需要继承通用mapper 的泛型接口
 * @date 2020/10/27
 */
@Repository(value = "employeeMapper")
public interface EmployeeMapper extends Mapper<Employee> {

}
