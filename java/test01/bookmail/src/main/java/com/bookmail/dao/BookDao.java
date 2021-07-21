package com.bookmail.dao;

import com.bookmail.bean.Book;

import java.util.List;

/**
 * @author wxy
 * @title: BookDao
 * @description: TODO
 * @date 2021/7/1914:35
 */
public interface BookDao {
    /**
    　　* @description:
    　　* @author wxy
    　　* @date 2021/7/19 14:36
    　　*/
    public Book queryById(Integer id);
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/19 14:38
    　　*/
    public List<Book> queryAll();
    /**
    　　* @description: 返回影响的行数？
    　　* @author wxy
    　　* @date 2021/7/19 14:40
    　　*/
    public Integer addBook(Book book);
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/19 14:41
    　　*/
    public Integer deleteById(int id);
    /**
　　* @description: 根据传进来的book，更新指定id的数据
　　* @author wxy
　　* @date 2021/7/19 16:42
　　*/
    public Integer updateById(Book book, Integer id);
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/21 15:13
    　　*/
    public Integer getTotalNum();
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/21 15:15
    　　*/
    public List<Book> getBooksByPage(Integer currPage, Integer pageSize);

}
