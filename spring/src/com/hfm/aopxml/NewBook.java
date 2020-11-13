package com.hfm.aopxml;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:27
 * @Description
 * @date 2020/9/29
 */
public class NewBook {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;

    public NewBook() {
    }

    public NewBook(Integer bookId, String bookName, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewBook{");
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
        NewBook newBook = (NewBook) o;
        return Objects.equals(bookId, newBook.bookId) &&
                Objects.equals(bookName, newBook.bookName) &&
                Objects.equals(bookAuthor, newBook.bookAuthor);
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
