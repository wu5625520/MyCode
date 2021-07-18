package com.bookmail.service.impl;

import com.bookmail.bean.User;
import com.bookmail.dao.UserDao;
import com.bookmail.dao.impl.UserDaoImpl;
import com.bookmail.service.UserService;

/**
 * @author wxy
 * @title: UserServiceImpl
 * @description: TODO
 * @date 2021/7/1320:39
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    /**
    　　* @description:
    　　* @author wxy
    　　* @date 2021/7/14 14:38
    　　*/
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    /**
    　　* @description: 返回值为0表示用户名不存在，为1表示密码错误，为2表示登陆成功;
                        感觉最好把判断存在写在control层,这里只判断登录是否成功
    　　* @author wxy
    　　* @date 2021/7/14 14:21
    　　*/
    @Override
    public int login(User user) {
        //先判断用户名存不存在
        if(existUser(user.getUsername())){
            User queryUser = userDao.queryByName(user.getUsername());
            if (queryUser.getPassword().equals(user.getPassword()))
                return 2;
            else
                return 1;
        }
        else return 0;
    }

    /**
    　　* @description: 返回值为true说明已经存在
    　　* @author wxy
    　　* @date 2021/7/13 20:40
    　　*/
    @Override
    public boolean existUser(String name) {
        User user = userDao.queryByName(name);
        return user != null;
    }
}
