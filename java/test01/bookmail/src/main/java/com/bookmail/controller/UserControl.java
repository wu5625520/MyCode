package com.bookmail.controller;

import com.bookmail.bean.User;
import com.bookmail.service.UserService;
import com.bookmail.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author wxy
 * @title: UserControl
 * @description: TODO
 * @date 2021/7/1821:01
 */
public class UserControl extends BaseControl {
    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if(!"666".equalsIgnoreCase(code)){
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("code", code);
            System.out.println("验证码错误");  //需要发送到前端？ 验证码需要后端动态生成？
            //resp.sendRedirect("http://localhost:8080/bookmail/pages/user/regist.jsp"); //还是用请求转发来做吧.
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp); //刷新出现412错误？再刷新就好了？
            return;
        }

        //判断用户是否已经存在
        if(userService.existUser(username)){
            req.setAttribute("msg", "用户名已经存在，请重新注册");
            req.setAttribute("username", username);
            System.out.println("用户名已经存在，请重新注册"); //怎么发送给前端？
            //resp.sendRedirect("http://localhost:8080/bookmail/pages/user/regist.jsp");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            return;
        }
        userService.registUser(new User(username, password, email));
        System.out.println("注册成功，请登录");  //需要弹窗提示？
        resp.sendRedirect("http://localhost:8080/bookmail/pages/user/regist_success.jsp");
    }
}
