<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职工登陆平台</title>

<%@include file="../../../publicHead.jsp" %>

</head>
<body class="theme-login-layout">
	<div class="theme-login-header"></div>

	<div id="theme-login-form">
		<form id="form" class="theme-login-form" method="post" action="login/stuffLogin.do">
			<dl>
				<dt>
					<img src="images/logo2.jpg">
				</dt>

				<dd>
					<input id="username" name="stuffid" class="theme-login-text"
						style="width: 100%;" />
				</dd>
				<dd>
					<input id="password" name="password" class="theme-login-text"
						style="width: 100%;" />
				</dd>
				<dd>
					<a class="submit" id="submit">登陆</a> 
					<a class="easyui-linkbutton button" href="index.html">忘记密码</a>
				</dd>
			</dl>
		</form>
	</div>

	<div class="theme-login-footer"></div>
	
	<script type="text/javascript">
	//登陆界面js
	$(function() {
		$.extend($.fn.validatebox.defaults.tipOptions, {
			onShow : function() {
				$(this).tooltip("tip").css({
					backgroundColor : "#ff7e00",
					border : "none",
					color : "#fff"
				});

			}
		})

		/*布局部分*/
		$('#theme-login-layout').layout({
			fit : true
		/*布局框架全屏*/
		});


		$('#username').textbox({
			prompt : '职工编号',
			required : true,
			missingMessage : "请输入职工号"
		});
		$('#password').textbox({
			type : "password",
			prompt : 'Password',
			required : true,
			missingMessage : "请输入密码"
		});

		$('.submit').linkbutton({

		});
		
		$("#submit").click(function(){
			$("#form").submit();
		});

	});

	</script>
</body>
</html>