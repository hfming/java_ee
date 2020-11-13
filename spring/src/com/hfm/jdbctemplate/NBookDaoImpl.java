package com.hfm.jdbctemplate;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 19:51
 * @Description
 * @date 2020/9/29
 */
@Repository(value = "nBookDaoImpl")
public class NBookDaoImpl extends BaseDao<NBook> implements NBookDao {
    @Override
    public void addBook(NBook nBook) {
        // 如果整合 Hibernate 框架使用 HQL 查询语句
        String sql = "insert into tab_nbook set bookName =? , bookAuthor =?";
        change(sql, nBook.getBookName(), nBook.getBookAuthor());
    }

    @Override
    public void updateBook(NBook nBook) {
        String sql = "update tab_nbook set bookName = ? ,  bookAuthor =? where bookid =?";
        change(sql, nBook.getBookName(), nBook.getBookAuthor(), nBook.getBookId());
    }

    @Override
    public void deleteBook(Integer bookId) {
        String sql = "delete from tab_nbook where bookid = ?";
        change(sql, bookId);
    }

    @Override
    public Integer count() {
        String sql = "select count(1) from  tab_nbook";
        Long value = (Long) getValue(sql);
        return value.intValue();
    }

    @Override
    public List<NBook> nBooks() {
        String sql = "select * from tab_nbook";
        return queryTable(sql);
    }

    @Override
    public NBook findNBookById(Integer bookId) {
        String sql = "select * from  tab_nbook where  bookid =?";
        return querySingle(sql, bookId);
    }

    @Override
    public NBook findNBookByName(String bookName) {
        String sql = "select * from tab_nbook where bookname = ? ";
        return querySingle(sql, bookName);
    }

    @Override
    public void banthAdd(List<NBook> nBooks) {
        String sql = "insert into tab_nbook set bookName =? , bookAuthor =?";
        // 创建参数集合
        List<Object[]> batchArgs = new ArrayList<Object[]>();

        for (NBook nBook : nBooks) {
            Object[] objects = new Object[]{nBook.getBookId(),nBook.getBookName(),nBook.getBookAuthor()};
            batchArgs.add(objects);
        }

        // 批量添加
        banth(sql,batchArgs);
    }

    @Override
    public void banthUpdate(List<NBook> nBooks) {
        String sql = "update tab_nbook set bookName = ? ,  bookAuthor =? where bookid =?";
        // 创建参数集合
        List<Object[]> batchArgs = new ArrayList<Object[]>();

        for (NBook nBook : nBooks) {
            Object[] objects = new Object[]{nBook.getBookId(),nBook.getBookName(),nBook.getBookAuthor()};
            batchArgs.add(objects);
        }

        // 批量修改
        banth(sql,batchArgs);
    }

    @Override
    public void banthDelete(List<Integer> nBookIds) {
        String sql = "delete from tab_nbook where bookid = ?";

        List<Object[]> batchArgs = new ArrayList<Object[]>();

        for (Integer bookId : nBookIds) {
            Object[] objects = new Object[]{bookId};
            batchArgs.add(objects);
        }

        // 批量删除
        banth(sql,batchArgs);
    }
}
