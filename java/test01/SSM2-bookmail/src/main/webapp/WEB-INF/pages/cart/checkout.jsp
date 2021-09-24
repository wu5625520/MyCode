<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>

	<%@include file="../common/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

	<%@include file="../common/header.jsp"%>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${sessionScope.orderid}</h1>
		
	
	</div>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>