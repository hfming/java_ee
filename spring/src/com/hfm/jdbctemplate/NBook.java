package com.hfm.jdbctemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 19:47
 * @Description
 * @date 2020/9/29
 */
@Component(value = "nBook")
public class NBook {
    private Integer bookId;
    @Value(value = "时间简史")
    private String bookName;
    @Value(value = "霍夫曼")
    private String bookAuthor;

    public NBook() {
    }

    public NBook(Integer bookId, String bookName, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NBook{");
        sb.append("bookId=").append(bookId);
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", bookAuthor='").append(bookAuthor).append('\'');
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
        NBook nBook = (NBook) o;
        return Objects.equals(bookId, nBook.bookId) &&
                Objects.equals(bookName, nBook.bookName) &&
                Objects.equals(bookAuthor, nBook.bookAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, bookAuthor);
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
