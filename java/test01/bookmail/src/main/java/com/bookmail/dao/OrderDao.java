package com.bookmail.dao;

import com.bookmail.bean.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderDao
 * @description: TODO
 * @date 2021/7/2619:27
 */
public interface OrderDao {
    int addOrder(Orders order) throws SQLException;

    ArrayList<Orders> queryOrdersByUsername(String username) throws SQLException;
}
