package com.bookmail.dao.impl;

import com.bookmail.bean.User;
import com.bookmail.dao.BaseDao;
import com.bookmail.dao.UserDao;

import java.util.List;

/**
 * @author wxy
 * @title: UserDaoImpl
 * @description: TODO
 * @date 2021/7/1320:12
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryByName(String name) {
        String sql = "select * from user where username = ?";
        return queryForOne(User.class, sql, name);
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into user(username, password, email) value(?, ?, ?)";
        update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public int deleteByName(String name) {
        String sql = "delete from user where username = ?";
        return update(sql, name);
    }

    @Override
    public List<User> queryAll() {
        String sql = "select * from user";
        return queryForList(User.class, sql, null);
    }
}
