package com.bookmail.service;

import com.bookmail.bean.User;

import java.sql.SQLException;

/**
 * @author wxy
 * @title: UserService
 * @description: TODO
 * @date 2021/7/1320:36
 */
public interface UserService {

    public void registUser(User user);

    /**
    　　* @description: 返回值为0表示用户名不存在，为1表示密码错误，为2表示登陆成功
    　　* @author wxy
    　　* @date 2021/7/14 14:26
    　　*/
    public int login(User user);

    /**
    　　* @description: 返回true表示已经存在
    　　* @author wxy
    　　* @date 2021/7/14 15:26
    　　*/
    public boolean existUser(String name);
}
