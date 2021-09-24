package com.Dao;


import com.bean.OrderDetails;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderDetailsDao
 * @description: TODO
 * @date 2021/7/2620:17
 */
public interface OrderDetailsDao {
    ArrayList<OrderDetails> queryOrderDetailsByOrderId(@Param("orderid") String orderid);

    int addOrderDetails(OrderDetails orderDetails);
}
