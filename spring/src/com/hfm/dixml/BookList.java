package com.hfm.dixml;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 11:56
 * @Description list , set  map 集合类型属性注入
 * @date 2020/9/28
 */
public class BookList {
    /**
     * List 集合
     */
    private List<Book> bookList;
    /**
     * set 集合
     */
    private Set<Book> bookSet;
    /**
     * map 集合
     */
    private Map<Integer, Book> bookMap;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<Integer, Book> bookMap) {
        this.bookMap = bookMap;
    }
}
