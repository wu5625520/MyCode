package com.bookmail.controller;

import com.bookmail.bean.Cart;
import com.bookmail.bean.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wxy
 * @title: CartControl
 * @description: TODO
 * @date 2021/7/2517:29
 */
public class CartControl extends BaseControl{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        System.out.println("收到addItem请求,id = " + req.getParameter("id"));

//        System.out.println("收到的页面地址referer是：" + req.getHeader("Referer"));
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        CartItem cartItem = new CartItem(id, name, 1, price, price);
        Cart cart = null;
        if(req.getSession().getAttribute("cart") == null){
            cart = new Cart();
        }
        else{
            cart = (Cart) req.getSession().getAttribute("cart");
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",name);
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect(req.getHeader("Referer"));  //referer是收到的页面地址

        //点击加入购物车的时候，已经是重定向了，request域已经变了
//        resp.setStatus(307);
//        resp.setHeader("Location","http://localhost:8080/bookmail/pages/index.jsp");
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItemById(id);
        resp.sendRedirect("http://localhost:8080/bookmail/pages/cart/cart.jsp");
    }

    protected void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("cart");
        resp.sendRedirect("http://localhost:8080/bookmail/pages/cart/cart.jsp");
    }

    /**
    　　* @description:未解决问题
        1、count输入框只有第一个能改？
            在input中写函数，能取到value值吗？
        2、添加进购物车之后怎么回到原页面？
    　　* @author wxy
    　　* @date 2021/7/25 21:59
    　　*/
    protected void changeCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = Integer.parseInt(req.getParameter("count"));
        int id = Integer.parseInt(req.getParameter("id"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.changeCountByid(count, id);
        resp.sendRedirect("http://localhost:8080/bookmail/pages/cart/cart.jsp");
    }
}
