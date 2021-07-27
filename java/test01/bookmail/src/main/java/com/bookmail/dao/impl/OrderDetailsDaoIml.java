package com.bookmail.dao.impl;

import com.bookmail.bean.OrderDetails;
import com.bookmail.dao.BaseDao;
import com.bookmail.dao.OrderDetailsDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderDetailsDaoIml
 * @description: TODO
 * @date 2021/7/2620:17
 */
public class OrderDetailsDaoIml extends BaseDao implements OrderDetailsDao {
    @Override
    public ArrayList<OrderDetails> queryOrderDetailsByOrderId(String orderid) throws SQLException {

        String sql = "select * from orderdetails where orderid = ?";
        return (ArrayList<OrderDetails>) queryForList(OrderDetails.class, sql, orderid);

    }

    @Override
    public int addOrderDetails(String name, Integer count, Float price, Float totalPrice, String orderid) throws SQLException {
        String sql = "insert into orderdetails(name, count, price, totalPrice, orderid) values(?, ?, ?, ?, ?)";
        return update(sql, name, count, price, totalPrice, orderid);
    }
}
