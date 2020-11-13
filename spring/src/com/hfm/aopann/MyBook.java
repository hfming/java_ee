package com.hfm.aopann;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:14
 * @Description
 * @date 2020/9/29
 */
@Component(value = "myBook")
public class MyBook {
    private Integer booId;
    private String bookName;
    private String bookAuhtor;

    public MyBook() {
    }

    public MyBook(Integer booId, String bookName, String bookAuhtor) {
        this.booId = booId;
        this.bookName = bookName;
        this.bookAuhtor = bookAuhtor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyBook{");
        sb.append("booId=").append(booId);
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", bookAuhtor='").append(bookAuhtor).append('\'');
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
        MyBook myBook = (MyBook) o;
        return Objects.equals(booId, myBook.booId) &&
                Objects.equals(bookName, myBook.bookName) &&
                Objects.equals(bookAuhtor, myBook.bookAuhtor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booId, bookName, bookAuhtor);
    }

    public Integer getBooId() {
        return booId;
    }

    public void setBooId(Integer booId) {
        this.booId = booId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuhtor() {
        return bookAuhtor;
    }

    public void setBookAuhtor(String bookAuhtor) {
        this.bookAuhtor = bookAuhtor;
    }
}
