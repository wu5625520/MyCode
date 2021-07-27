package com.bookmail.service.impl;

import com.bookmail.bean.*;
import com.bookmail.dao.BookDao;
import com.bookmail.dao.OrderDao;
import com.bookmail.dao.OrderDetailsDao;
import com.bookmail.dao.impl.BookDaoImpl;
import com.bookmail.dao.impl.OrderDaoIml;
import com.bookmail.dao.impl.OrderDetailsDaoIml;
import com.bookmail.service.OrderService;
import com.bookmail.utils.TransactionUtils;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderServiceIml
 * @description: TODO
 * @date 2021/7/2619:25
 */
public class OrderServiceIml implements OrderService {

    BookDao bookDao = new BookDaoImpl();
    OrderDao orderDao = new OrderDaoIml();
    OrderDetailsDao orderDetailsDao = new OrderDetailsDaoIml();

    @Override
    public void creatOrderAndOrderDetails(Orders order, Cart cart, String orderid) throws Exception{
        //事务用Filter实现

        //1、生成订单
        try {
            if(orderDao.addOrder(order) < 1){
                throw new RuntimeException("生成订单失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
//        int a = 10/0;
        //2、生成订单详情
        ArrayList<CartItem> items = cart.getItems();
        /**
         　　*    private Integer id;
         private String name;
         private Integer count;
         private Float price;
         private Float totalPrice;
         　　*/

        try {
            for(CartItem cartItem : items){
                if(orderDetailsDao.addOrderDetails(cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderid) != 1){
                    throw new RuntimeException("向orderDetails表中插入数据错误");
                }
                //更新库存和销量
                Book book = bookDao.queryById(cartItem.getId());
                book.setSales(book.getSales() + cartItem.getCount());
                book.setStock(book.getStock() - cartItem.getCount());
                bookDao.updateById(book, book.getId());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public ArrayList<Orders> getOrdersByUsername(String username) {
        try {
            return orderDao.queryOrdersByUsername(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getOrderDetailsByOrderId(String orderid) {
        try {
            return orderDetailsDao.queryOrderDetailsByOrderId(orderid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
