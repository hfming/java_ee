package com.hfm.controller;

import com.hfm.domain.Dept;
import com.hfm.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  前端控制器
 *
 * @author hfm
 * @since 2020-10-31
 */
@Controller
public class DeptController {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有员工数据
     * @return
     */
    @RequestMapping(path = "/depts")
    public @ResponseBody
    List<Dept> findAll(){
        List<Dept> depts = deptMapper.selectList(null);

        return depts;
    }
}

