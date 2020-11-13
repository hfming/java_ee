package com.hfm.aopann;

import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:13
 * @Description
 * @date 2020/9/29
 */
@Component(value = "myBookDao")
public interface MyBookDao {
    void add(MyBook myBook);
}
