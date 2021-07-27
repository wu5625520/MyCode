<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

	<%@include file="../common/header.jsp"%>
	<%@include file="../common/head.jsp"%>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.orders}" var="order">
				<tr>
					<td>${order.orderid}</td>
					<td>${order.creatdate}</td>
					<td>${order.price}</td>
					<c:if test="${order.status == 0}">
						<td>未发货</td>
					</c:if>
					<c:if test="${order.status == 1}">
						<td>已发货</td>
					</c:if>
					<c:if test="${order.status == 2}">
						<td>已签收</td>
					</c:if>
					<td><a href="http://localhost:8080/bookmail/orderControl?action=clientOrdersDetails&orderid=${order.orderid}">查看详情</a></td>
				</tr>
			</c:forEach>
		</table>
		
	
	</div>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>