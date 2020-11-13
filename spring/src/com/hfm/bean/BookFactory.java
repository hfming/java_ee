package com.hfm.bean;

import com.hfm.dixml.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 12:17
 * @Description
 * @date 2020/9/28
 */
public class BookFactory implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        return new Book(1,"时间简史");
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
