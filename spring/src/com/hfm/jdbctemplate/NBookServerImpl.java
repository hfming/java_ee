package com.hfm.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 19:53
 * @Description NBookServer 接口实现类
 * @date 2020/9/29
 */
@Service(value = "nBookServerImpl")
public class NBookServerImpl implements NbookServer {
    @Autowired
    private NBookDao nBookDao;

    @Override
    public void addBook(NBook nBook) {
        nBookDao.addBook(nBook);
    }

    @Override
    public void updateBook(NBook nBook) {
        nBookDao.updateBook(nBook);
    }

    @Override
    public void deleteBook(Integer bookId) {
        nBookDao.deleteBook(bookId);
    }

    @Override
    public List<NBook> nBooks() {
        return nBookDao.nBooks();
    }

    @Override
    public NBook findNBookById(Integer bookId) {
        return nBookDao.findNBookById(bookId);
    }

    @Override
    public NBook findNBookByName(String bookName) {
        return nBookDao.findNBookByName(bookName);
    }

    @Override
    public Integer count() {
        return nBookDao.count();
    }

    @Override
    public void banthAdd(List<NBook> nBooks) {
        nBookDao.banthAdd(nBooks);
    }
}
