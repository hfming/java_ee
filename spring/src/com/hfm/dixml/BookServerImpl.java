package com.hfm.dixml;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 20:42
 * @Description
 * @date 2020/10/1
 */
public class BookServerImpl implements BookServer {
    /**
     * 在 Server 中用到了 dao
     */
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
        System.out.println("Server 层");
        bookDao.addBook(book);
    }

    /**
     * set 方法 注入属性
     *
     * @param bookDao
     */
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
