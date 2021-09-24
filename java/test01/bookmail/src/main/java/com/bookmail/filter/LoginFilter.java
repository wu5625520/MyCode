package com.bookmail.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxy
 * @title: LoginFilter
 * @description: TODO
 * @date 2021/7/2720:54
 */
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(req.getSession().getAttribute("username") == null){
            resp.sendRedirect("/SSM/pages/user/login.jsp");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
