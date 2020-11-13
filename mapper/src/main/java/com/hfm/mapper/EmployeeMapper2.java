package com.hfm.mapper;

import com.hfm.domain.Employee;
import com.hfm.myprovider.MyBatchUpdateMapper;
import com.hfm.mymapper.MyMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 10:34
 * @Description mapper 接口需要继承通用mapper 的泛型接口
 * @date 2020/10/27
 */
@Repository(value = "employeeMapper2")
@CacheNamespace // 使用 二级缓存
public interface EmployeeMapper2 extends MyMapper<Employee>  {
}
