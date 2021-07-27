package com.bookmail.dao;

import com.bookmail.bean.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderDetailsDao
 * @description: TODO
 * @date 2021/7/2620:17
 */
public interface OrderDetailsDao {
    ArrayList<OrderDetails> queryOrderDetailsByOrderId(String orderid) throws SQLException;

    int addOrderDetails(String name, Integer count, Float price, Float totalPrice, String orderid) throws SQLException;
}
