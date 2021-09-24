package com.controler;

import com.bean.Book;
import com.bean.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * @author wxy
 * @title: BookControl
 * @description: TODO
 * @date 2021/8/917:43
 */
@Controller
@RequestMapping(value = "manager/bookControl")
public class BookControl {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/listBooks")
    public ModelAndView listBookByPage(ModelAndView modelAndView,
                                       @RequestParam(value = "pn", defaultValue = "1") String page) {
        int pageNum = Integer.parseInt(page);
        PageHelper.startPage(pageNum, Page.DEFAULT_PAGE_SIZE);
        List<Book> booksByPage = bookService.getAllBook();
        PageInfo<Book> booksPageInfo = new PageInfo<>(booksByPage, 5);
        modelAndView.addObject("pageUrl","http://localhost:8080/SSM/manager/bookControl/listBooks?pn=");
        modelAndView.addObject("booksByPage", booksByPage);
        modelAndView.addObject("pageInfo",booksPageInfo);
        modelAndView.setViewName("manager/book_manager");
        return modelAndView;
    }

    /**
    　　* @description: GET代表查询获取
    　　* @author wxy
    　　* @date 2021/8/19 14:51
    　　*/
    @RequestMapping(method = RequestMethod.GET, value = "book/{id}")
    public ModelAndView bookGet(@PathVariable(value = "id",required = false) Integer id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pageNum,
                             ModelAndView modelAndView){
        modelAndView.addObject("pn",pageNum);
        modelAndView.setViewName("manager/book_edit");
        if(id == 0){ //添加图书
            modelAndView.setViewName("manager/book_edit");
        }
        else{
            Book bookById = bookService.getBookById(id);
            modelAndView.addObject("book", bookById);
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/book/{id}")
    public String bookUpdate(ModelAndView modelAndView,
                             Book book,
                             @RequestParam("pn") Integer pageNum,
                             @PathVariable("id") Integer id){
        if(bookService.updateById(book, id) > 0){
            System.out.println("更新成功");
        }
        else{
            System.out.println("更新失败");
        }
        return "redirect:/manager/bookControl/listBooks?pn=" + pageNum;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/book/{id}")
    public String bookDelete(@PathVariable("id") Integer id,
                             @RequestParam("pn") Integer pageNum){
        if(bookService.deleteById(id) > 0){
            System.out.println("删除成功");    //怎么提示前台？
        }
        else{
            System.out.println("删除失败");
        }
        return "redirect:/manager/bookControl/listBooks?pn=" + pageNum;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book/")
    public String bookAdd(Book book){
        if(bookService.updateById(book, 0) > 0){
            System.out.println("添加成功");
        }
        else{
            System.out.println("添加失败");
        }
        //这里只是为了得到总页码，查询全部书籍信息是不是效率太低了？
        PageHelper.startPage(1, Page.DEFAULT_PAGE_SIZE);
        List<Book> booksByPage = bookService.getAllBook();
        PageInfo<Book> booksPageInfo = new PageInfo<>(booksByPage, 5);
        return "redirect:/manager/bookControl/listBooks?pn=" + booksPageInfo.getPages();
    }
}
