package com.hfm.diann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 20:00
 * @Description 实际上集合类型属性只能使用 xml 方式注入
 * @date 2020/9/28
 */
@Component(value = "bookList")
public class BookList {
    /**
     * 对象
     */
    @Autowired
    private Book book;
    /**
     * 对象数组
     */
    @Autowired
    private Book[] books;
    /**
     * 对象集合
     */
    @Autowired
    private List<Book> bookList;
    /**
     * book Set 集合
     */
    @Autowired
    private Set<Book> bookSet;
    /**
     * 对象 Map
     */
    @Autowired
    private Map<String, Book> bookMap;

    @Value(value = "测试")
    private String string;
    /**
     * String 数组
     */
    private String[] strings;
    /**
     * String list 集合
     */
    private List<String> stringList;
    /**
     * String set 集合
     */
    private Set<String> stringSet;
    /**
     * String map
     */
    private Map<String, String> stringMap;

    public Book getBook() {
        return book;
    }

        public String[] getStrings() {
        return strings;
    }

    public Book[] getBooks() {
        return books;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public String getString() {
        return string;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public Map<String, Book> getBookMap() {
        return bookMap;
    }
}
