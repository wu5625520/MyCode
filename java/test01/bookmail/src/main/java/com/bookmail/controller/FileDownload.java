package com.bookmail.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author wxy
 * @title: FileDownload
 * @description: TODO
 * @date 2021/7/1814:35
 */
public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String downloadFileName = "zz.jpg";
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/static/img/" + downloadFileName);
        System.out.println("要传输文件的类型是：" + mimeType);
        resp.setContentType(mimeType);
        String str = "attachment; fileName=" + URLEncoder.encode("中文.jpg", "UTF-8");
        resp.setHeader("Content-Disposition", str);
        InputStream resourceAsStream = servletContext.getResourceAsStream("/static/img/" + downloadFileName);
        ServletOutputStream outputStream = resp.getOutputStream();

        IOUtils.copy(resourceAsStream, outputStream);
    }
}
