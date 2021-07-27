package com.bookmail.service.impl;

import com.bookmail.bean.Book;
import com.bookmail.bean.Page;
import com.bookmail.dao.BookDao;
import com.bookmail.dao.impl.BookDaoImpl;
import com.bookmail.service.BookService;

import java.sql.SQLException;
import java.util.ArrayList;
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

        try {
            return bookDao.queryAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteById(int id) {
        try {
            return bookDao.deleteById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateById(Book book, Integer id) {
        if(id == 0){
            try {
                return bookDao.addBook(book);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            try {
                return bookDao.updateById(book, id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/20 19:27
    　　*/
    public Book getBookById(Integer id){
        try {
            return bookDao.queryById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Book> getPage(Integer currPage, Integer pageSize) {
        Integer totalNum = null;
        try {
            totalNum = bookDao.getTotalNum();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Book> booksByPage = null;
        try {
            booksByPage = bookDao.getBooksByPage(currPage, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Integer totalPage = totalNum / pageSize + (totalNum % pageSize == 0 ? 0 : 1);

        //数据边界的有效检查；防止直接在地址栏输入页数
        //放在set方法里，更加优雅.但是我直接调用的构造函数？
        if(currPage > totalPage){
            currPage = totalPage;
        }
        if(currPage < 1){
            currPage = 1;
        }

        return new Page<Book>(totalPage, totalNum, currPage, booksByPage, pageSize);
    }

    @Override
    public List<Integer> getPageBeginAndEnd(Page page) {
        //要显示5个连续页码,
        //1、小于等于5页
        int begin = 1;
        int end = page.getTotalPage();
        if(page.getTotalPage() > 5){
            if(page.getCurrPageNum() <= 3){
                end = 5;
            }
            else if(page.getCurrPageNum() >= page.getTotalPage() - 2){
                begin = page.getTotalPage() - 4;
            }
            else{
                begin = page.getCurrPageNum() - 2;
                end = page.getCurrPageNum() + 2;
            }
        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(begin);
        integers.add(end);
        return integers;

    }

    @Override
    public Page<Book> getPageByPrice(Float minPrice, Float maxPrice, int currPageNum, Integer pageSize) {
        Integer totalNum = null;
        try {
            totalNum = bookDao.getTotalNumByPrice(minPrice, maxPrice);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Book> booksByPageAndPrice = null;
        try {
            booksByPageAndPrice = bookDao.getBooksByPageAndPrice(minPrice, maxPrice, currPageNum, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Integer totalPage = totalNum / pageSize + (totalNum % pageSize == 0 ? 0 : 1);

        //数据边界的有效检查；防止直接在地址栏输入页数
        //放在set方法里，更加优雅.但是我直接调用的构造函数？
        if(currPageNum > totalPage){
            currPageNum = totalPage;
        }
        if(currPageNum < 1){
            currPageNum = 1;
        }

        return new Page<Book>(totalPage, totalNum, currPageNum, booksByPageAndPrice, pageSize);
    }

}
