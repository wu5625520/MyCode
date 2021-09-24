package com.Dao;


import com.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
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
    public Book queryById(Integer id) throws SQLException;
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/19 14:38
    　　*/
    public List<Book> queryAll() throws SQLException;
    /**
    　　* @description: 返回影响的行数？
    　　* @author wxy
    　　* @date 2021/7/19 14:40
    　　*/
    public Integer addBook(Book book) throws SQLException;
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/19 14:41
    　　*/
    public Integer deleteById(int id) throws SQLException;
    /**
　　* @description: 根据传进来的book，更新指定id的数据
                    20210810：修改，把传进来的book id设置为要修改的，就可以只传一个book参数了
　　* @author wxy
　　* @date 2021/7/19 16:42
　　*/
//    public Integer updateById(Book book, Integer id) throws SQLException;
    public Integer updateById(Book book) throws SQLException;
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/21 15:13
    　　*/
    public Integer getTotalNum() throws SQLException;
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/21 15:15
    　　*/
    public List<Book> getBooksByPage(Integer currPage, Integer pageSize) throws SQLException;

    Integer getTotalNumByPrice(Float minPrice, Float maxPrice) throws SQLException;

    List<Book> getBooksByPageAndPrice(Float minPrice, Float maxPrice, int currPageNum, Integer pageSize) throws SQLException;

    List<Book> getBooksByPrice(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);
}
