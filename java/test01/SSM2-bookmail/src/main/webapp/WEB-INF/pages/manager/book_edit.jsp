<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/SSM/resource/static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
	.errorMsg {
		color: red;
	}
</style>
</head>
<script type="text/javascript" src="http://localhost:8080/SSM/resource/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//页面加载完成之后
	//给注册按钮绑定单击事件
	$(function(){
		$("#sub").click(function() {
			//1判断价格
			//取值
			var priceText = $("#price").val();
			// alert($("#username"));
			//定义正则表达式,必须由浮点数组成
			var priceRegex = /^(0|[1-9]\d*)(\.\d+)?$/;
			//验证
			if (!priceRegex.test(priceText)) {
				// alert("用户名不合法！");
				$("span.errorMsg").text("价格输入格式错误！");
				return false;
			}

			//2 判断销量
			var salesText = $("#sales").val();
			//定义正则表达式,必须由数字组成，长度5-12位
			var salesRegex = /^\d{1,8}$/;
			//验证
			if (!salesRegex.test(salesText)) {
				$("span.errorMsg").text("销量输入格式错误！");
				return false;
			}
			//3 判断库存
			var stockText = $("#stock").val();
			//定义正则表达式,必须由数字组成，长度5-12位
			var stockRegex = /^[0-9]{1,8}$/;
			//验证
			if (!stockRegex.test(stockText)) {
				$("span.errorMsg").text("库存输入格式错误！");
				return false;
			}
		})
	})
</script>
	<body>
		<div id="header">
			<img class="logo_img" alt="" src="http://localhost:8080/SSM/resource/static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="../common/manage.jsp"%>
		</div>
		
		<div id="main">
			<form action="http://localhost:8080/SSM/manager/bookControl/book/${book.id}" method="post">
				<%--		非空代表修改：用PUT，空代表新增，用POST		--%>
				<c:if test="${not empty book.id}">
					<input type="hidden" name="_method" value="PUT">
				</c:if>
				<input type="hidden" name="pn" value="${pn}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" id="price" type="text" value="${book.price}"/></td>
						<td><input name="author" type="text" value="${book.author}"/></td>
						<td><input name="sales" id="sales" type="text" value="${book.sales}"/></td>
						<td><input name="stock" id="stock" type="text" value="${book.stock}"/></td>
						<td><input type="submit" value="提交" id="sub"/></td>
					</tr>
				</table>
			</form>
			<div align="center" >
				<span class="errorMsg" a></span>
			</div>
	
		</div>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>