package com.bookmail.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author wxy
 * @title: FileUpload
 * @description: TODO
 * @date 2021/7/1813:48
 */
public class FileUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)){
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            servletFileUpload.setHeaderEncoding("UTF-8");  //解决文件中文名乱码问题
            try {
                List<FileItem> itemList = servletFileUpload.parseRequest(req);
                for(FileItem item : itemList){
                    if(item.isFormField()){
                        System.out.println("收到的表单项的name值:" + item.getFieldName());
                        System.out.println("收到的表单项的value值:" + item.getString("UTF-8"));
                    }
                    else{
                        System.out.println("收到的表单项的name值:" + item.getFieldName());
                        System.out.println("收到的文件名：" + item.getName());
                        item.write(new File("G:\\c++\\java\\" + item.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
