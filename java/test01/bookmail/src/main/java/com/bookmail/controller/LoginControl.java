package com.bookmail.controller;

import com.bookmail.bean.User;
import com.bookmail.service.UserService;
import com.bookmail.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxy
 * @title: LoginControl
 * @description: TODO
 * @date 2021/7/1321:03
 */
public class LoginControl extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        switch (userService.login(new User(username, password))){
            case 0:
                req.setAttribute("msg", "用户名不存在，请注册");
                req.setAttribute("username", req.getParameter("username"));
                System.out.println("用户名不存在，请注册"); //怎么传到前端？是不是需要用请求转发？regist已经改了，这个先不改吧
//                resp.sendRedirect("http://localhost:8080/bookmail/pages/user/login.jsp");
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
                break;
            case 1:
                req.setAttribute("msg", "密码错误，请重新输入");
                req.setAttribute("username", req.getParameter("username"));
                System.out.println("密码错误，请重新输入"); //怎么传到前端？
//                resp.sendRedirect("http://localhost:8080/bookmail/pages/user/login.jsp");
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
                break;
            case 2:
                resp.sendRedirect("http://localhost:8080/bookmail/pages/user/login_success.jsp");
                break;
        }
    }
}
