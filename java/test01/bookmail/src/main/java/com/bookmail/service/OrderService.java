package com.bookmail.service;

import com.bookmail.bean.Cart;
import com.bookmail.bean.OrderDetails;
import com.bookmail.bean.Orders;

import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderService
 * @description: TODO
 * @date 2021/7/2619:25
 */
public interface OrderService {

    void creatOrderAndOrderDetails(Orders order, Cart cart, String orderid) throws Exception;

    ArrayList<Orders> getOrdersByUsername(String username);

    ArrayList<OrderDetails> getOrderDetailsByOrderId(String orderid);
}
