package com.controler;

import com.bean.Book;
import com.bean.Cart;
import com.bean.CartItem;
import com.google.gson.Gson;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxy
 * @title: CartControl
 * @description: TODO
 * @date 2021/8/1920:49
 */
@Controller
@RequestMapping(value = "cartControl/")
public class CartControl {

    @Autowired
    BookService bookService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "book/{id}")
    public Object addItem(ModelAndView modelAndView,
                          HttpSession httpSession,
                                HttpServletResponse resp,
                                @PathVariable("id") Integer id){
        System.out.println("收到添加到购物车请求");
        Book bookById = bookService.getBookById(id);
        CartItem cartItem = new CartItem(id, bookById.getName(), 1, bookById.getPrice(), bookById.getPrice());
        Cart cart = null;
        if(httpSession.getAttribute("cart") == null){
            cart = new Cart();
        }
        else{
            cart = (Cart) httpSession.getAttribute("cart");
        }
        cart.addItem(cartItem);
        Map<String, Object> map = new HashMap<>();
        map.put("sumCount", cart.getSumCount());
        map.put("lastName", bookById.getName());
        httpSession.setAttribute("lastName",bookById.getName());
        httpSession.setAttribute("cart", cart);
        modelAndView.addObject("cart1", cart);
        return map;
    }

    /**
    　　* @description: 如果没有id，直接清空购物车
    　　* @author wxy
    　　* @date 2021/8/20 15:42
    　　*/
    @RequestMapping(method = RequestMethod.DELETE, value = "book/{id}")
    public String deleteItem(HttpSession httpSession,
                             @PathVariable(value = "id", required = false) Integer id){
        if(id == null){
            httpSession.removeAttribute("cart");
        }
        else{
            Cart cart = (Cart) httpSession.getAttribute("cart");
            cart.deleteItemById(id); //没放在session域中，直接重定向了，怎么更新页面的？
            // 答：向域中放值其实放的是地址值，在外面修改了对象，会直接影响域中值
            //request域也一样
        }
        return "redirect:/client/cartPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "book/deleteAll")
    public String freeItem(HttpSession httpSession){
        httpSession.removeAttribute("cart");
        return "redirect:/client/cartPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "changeCount")
    public String changeCount(HttpSession httpSession,
                              @RequestParam("count") Integer count,
                              @RequestParam("id") Integer id){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        cart.changeCountByid(count, id);
        return "redirect:/client/cartPage";
    }
}
