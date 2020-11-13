package com.hfm.bean;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-27 16:01
 * @Description
 * @date 2020/9/27
 */
public class Book {
    /**
     * 创建属性
     */
    private Integer id;
    private String bname;

    public Book() {
    }

    /**
     * 有参构造函数方式注入属性
     *
     * @param id
     * @param bname
     */
    public Book(Integer id, String bname) {
        this.id = id;
        this.bname = bname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(bname, book.bname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bname);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", bname='").append(bname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    /**
     * set 方式注入属性
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
