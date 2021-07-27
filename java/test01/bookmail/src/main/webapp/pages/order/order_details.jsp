<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/header.jsp"%>
</head>
<body>

	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>
			<c:forEach varStatus="status" items="${sessionScope.orderDetails}" var="orderDetail">
			<tr>
				<td>${orderDetail.name}</td>
				<td>${orderDetail.count}</td>
				<td>${orderDetail.price}</td>
				<td>${orderDetail.totalPrice}</td>
			</tr>
			</c:forEach>
		</table>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>