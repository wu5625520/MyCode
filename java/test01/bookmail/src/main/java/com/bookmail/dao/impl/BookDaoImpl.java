package com.bookmail.dao.impl;

import com.bookmail.bean.Book;
import com.bookmail.dao.BaseDao;
import com.bookmail.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wxy
 * @title: BookDaoImpl
 * @description: TODO
 * @date 2021/7/1914:42
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public Book queryById(Integer id) throws SQLException {
        String sql = "select * from bookmanage where id = ?";

        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryAll() throws SQLException {
        String sql = "select * from bookmanage";

        return queryForList(Book.class, sql);
    }

    @Override
    public Integer addBook(Book book) throws SQLException {
        String sql = "insert into bookmanage(name, price, author, sales, stock, ima_path) values(?, ?, ?, ?, ?, ?)";

        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getPrice(), book.getStock(), book.getIma_path());

    }

    @Override
    public Integer deleteById(int id) throws SQLException {
        String sql = "delete from bookmanage where id = ?";
        return update(sql, id);
    }

    @Override
    public Integer updateById(Book book, Integer id) throws SQLException {
        String sql = "update bookmanage set name = ?, price = ?, author = ?, sales = ?, stock = ? where id = ?";

        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), id);
    }

    @Override
    public Integer getTotalNum() throws SQLException {
        String sql = "select count(*) from bookmanage";
        //ClassCastException:java.lang.Long cannot be cast to java.lang.Integer
        //queryForSingleValue得到的是Long.Integer属于不可更改类型，而且Long和Integer没有任何继承关系；不能强转
        //java.lang.Number是Integer,Long的父类.
        Number num = (Number) queryForSingleValue(sql);
        return num.intValue();
    }

    @Override
    public List<Book> getBooksByPage(Integer currPage, Integer pageSize) throws SQLException {
        String sql = "select * from bookmanage limit ?, ?";
        return queryForList(Book.class, sql, (currPage - 1) * pageSize, pageSize);
    }

    @Override
    public Integer getTotalNumByPrice(Float minPrice, Float maxPrice) throws SQLException {
        String sql = "select count(*) from bookmanage where price between ? and ?";
        Number num = (Number) queryForSingleValue(sql, minPrice, maxPrice);
        return num.intValue();
    }

    @Override
    public List<Book> getBooksByPageAndPrice(Float minPrice, Float maxPrice, int currPageNum, Integer pageSize) throws SQLException {
        String sql = "select * from bookmanage where price between ? and ? limit ?, ?";
        return  queryForList(Book.class, sql,minPrice, maxPrice, (currPageNum - 1) * pageSize, pageSize);
    }
}
