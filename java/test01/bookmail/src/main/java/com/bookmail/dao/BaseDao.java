package com.bookmail.dao;

import com.bookmail.utils.JdbcUtils;
import com.bookmail.utils.TransactionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wxy
 * @title: BaseDao
 * @description: TODO
 * @date 2021/7/1319:21
 */
public abstract class BaseDao {
    //DBUtils封装了JDBC的操作
    private final QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... args) throws SQLException {
//        Connection connection = JdbcUtils.getConnection();
        Connection connection = TransactionUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);  //返回值是受影响的行数
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            JdbcUtils.closeConnection(connection);
//            TransactionUtils.closeConnection();
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object...args) throws SQLException {
//        Connection connection = JdbcUtils.getConnection();
            Connection connection = TransactionUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            JdbcUtils.closeConnection(connection);
//            TransactionUtils.closeConnection();
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object...args) throws SQLException {
//        Connection connection = JdbcUtils.getConnection();
        Connection connection = TransactionUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            JdbcUtils.closeConnection(connection);
//            TransactionUtils.closeConnection();
        }
        return null;
    }
    /**
    　　* @description: 查询单个值，如select count(*) from ?
    　　* @author wxy
    　　* @date 2021/7/13 19:59
    　　*/
    public Object queryForSingleValue(String sql, Object...args) throws SQLException {
//        Connection connection = JdbcUtils.getConnection();
        Connection connection = TransactionUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<Object>(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JdbcUtils.closeConnection(connection);
//            TransactionUtils.closeConnection();
        }
        return null;
    }
}
