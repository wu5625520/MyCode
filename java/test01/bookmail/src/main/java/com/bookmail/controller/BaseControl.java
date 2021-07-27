package com.bookmail.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author wxy
 * @title: BaseControl
 * @description: TODO
 * @date 2021/7/1821:20
 */
public abstract class BaseControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getCharacterEncoding());
        req.setCharacterEncoding("UTF-8");  //难道在jsp中写的没有用？还是request改了？应该是request改了，因为前面的域数据这里都没有了
        // 我们都知道jsp里面request作用域的作用范围是一次请求到响应的过程，而jsp页面提交数据到servlet页面使用的是重定向的方式（看浏览器上的URL地址就知道了）而不是转发的方式
        String action = req.getParameter("action");
        System.out.println("收的的请求是：" + action);
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
