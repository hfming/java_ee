package com.hfm.aopann;

import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:14
 * @Description
 * @date 2020/9/29
 */
@Component(value = "myBookDaoImpl")
public class MyBookDaoImpl implements MyBookDao {
    @Override
    public void add(MyBook myBook) {
        System.out.println("添加书籍:"+myBook.getBookName());
    }
}
