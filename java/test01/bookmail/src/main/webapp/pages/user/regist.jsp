<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/SSM/resource/static/css/style.css" >
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<script type="text/javascript" src="http://localhost:8080/SSM/resource/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//页面加载完成之后
	//给注册按钮绑定单击事件
	$(function(){


		$("#code_img").click(function (){
			this.src = "http://localhost:8080/SSM/code.jpg?d=" + new Date();
		});
		// alert("111111");
		$("#sub_btn").click(function() {
			//1判断用户名
			//取值
			var usernameText = $("#username").val();
			// alert($("#username"));
			//定义正则表达式,必须由字母、下划线、数字组成，长度5-12位
			var usernameRegex = /^\w{5,12}$/;
			//验证
			if (!usernameRegex.test(usernameText)) {
				// alert("用户名不合法！");
				$("span.errorMsg").text("用户名不合法！");
				return false;
			}

			//2判断密码
			var passwordText = $("#password").val();
			var passwordRegex = /^\w{5,12}$/;
			if(!passwordRegex.test(passwordText)){
				// alert("密码不合法")
				$("span.errorMsg").text("密码不合法！");
				return false;
			}

			//3判断重复密码是否正确
			var reviewPassword = $("#repwd").val();
			if(reviewPassword != passwordText){
				$("span.errorMsg").text("两次密码不一致！");
				return false;
			}

			//4判断邮箱
			var emailText = $("#email").val();
			var emailRegex = /^([a-zA-Z]|[0-9])\w+@[a-zA-Z0-9]+\.([a-zA-Z]){2,4}$/
			if(!emailRegex.test(emailText)){
				$("span.errorMsg").text("邮箱格式不正确!");
				return false;
			}

			//5判断验证码不为空
			var vertificationCode = $("#code").val();
			if(vertificationCode == null || vertificationCode == ""){
				$("span.errorMsg").text("验证码为空");
				return false;
			}

			//合法时清除提示
			$("span.errorMsg").text(" ");
		}
		)


	})





</script>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="http://localhost:8080/bookmail/resource/static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${msg}</span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/bookmail/userControl" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value=${empty username ? "123456" : username} />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" value=${empty password ? "123456" : password} />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" value=${empty password ? "123456" : password} />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value=${empty email ? "123456@qq.com" : email} />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code" value=${empty code ? "666" : code} />
									<img id="code_img" alt="" src="http://localhost:8080/bookmail/code.jpg" style="float: right; margin-right: 40px; width: 80px; height: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
	<%@include file="../common/bottom.jsp"%>
</body>
</html>