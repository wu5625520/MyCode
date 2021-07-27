<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

	<%-- 静态包含 base标签、css样式、jQuery文件//算了，先就这样吧 --%>
	<%@include file="common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$("#toPageNum").click(function(){
				var page = $("input.toPageNum").val();
				if(page > ${page.totalPage} || page < 1){
					alert("输入页码错误！");
					return false;
				}
				// alert(page);
				window.location.href="http://localhost:8080/bookmail/client/bookControl?action=listBookByPage&currPageNum=" + page;
			})
			$("#searchByPrice").click(function (){
				var minPrice = $("#min").val();
				var maxPrice = $("#max").val();
				var priceRegex = /^(0|[1-9]\d*)(\.\d+)?$/;
				if(!priceRegex.test(minPrice) || !priceRegex.test(maxPrice)){
					alert("价格输入不合法，请输入整数或小数");
					return false;
				}
				if(minPrice > maxPrice){
					alert("价格区间输入不合法，请重新输入");
					return false;
				}
			})
		});
	</script>

</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="http://localhost:8080/bookmail/static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.username}">
					<a href="http://localhost:8080/bookmail/pages/user/login.jsp">登录</a> |
					<a href="http://localhost:8080/bookmail/pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.username}">
					<span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
					<a href="http://localhost:8080/bookmail/pages/order/order.jsp">我的订单</a>
					<a href="http://localhost:8080/bookmail/userControl?action=logout">注销</a>
				</c:if>
				<a href="http://localhost:8080/bookmail/pages/cart/cart.jsp">购物车</a>
				<a href="http://localhost:8080/bookmail/pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form method="get" action="http://localhost:8080/bookmail/client/bookControl">
					<input type="hidden" name="action" value="listBookByPageAndPrice">
					价格：<input id="min" type="text" name="min" value="${requestScope.minPrice}"> 元 -
						<input id="max" type="text" name="max" value="${requestScope.maxPrice}"> 元
						<input id="searchByPrice" type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有${sessionScope.cart.sumCount}件商品</span>
				<c:if test="${not empty sessionScope.lastName}">
					<div>
						您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
					</div>
				</c:if>

			</div>
			<c:forEach varStatus="status" items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.ima_path}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button onclick="javascrtpt:window.location.href='http://localhost:8080/bookmail/cartControl?action=addItem&id=${book.id}&name=${book.name}&price=${book.price}'">加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

		<%@include file="common/page_nav.jsp"%>
	
	</div>

	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/bottom.jsp"%>

</body>
</html>