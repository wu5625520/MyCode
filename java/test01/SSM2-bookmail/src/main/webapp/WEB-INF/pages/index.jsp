<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<script>

	</script>

	<%-- 静态包含 base标签、css样式、jQuery文件//算了，先就这样吧 --%>
	<%@include file="common/head.jsp"%>
	<script type="text/javascript">
		//这种不行，必须得用class标签？
		// test = function (){
		// 	var id = $(this).attr("book_id");
		// 	$.getJSON("http://localhost:8080/SSM/cartControl", "action=addItem&id=" + id, function (data) {
		// 		$("#cartCount").text("您的购物车中有" + data.sumCount + "件商品");
		// 		$("#lastAddItem").text("您刚刚将【"+ data.lastName + "】加入到购物车中");
		// 	})
		// };

		$(function (){
			$("button.addToCart").click(function () {
				var id = $(this).attr("book_id");
				$.post("http://localhost:8080/SSM/cartControl/book/" + id, "", function (data) {
					$("#cartCount").text("您的购物车中有" + data.sumCount + "件商品");
					$("#lastAddItem").text("您刚刚将【"+ data.lastName + "】加入到购物车中");
				})
			});

			$("#toPageNum").click(function(){
				var page = $("input.toPageNum").val();
				if(page > ${pageInfo.pages} || page < 1){
					alert("输入页码错误！");
					return false;
				}
				// alert(page);
				window.location.href="${pageUrl}" + page;
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
			<img class="logo_img" alt="" src="http://localhost:8080/SSM/resource/static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.username}">
					<a href="http://localhost:8080/SSM/loginPage">登录</a> |
					<a href="http://localhost:8080/SSM/registPage">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.username}">
					<span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
					<a href="http://localhost:8080/SSM/orderControl/clientOrders">我的订单</a>
					<a href="http://localhost:8080/SSM/userControl/logout">注销</a>
				</c:if>
				<a href="http://localhost:8080/SSM/client/cartPage">购物车</a>
				<c:if test="${sessionScope.isManager}">
					<a onclick="manager()" href="http://localhost:8080/SSM/manager/managerPage">后台管理</a>
				</c:if>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form method="get" action="http://localhost:8080/SSM/client/listBookByPage">
					<input type="hidden" name="action" value="listBookByPageAndPrice">
					价格：<input id="min" type="text" name="minPrice" value="${requestScope.minPrice}"> 元 -
						<input id="max" type="text" name="maxPrice" value="${requestScope.maxPrice}"> 元
						<input id="searchByPrice" type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span id="cartCount">您的购物车中有${empty sessionScope.cart.sumCount ? 0 : sessionScope.cart.sumCount}件商品</span>
<%--				<c:if test="${not empty sessionScope.lastName}">--%>
<%--					<div>--%>
<%--						您刚刚将<span id="lastAddItem" style="color: red">${sessionScope.lastName}</span>加入到了购物车中--%>
<%--					</div>--%>
<%--				</c:if>--%>
					<div>
						<span id="lastAddItem" style="color: red"></span>
					</div>

			</div>
			<c:forEach varStatus="status" items="${booksByPage}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="http://localhost:8080/SSM/${book.ima_path}" />
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
						<button book_id="${book.id}" class="addToCart">加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

		<%@include file="common/page_nav.jsp"%>
	
	</div>

	<%--静态包含页脚内容--%>
	<%@include file="/WEB-INF/pages/common/bottom.jsp"%>

</body>
</html>