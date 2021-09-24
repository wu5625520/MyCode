package com.service;


import com.bean.Book;
import com.bean.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wxy
 * @title: BookService
 * @description: TODO
 * @date 2021/7/1914:52
 */

@Service
public interface BookService {
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/19 14:52
    　　*/
    public List<Book> getAllBook();
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/19 15:54
    　　*/
    public Integer deleteById(int id);
    /**
    　　* @description: 根据传进来的book，有id的调用update，没有id的调用insert
    　　* @author wxy
    　　* @date 2021/7/19 16:44
    　　*/
    public Integer updateById(Book book, Integer id);
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/20 19:27
    　　*/
    public Book getBookById(Integer id);
    /**
    　　* @description: 设置Page的总页数，总记录，当前页Items；返回设置好的page
    　　* @author wxy
    　　* @date 2021/7/21 15:23
    　　*/
    public Page<Book> getPage(Integer currPage, Integer pageSize);
    /**
    　　* @description: 通过传入的page，返回页码显示的开始页和结束页
    　　* @author wxy
    　　* @date 2021/7/22 14:16
    　　*/
    public List<Integer> getPageBeginAndEnd(Page page);


    Page<Book> getPageByPrice(Float minPrice, Float maxPrice, int currPageNum, Integer defaultPageSize);

    /**
    　　* @description: SSM整合:page靠插件实现，传入价格区间即可
    　　* @author wxy
    　　* @date 2021/8/16 16:01
    　　*/
    List<Book> getBooksByPrice(int minPrice, int maxPrice);
}
