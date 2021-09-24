package com.bookmail.controller;

import com.bookmail.bean.Book;
import com.bookmail.bean.Page;
import com.bookmail.service.BookService;
import com.bookmail.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wxy
 * @title: IndexControl
 * @description: TODO
 * @date 2021/7/2213:49
 */
public class IndexControl extends BaseControl{
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("收到首页get请求"); 直接输入index，没有action
//        req.setCharacterEncoding("UTF-8");  //难道在jsp中写的没有用？还是request改了？应该是request改了，因为前面的域数据这里都没有了
//        // 我们都知道jsp里面request作用域的作用范围是一次请求到响应的过程，而jsp页面提交数据到servlet页面使用的是重定向的方式（看浏览器上的URL地址就知道了）而不是转发的方式
        doPost(req, resp);

    }
    protected void listBookByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currPageNum = 1;
        if(req.getParameter("currPageNum") != null) {
            currPageNum = Integer.parseInt(req.getParameter("currPageNum")) > 0 ? Integer.parseInt(req.getParameter("currPageNum")) : 1;
        }

        Page<Book> page = bookService.getPage(currPageNum, Page.DEFAULT_PAGE_SIZE);
        page.setUrl("http://localhost:8080/SSM/client/bookControl?action=listBookByPage");
        req.setAttribute("page", page);

        List<Integer> pageBeginAndEnd = bookService.getPageBeginAndEnd(page);
        req.setAttribute("begin", pageBeginAndEnd.get(0));
        req.setAttribute("end", pageBeginAndEnd.get(1));

        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

    protected void listBookByPageAndPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float minPrice = 0.0f;
        float maxPrice = Float.MAX_VALUE;
        if(req.getParameter("min") != null){
            minPrice = Float.parseFloat(req.getParameter("min"));
        }
        if(req.getParameter("max") != null){
            maxPrice = Float.parseFloat(req.getParameter("max"));
        }
        int currPageNum = 1;
        if(req.getParameter("currPageNum") != null){
            currPageNum = Integer.parseInt(req.getParameter("currPageNum")) > 0 ? Integer.parseInt(req.getParameter("currPageNum")) : 1;
        }
        Page<Book> page = bookService.getPageByPrice(minPrice, maxPrice, currPageNum, Page.DEFAULT_PAGE_SIZE);
        page.setUrl("http://localhost:8080/SSM/client/bookControl?action=listBookByPageAndPrice&min=" + minPrice +"&max=" + maxPrice);
        req.setAttribute("page", page);
        req.setAttribute("minPrice",minPrice);
        req.setAttribute("maxPrice",maxPrice);
        List<Integer> pageBeginAndEnd = bookService.getPageBeginAndEnd(page);
        req.setAttribute("begin", pageBeginAndEnd.get(0));
        req.setAttribute("end", pageBeginAndEnd.get(1));
        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);

    }

    protected void listBookByPageAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currPageNum = 1;
        if(req.getParameter("currPageNum") != null) {
            currPageNum = Integer.parseInt(req.getParameter("currPageNum"));
        }

        Page<Book> page = bookService.getPage(currPageNum, Page.DEFAULT_PAGE_SIZE);
        page.setUrl("http://localhost:8080/SSM/client/bookControl?action=listBookByPage");
        req.setAttribute("page", page);

        List<Integer> pageBeginAndEnd = bookService.getPageBeginAndEnd(page);
        req.setAttribute("begin", pageBeginAndEnd.get(0));
        req.setAttribute("end", pageBeginAndEnd.get(1));

        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

}
