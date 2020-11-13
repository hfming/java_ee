package com.hfm.mapper;

import com.hfm.domain.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author hfm
 * @since 2020-10-31
 */
public interface EmpMapper extends BaseMapper<Emp> {
    /**
     * 查询所有
     *
     * @return
     */
    List<Emp> findAll(Integer currenct, Integer pageSize);

    /**
     * 保存用户
     * @param emp
     * @return
     */
    Integer saveEmp(Emp emp);

    /**
     * 更新用户
     * @param emp
     */
    void updateEmp(Emp emp);
}
