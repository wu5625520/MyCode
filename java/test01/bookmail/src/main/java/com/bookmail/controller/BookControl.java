package com.bookmail.controller;

import com.bookmail.bean.Book;
import com.bookmail.bean.Page;
import com.bookmail.service.impl.BookServiceImpl;
import com.bookmail.utils.ToBeanUtils;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wxy
 * @title: BookControl
 * @description: TODO
 * @date 2021/7/1915:38
 */
public class BookControl extends BaseControl{
    BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    /**
    　　* @description: 根据传过来的id删除book
    　　* @author wxy
    　　* @date 2021/7/19 15:51
    　　*/
    protected void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(bookService.deleteById(id) > 0){
            System.out.println("删除成功");    //怎么提示前台？
        }
        else{
            System.out.println("删除失败");
        }
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
//        resp.sendRedirect("/bookmail/manager/bookControl?action=listBook");  //显示全部图书
        int currPage = Integer.parseInt(req.getParameter("currPageNum"));
        resp.sendRedirect("/bookmail/manager/bookControl?action=listBookByPage&currPageNum=" + currPage);//重定向的/表示到端口号,避免重复提交
    }
    /**
    　　* @description: 根据id进行更新数据库,如果id为0，则插入，否则修改
    　　* @author wxy
    　　* @date 2021/7/19 16:34
    　　*/
    protected void editBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = ToBeanUtils.paramToBean(req.getParameterMap(), new Book());
//        System.out.println("收到的name参数的值是" + new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
        if(bookService.updateById(book, book.getId()) > 0){
            System.out.println("更新成功");
        }
        else{
            System.out.println("更新失败");
        }
        Page<Book> page = bookService.getPage(1, Page.DEFAULT_PAGE_SIZE);
        //id = 0表示是添加，直接到添加后的最后一页；否则回到原来修改的页数
        int currPage = book.getId() == 0 ? page.getTotalPage() : Integer.parseInt(req.getParameter("currPageNum"));
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        resp.sendRedirect("/bookmail/manager/bookControl?action=listBookByPage&currPageNum=" + currPage);//重定向的/表示到端口号
    }
    /**
    　　* @description: TODO
    　　* @author wxy
    　　* @date 2021/7/20 14:00
    　　*/
    protected void listBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> allBook = bookService.getAllBook();
        req.setAttribute("books", allBook);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bookService.getBookById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);
        Integer currPageNum = Integer.parseInt(req.getParameter("currPageNum"));
        req.setAttribute("currPageNum", currPageNum);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    public void listBookByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currPageNum = 1;
        if(req.getParameter("currPageNum") != null) {
            currPageNum = Integer.parseInt(req.getParameter("currPageNum")) > 0 ? Integer.parseInt(req.getParameter("currPageNum")) : 1;
        }

        Page<Book> page = bookService.getPage(currPageNum, Page.DEFAULT_PAGE_SIZE);
        page.setUrl("http://localhost:8080/bookmail/manager/bookControl?action=listBookByPage");
        req.setAttribute("page", page);
        List<Integer> pageBeginAndEnd = bookService.getPageBeginAndEnd(page);
        req.setAttribute("begin", pageBeginAndEnd.get(0));
        req.setAttribute("end", pageBeginAndEnd.get(1));

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
    　　* @description: 这个跟上面listBookByPage代码差不多，怎么整合？
       ---直接删掉，不用了
    　　* @author wxy
    　　* @date 2021/7/21 16:47
    　　*/
    @Deprecated
    protected void ListBookByToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("toPageNum"));
        Integer toPageNum = Integer.parseInt(req.getParameter("toPageNum"));
        Page<Book> page = bookService.getPage(toPageNum, Page.DEFAULT_PAGE_SIZE);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
