package com.hfm.diann;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-27 16:01
 * @Description 属性注入
 * @date 2020/9/27
 */
@Component(value = "book")
public class Book {
    private Integer id;
    @Value(value = "时间简史")
    private String bname;

    public Book() {
    }

    public Book(Integer id, String bname) {
        this.id = id;
        this.bname = bname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", bname='").append(bname).append('\'');
        sb.append('}');
        return sb.toString();
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

    public Integer getId() {
        return id;
    }

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
