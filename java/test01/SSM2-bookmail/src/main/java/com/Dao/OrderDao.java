package com.Dao;


import com.bean.Orders;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderDao
 * @description: TODO
 * @date 2021/7/2619:27
 */
public interface OrderDao {
    int addOrder(Orders order);

    ArrayList<Orders> queryOrdersByUsername(@Param("username") String username);
}
