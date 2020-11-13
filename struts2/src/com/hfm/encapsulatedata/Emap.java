package com.hfm.encapsulatedata;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 16:18
 * @Description s数据封装到 map 集合
 * @date 2020/9/23
 */
public class Emap extends ActionSupport {
    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
