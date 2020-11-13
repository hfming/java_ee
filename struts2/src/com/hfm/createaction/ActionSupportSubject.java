package com.hfm.createaction;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 19:27
 * @Description 创建 action 类的第三种方式 继承 ActionSupport 类，可以重写 execute 方法
 * @date 2020/9/22
 */
public class ActionSupportSubject extends ActionSupport {
    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
