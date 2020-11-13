package com.hfm.jdbctemplate;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 19:52
 * @Description NBookSever 接口 server 业务层
 * @date 2020/9/29
 */
@Service(value = "nBookServer")
public interface NbookServer {
    void addBook(NBook nBook);

    void updateBook(NBook nBook);

    void deleteBook(Integer bookId);

    List<NBook> nBooks();

    NBook findNBookById(Integer bookId);

    NBook findNBookByName(String bookName);

    Integer count();

    void banthAdd(List<NBook> nBooks);
}
