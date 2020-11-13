package com.hfm.createaction;

import com.opensymphony.xwork2.Action;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 19:25
 * @Description 创建 action 类的第二种方式 实现 Action 接口，重写 execute 方法
 * @date 2020/9/22
 */
public class ActionImpl implements Action {
    @Override
    public String execute() throws Exception {
        return "success";
    }
}
