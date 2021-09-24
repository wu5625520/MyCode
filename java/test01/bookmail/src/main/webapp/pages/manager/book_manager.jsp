<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="../common/head.jsp"%>
	<%--	不要用相对地址 /google网页检查看下哪个引入错误--%>
	<script type="text/javascript">
		$(function (){
			$("a.deleteClass").click(function(){
				return confirm("Do you confirm to delete the [" + $(this).parent().parent().find("td:first").text() + "] ?");
			});
			$("#toPageNum").click(function(){
				var page = $("input.toPageNum").val();
				if(page > ${page.totalPage} || page < 1){
					alert("输入页码错误！");
					return false;
				}
				// alert(page);
				window.location.href="${page.url}&currPageNum=" + page;
			})
		});
	</script>

</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="http://localhost:8080/SSM/resource/static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@include file="../common/manage.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach varStatus="status" items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="http://localhost:8080/SSM/manager/bookControl?action=getBook&id=${book.id}&currPageNum=${page.currPageNum}">修改</a></td>
					<td><a class="deleteClass" href="http://localhost:8080/SSM/manager/bookControl?action=deleteBook&id=${book.id}&currPageNum=${page.currPageNum}">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="http://localhost:8080/SSM/pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
		<%@include file="../common/page_nav.jsp"%>
	</div>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>