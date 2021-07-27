package com.bookmail.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wxy
 * @title: TransactionUtils
 * @description: TODO
 * @date 2021/7/2720:21
 */
public class TransactionUtils {
    private final static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    public static Connection getConnection(){
        if(connectionThreadLocal.get() == null){
            Connection connection = JdbcUtils.getConnection();
            connectionThreadLocal.set(connection);
        }
        return connectionThreadLocal.get();
    }

    public static void commitAndClose() throws SQLException {

        Connection connection = connectionThreadLocal.get();
        if(connection != null){
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
            connectionThreadLocal.remove();
        }
    }


    public static void startTransaction() {
        Connection connection = TransactionUtils.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void rollbackAndClose(){
        Connection connection = connectionThreadLocal.get();
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
