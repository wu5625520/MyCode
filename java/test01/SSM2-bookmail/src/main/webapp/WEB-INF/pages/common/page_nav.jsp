<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/22
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--mybatis插件方式--%>
<%--分页开始--%>
<div align="center">
    <a href="${pageUrl}1">首页</a>
    <c:if test="${pageInfo.isFirstPage}">
        <a>上一页</a>
    </c:if>
    <c:if test="${not pageInfo.isFirstPage}">
        <a href="${pageUrl}${pageInfo.prePage}">上一页</a>
    </c:if>
    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
        <c:if test="${num == pageInfo.pageNum}">
            [${num}]
        </c:if>
        <c:if test="${num != pageInfo.pageNum}">
            <a href="${pageUrl}${num}">${num}</a>
        </c:if>
    </c:forEach>
    <c:if test="${pageInfo.isLastPage}">
        <a>下一页</a>
    </c:if>
    <c:if test="${not pageInfo.isLastPage}">
        <a href="${pageUrl}${pageInfo.nextPage}">下一页</a>
    </c:if>
    <a href="${pageUrl}${pageInfo.pages}">尾页</a>
    <a>共${pageInfo.pages}页，${pageInfo.total}条记录</a>
    <a>跳转到第</a>
    <input class="toPageNum" type="text" style="width: 20px">
    <a>页</a>
    <button id="toPageNum" class="toPageNum">确定</button>
</div>
<%--分页结束--%>



<%--servlet原生方式--%>
<%--&lt;%&ndash;分页开始&ndash;%&gt;--%>
<%--<div align="center">--%>
<%--    <a href="${page.url}&currPageNum=1">首页</a>--%>
<%--    <c:if test="${page.currPageNum == 1}">--%>
<%--        <a>上一页</a>--%>
<%--    </c:if>--%>
<%--    <c:if test="${page.currPageNum != 1}">--%>
<%--        <a href="${page.url}&currPageNum=${page.currPageNum - 1}">上一页</a>--%>
<%--    </c:if>--%>

<%--    <c:forEach begin="${requestScope.begin}" end="${requestScope.end}" var="i">--%>
<%--        <c:if test="${page.currPageNum != i}">--%>
<%--            <a href="${page.url}&currPageNum=${i}">${i}</a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${page.currPageNum == i}">--%>
<%--            <a>[${page.currPageNum}]</a>--%>
<%--        </c:if>--%>
<%--    </c:forEach>--%>

<%--    <c:if test="${page.currPageNum == page.totalPage}">--%>
<%--        <a>下一页</a>--%>
<%--    </c:if>--%>
<%--    <c:if test="${page.currPageNum != page.totalPage}">--%>
<%--        <a href="${page.url}&currPageNum=${page.currPageNum +1}">下一页</a>--%>
<%--    </c:if>--%>
<%--    <a href="${page.url}&currPageNum=${page.totalPage}">尾页</a>--%>
<%--    <a>共${page.totalPage}页，${page.totalNum}条记录</a>--%>
<%--    <a>跳转到第</a>--%>
<%--    <input class="toPageNum" type="text" style="width: 20px">--%>
<%--    <a>页</a>--%>
<%--    <button id="toPageNum" class="toPageNum">确定</button>--%>
<%--</div>--%>
<%--&lt;%&ndash;分页结束&ndash;%&gt;--%>