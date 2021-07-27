<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/header.jsp"%>
	<script type="text/javascript">
		// function myfunction(){
		// 	var count = $("input.count").val();
		// 	var id = $("#id_hidden").val();
		// 	window.location.href="http://localhost:8080/bookmail/cartControl?action=changeCount&id=" + id + "&count=" + count;
		// }

		//这里一定要用class，是一组，不能用id!!!!!!!!!!!
		$(function (){
			$("input.count").change(function (){
				 // alert(this.value);
				var count = this.value;
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookid');
				if(confirm("你确定要修改【" + name + "】的数量为：【" + count +"】吗？"))
				{
					window.location.href="http://localhost:8080/bookmail/cartControl?action=changeCount&id=" + id + "&count=" + count;
				}
				else{
					this.value = this.defaultValue;
				}

			});
			$("a.delete").click(function (){
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookid');
				if(confirm("are you confirm to delete the 【" + name + "】?")){
					window.location.href="http://localhost:8080/bookmail/cartControl?action=deleteItem&id=" + id;
				}
			})
		})



	</script>

</head>
<body>

	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach varStatus="status" items="${sessionScope.cart.items}" var="cartitem">
			<tr>
				<td>${cartitem.name}</td>
				<td>
					<input type="text" class="count" style="width: 80px" name="count" bookid="${cartitem.id}" value="${cartitem.count}">
				</td>
				<td>${cartitem.price}</td>
				<td>${cartitem.totalPrice}</td>
				<td><a class="delete" bookid="${cartitem.id}">删除</a></td>
			</tr>
			</c:forEach>
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${empty sessionScope.cart.sumCount ? 0 : sessionScope.cart.sumCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${empty sessionScope.cart.sumPrice ? 0 : sessionScope.cart.sumPrice}</span>元</span>
			<span class="cart_span"><a href="http://localhost:8080/bookmail/cartControl?action=deleteAll">清空购物车</a></span>
			<span class="cart_span"><a href="http://localhost:8080/bookmail/orderControl?action=creatOrder">去结账</a></span>
		</div>
	
	</div>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>