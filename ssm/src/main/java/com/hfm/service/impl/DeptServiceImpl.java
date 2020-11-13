package com.hfm.service.impl;

import com.hfm.domain.Dept;
import com.hfm.mapper.DeptMapper;
import com.hfm.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author hfm
 * @since 2020-10-31
 */
@Service(value = "deptService")
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
