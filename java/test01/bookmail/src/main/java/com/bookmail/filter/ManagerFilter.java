package com.bookmail.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxy
 * @title: Filter
 * @description: TODO
 * @date 2021/7/2716:19
 */
public class ManagerFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if(("wxy520").equals(req.getSession().getAttribute("username"))){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            System.out.println("你没有管理员权限！");
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    @Override
    public void destroy() {

    }
}
