package com.Dao;


import com.bean.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wxy
 * @title: UserDao
 * @description: TODO
 * @date 2021/7/1320:06
 */
public interface UserDao {

    public User queryByName(@Param("userName") String name) throws SQLException;
    public void saveUser(User user) throws SQLException;
    public int deleteByName(@Param("username") String name) throws SQLException;
    public List<User> queryAll() throws SQLException;
}
