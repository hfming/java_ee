package com.hfm.jdbctemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 19:49
 * @Description
 * @date 2020/9/29
 */
@Repository(value = "nBookDao")
public interface NBookDao {
    void addBook(NBook nBook);

    void updateBook(NBook nBook);

    void deleteBook(Integer bookId);

    Integer count();

    List<NBook> nBooks();

    NBook findNBookById(Integer bookId);

    NBook findNBookByName(String bookName);

    void banthAdd(List<NBook> nBooks);

    void banthUpdate(List<NBook> nBooks);

    void banthDelete(List<Integer> nBookIds);
}
