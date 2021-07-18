package com.bookmail.dao;

import com.bookmail.bean.User;

import java.util.List;

/**
 * @author wxy
 * @title: UserDao
 * @description: TODO
 * @date 2021/7/1320:06
 */
public interface UserDao {

    public User queryByName(String name);
    public void saveUser(User user);
    public int deleteByName(String name);
    public List<User> queryAll();
}
