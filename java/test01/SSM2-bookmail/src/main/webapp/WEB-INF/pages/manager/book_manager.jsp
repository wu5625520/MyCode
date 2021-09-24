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
			$("input.deleteClass").click(function(){
				return confirm("Do you confirm to delete the [" + $(this).parent().parent().parent().find("td:first").text() + "] ?");
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
			<c:forEach varStatus="status" items="${requestScope.booksByPage}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<%--		修改成REST风格			--%>
					<td>
						<form action="http://localhost:8080/SSM/manager/bookControl/book/${book.id}" method="get">
							<input type="hidden" name="pn" value="${pageInfo.pageNum}">
							<input type="submit" value="修改">
						</form>
					</td>
					<td>
						<form action="http://localhost:8080/SSM/manager/bookControl/book/${book.id}?pn=${pageInfo.pageNum}" method="post">
							<input type="hidden" name="_method" value="DELETE">
							<input type="submit" class="deleteClass" value="删除">
						</form>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="http://localhost:8080/SSM/manager/bookControl/book/0">添加图书</a></td>
			</tr>	
		</table>
		<%@include file="../common/page_nav.jsp"%>
	</div>

	<%@include file="../common/bottom.jsp"%>
</body>
</html>