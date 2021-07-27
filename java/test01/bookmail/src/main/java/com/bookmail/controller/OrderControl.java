package com.bookmail.controller;

import com.bookmail.bean.Cart;
import com.bookmail.bean.OrderDetails;
import com.bookmail.bean.Orders;
import com.bookmail.dao.BookDao;
import com.bookmail.dao.impl.BookDaoImpl;
import com.bookmail.service.OrderService;
import com.bookmail.service.impl.OrderServiceIml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author wxy
 * @title: OrderControl
 * @description: TODO
 * @date 2021/7/2619:10
 */
public class OrderControl extends BaseControl{
    BookDao bookDao = new BookDaoImpl();

    OrderService orderService = new OrderServiceIml();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void creatOrder(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = (String) req.getSession().getAttribute("username");
        String orderid = username + new java.util.Date().getTime();
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Orders order = new Orders(orderid, new Timestamp(System.currentTimeMillis()), 0, username, cart.getSumPrice());

        orderService.creatOrderAndOrderDetails(order, cart ,orderid);
//        orderService.creatOrderDetails(cart, orderid);//在里面更新库存和销量


        //清空购物车
        req.getSession().removeAttribute("cart");
        req.getSession().setAttribute("orderid", orderid);
        resp.sendRedirect("http://localhost:8080/bookmail/pages/cart/checkout.jsp");
    }

    protected void clientOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        ArrayList<Orders> orders = orderService.getOrdersByUsername(username);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void clientOrdersDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderid = req.getParameter("orderid");
        ArrayList<OrderDetails> orderDetails = orderService.getOrderDetailsByOrderId(orderid);
        req.getSession().setAttribute("orderDetails", orderDetails);
        resp.sendRedirect("http://localhost:8080/bookmail/pages/order/order_details.jsp");
    }
}
