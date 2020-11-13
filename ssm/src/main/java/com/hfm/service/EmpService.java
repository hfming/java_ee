package com.hfm.service;

import com.hfm.domain.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 服务类
 *
 * @author hfm
 * @since 2020-10-31
 */
public interface EmpService extends IService<Emp> {
    /**
     * 分页查询所有数据
     *
     * @param currentPage 当前页
     * @param pageSize    每页记录数
     * @return
     */
    List<Emp> findAll(Integer currentPage, Integer pageSize);

    /**
     * 保存用户
     *
     * @param emp
     * @return
     */
    Integer saveEmp(Emp emp);

    /**
     * 更新用户
     *
     * @param emp
     */
    void updateEmp(Emp emp);
}
