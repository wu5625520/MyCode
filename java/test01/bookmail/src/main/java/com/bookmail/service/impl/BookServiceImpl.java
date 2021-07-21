package com.bookmail.service.impl;

import com.bookmail.bean.Book;
import com.bookmail.bean.Page;
import com.bookmail.dao.BookDao;
import com.bookmail.dao.impl.BookDaoImpl;
import com.bookmail.service.BookService;

import java.util.List;

/**
 * @author wxy
 * @title: BookServiceImpl
 * @description: TODO
 * @date 2021/7/1914:54
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> getAllBook() {

        return bookDao.queryAll();
    }

    @Override
    public Integer deleteById(int id) {
        return bookDao.deleteById(id);
    }

    @Override
    public Integer updateById(Book book, Integer id) {
        if(id == 0){
            return bookDao.addBook(book);
        }
        else {
            return bookDao.updateById(book, id);
        }
    }
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/20 19:27
    　　*/
    public Book getBookById(Integer id){
        return bookDao.queryById(id);
    }

    @Override
    public Page<Book> getPage(Integer currPage, Integer pageSize) {
        Integer totalNum = bookDao.getTotalNum();
        List<Book> booksByPage = bookDao.getBooksByPage(currPage, pageSize);
        Integer totalPage = totalNum / pageSize + (totalNum % pageSize == 0 ? 0 : 1);

        return new Page<Book>(totalPage, totalNum, currPage, booksByPage, pageSize);
    }

}
