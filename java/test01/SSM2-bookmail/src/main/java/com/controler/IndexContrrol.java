package com.controler;

import com.bean.Book;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

/**
 * @author wxy
 * @title: IndexContrrol
 * @description: TODO
 * @date 2021/8/1015:40
 */
@Controller
public class IndexContrrol {

    @Autowired
    BookService bookService;

    //用REST风格做查询
    @RequestMapping(method = RequestMethod.GET, value = "client/listBookByPage")
    public ModelAndView test(ModelAndView modelAndView,
                       @RequestParam(value = "pn", defaultValue = "1") String pn,
                       @RequestParam(value = "minPrice",defaultValue = "-1") String minPrice,
                       @RequestParam(value = "maxPrice", defaultValue = "2147483647") String maxPrice){
        //用插件做分页
        int pageNum = Integer.parseInt(pn);
        int minPriceNum = Integer.parseInt(minPrice);
        int maxPriceNum = Integer.parseInt(maxPrice);
        PageHelper.startPage(pageNum, com.bean.Page.DEFAULT_PAGE_SIZE);//会自动注入plugin interceptor，不能再在mybatis里配置
        List<Book> allBook = bookService.getBooksByPrice(minPriceNum, maxPriceNum);
        PageInfo<Book> bookPageInfo = new PageInfo<>(allBook, 5);
        modelAndView.addObject("pageInfo",bookPageInfo);
        modelAndView.addObject("booksByPage",allBook);
        if(minPriceNum != -1)
            modelAndView.addObject("minPrice",minPriceNum);
        if(maxPriceNum != 2147483647)
            modelAndView.addObject("maxPrice",maxPriceNum);
        modelAndView.addObject("pageUrl","http://localhost:8080/SSM/client/listBookByPage?minPrice=" +minPrice + "&maxPrice=" + maxPrice + "&pn=");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
