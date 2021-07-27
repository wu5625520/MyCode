package com.bookmail.filter;

import com.bookmail.utils.TransactionUtils;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author wxy
 * @title: TransactionFilter
 * @description: TODO
 * @date 2021/7/2721:26
 */
public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1、开启事务
        TransactionUtils.startTransaction();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            TransactionUtils.commitAndClose();
        } catch (Exception throwables) {
            throwables.printStackTrace();
            TransactionUtils.rollbackAndClose();
        }
    }
}
