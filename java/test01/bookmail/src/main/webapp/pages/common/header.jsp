<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/18
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <img class="logo_img" alt="" src="http://localhost:8080/SSM/resource/static/img/logo.gif" >
    <div>
        <span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
        <a href="http://localhost:8080/SSM/orderControl?action=clientOrders">我的订单</a>
        <a href="http://localhost:8080/SSM/userControl?action=logout">注销</a>
        <a href="http://localhost:8080/SSM/index.jsp">返回</a>
    </div>
</div>
