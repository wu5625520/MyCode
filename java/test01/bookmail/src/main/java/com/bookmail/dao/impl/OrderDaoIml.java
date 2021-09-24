package com.bookmail.dao.impl;

import com.bean.Orders;
import com.bookmail.dao.BaseDao;
import com.bookmail.dao.OrderDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderDaoIml
 * @description: TODO
 * @date 2021/7/2619:27
 */
public class OrderDaoIml extends BaseDao implements OrderDao {
    @Override
    public int addOrder(Orders order) throws SQLException {
        String sql = "insert into orders(orderid, creatdate, status, username, price) values(?, ?, ?, ?, ?)";
        return update(sql, order.getOrderid(), order.getCreatdate(), order.getStatus(), order.getUsername(), order.getPrice());
    }

    @Override
    public ArrayList<Orders> queryOrdersByUsername(String username) throws SQLException {
        String sql = "select * from orders where username = ? order by creatdate DESC";
        return (ArrayList<Orders>) queryForList(Orders.class, sql, username);
    }
}
