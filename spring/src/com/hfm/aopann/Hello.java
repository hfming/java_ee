package com.hfm.aopann;

import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 15:42
 * @Description
 * @date 2020/9/29
 */
@Component(value = "hello")
public interface Hello {
    void say();
}
