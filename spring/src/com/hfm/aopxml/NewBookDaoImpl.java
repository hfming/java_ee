package com.hfm.aopxml;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:29
 * @Description
 * @date 2020/9/29
 */
public class NewBookDaoImpl implements NewBookDao {
    @Override
    public void add(NewBook newBook) {
        System.out.println("添加书籍:" + newBook.getBookName());
    }
}
