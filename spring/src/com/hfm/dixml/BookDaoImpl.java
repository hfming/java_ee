package com.hfm.dixml;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 20:40
 * @Description
 * @date 2020/10/1
 */
public class BookDaoImpl implements BookDao {
    @Override
    public void addBook(Book book) {
        System.out.println("Dao 层");
        System.out.println("添加书籍:" + book.getBname());
    }
}
