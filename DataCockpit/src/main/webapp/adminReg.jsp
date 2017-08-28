<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>注册界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='<%=basePath%>/resource/css/1.css' rel='stylesheet'
	type='text/css'>
<link href='<%=basePath%>/resource/css/2.css' rel='stylesheet'
	type='text/css'>
<link href="<%=basePath%>/resource/css/wickedpicker.css"
	rel="stylesheet" type='text/css' media="all" />
<link href="<%=basePath%>/resource/css/style.css" rel='stylesheet'
	type='text/css' media="all" />
<script src="<%=basePath%>/resource/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resource/js/wickedpicker.js"></script>
</head>
<body>
	<!-- <h2>管理员注册</h2> -->	
	<div class="content-w3ls">
	<label class="email-w3ls" style="text-align: center;color: red;font-family: !important;font-size: 25px;">管理员注册</label> 
		<form action="<%=basePath%>/insertAdminReg.shtml" method="post">
			<div class="form-group1">
				<label class="email-w3ls">手机号：</label> <input type="text"
					name="phone" placeholder="Phone"
					pattern="[1]([3]|[5]|[7]|[8])\d{9}" required="required">
			</div>
			<div class="form-group1">
				<label class="email-w3ls">姓名：</label> <input type="text" name="name" placeholder="Name" required="required">
			</div>
			<div class="form-group1">
				<label class="email-w3ls">职业：</label> <input type="text" name="job"
					placeholder="Duty" required="required">
			</div>
			<div class="form-group1">
				<label class="email-w3ls">电子邮件：</label> <input type="email"
					name="email" placeholder="EMAIL@ADDRESS.COM" required="required">
			</div>
			<div class="form-group2">
				<label class="pwd-w3ls">密码：</label> <input type="password"
					name="password" placeholder="ENTER PASSWORD" pattern="\d{6,15}"
					required="required">
			</div>
			<span id="mess"
				style="color: red; display: block; text-align: right;"></span>
			<div class="form-group3">
				<label class="pwd-w3ls">确认密码：</label> <input type="password"
					name="password1" placeholder="ENTER PASSWORD" pattern="\d{6,15}"
					required="required">
			</div>
			<input type="submit" value="立即注册">
		</form>
	</div>

	<div class="footer-agile">
		<p>
			© 2017 DataCockpit Signin Form. All Rights Reserved | Design by <a
				href="www.baidu.com" target="_blank">DataCockpit</a>
		</p>
	</div>
	<script type="text/javascript">
				$('.timepicker').wickedpicker({twentyFour: false});
			</script>
	<!-- /js files -->

	<script type="text/javascript">
	$("input[name=password1]").blur(function(){
		var password=$("input[name=password]").val();
		var password1=$("input[name=password1]").val();
		if(password!=password1){
			$("#mess").html("*亲，两次输入的密码不一致！");
		}else{
			$("#mess").html("");
		}		
	});
</script>
</body>
</html>