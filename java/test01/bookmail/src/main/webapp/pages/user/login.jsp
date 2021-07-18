<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/bookmail/static/css/style.css" >
</head>
<base href="http://localhost:8080/bookmail/pages/">
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="http://localhost:8080/bookmail/static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>会员</h1>
								<a href="user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">${empty msg ? "请输入用户名和密码" : msg}</span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/bookmail/userControl" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value=${empty username ? "wxy123" : username} />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" value="123456" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="../common/bottom.jsp"%>
</body>
</html>