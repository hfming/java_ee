package com.hfm.dixml;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-27 18:51
 * @Description 对象数组, list 集合,Set 集合,Map 集合 类型属性的注入
 * @date 2020/9/27
 */
public class BookCompositeProperty {
    /**
     * String 数组类型属性
     */
    private String[] courses;
    /**
     * 对象数组
     */
    private Book[] books;
    /**
     * String list集合类型属性
     */
    private List<String> strings;
    /**
     * 对象集合
     */
    private List<Book> bookList;
    /**
     * String map集合类型属性
     */
    private Map<String, String> maps;
    /**
     * 对象 map 集合属性
     */
    private Map<Integer, Book> bookMap;
    /**
     * String set集合类型属性
     */
    private Set<String> sets;
    /**
     * 对象 Set 集合
     */
    private Set<Book> bookSet;

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<Integer, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
