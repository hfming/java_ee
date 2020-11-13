package com.hfm.service.impl;

import com.hfm.domain.Emp;
import com.hfm.mapper.EmpMapper;
import com.hfm.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现类
 *
 * @author hfm
 * @since 2020-10-31
 */
@Service(value = "employeeService")
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Emp> findAll(Integer currentPage, Integer pageSize) {
        List<Emp> emps = empMapper.findAll(currentPage, pageSize);

        // 返回分页对象
        return emps;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer saveEmp(Emp emp) {
        return empMapper.saveEmp(emp);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }
}
