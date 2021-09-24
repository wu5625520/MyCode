<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/18
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传和下载</title>
</head>
<body>
    <form  action="http://localhost:8080/SSM/fileUpload" enctype="multipart/form-data" method="post">
        昵称：<input type="text" name="username" value="QQ" /> <br>
        上传头像:<input type="file" name="photo" /> <br>
        <input type="submit" value="确认">
    </form>
    <hr />
    <form action="http://localhost:8080/SSM/fileDownload" method="get">
        <input type="submit" value="下载图片">
    </form>
</body>
</html>
