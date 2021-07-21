package com.bookmail.dao.impl;

import com.bookmail.bean.Book;
import com.bookmail.dao.BaseDao;
import com.bookmail.dao.BookDao;

import java.util.List;

/**
 * @author wxy
 * @title: BookDaoImpl
 * @description: TODO
 * @date 2021/7/1914:42
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public Book queryById(Integer id) {
        String sql = "select * from bookmanage where id = ?";

        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryAll() {
        String sql = "select * from bookmanage";

        return queryForList(Book.class, sql);
    }

    @Override
    public Integer addBook(Book book) {
        String sql = "insert into bookmanage(name, price, author, sales, stock, ima_path) values(?, ?, ?, ?, ?, ?)";

        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getPrice(), book.getStock(), book.getIma_path());

    }

    @Override
    public Integer deleteById(int id) {
        String sql = "delete from bookmanage where id = ?";
        return update(sql, id);
    }

    @Override
    public Integer updateById(Book book, Integer id) {
        String sql = "update bookmanage set name = ?, price = ?, author = ?, sales = ?, stock = ? where id = ?";

        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), id);
    }

    @Override
    public Integer getTotalNum() {
        String sql = "select count(*) from bookmanage";
        return (Integer) queryForSingleValue(sql);
    }

    @Override
    public List<Book> getBooksByPage(Integer currPage, Integer pageSize) {
        String sql = "select * from bookmanage limit ?, ?";
        return queryForList(Book.class, sql, (currPage - 1) * pageSize, pageSize);
    }
}
