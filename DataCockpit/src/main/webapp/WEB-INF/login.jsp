<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
	String context = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+context+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>登录</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="<%=basePath %>/resource/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=basePath %>/resource/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<%=basePath %>/resource/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=basePath %>/resource/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=basePath %>/resource/css/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  <style type="text/css">
      #code_input{
        width: 200px;
        height: 34px;
      }
      #bgvid{
        position: fixed;right: 0;bottom: 0;
        min-width: 100%;min-height: 100%;
        width: auto;
        height: auto;
        z-index: -100;
        background:url(./dahai.jpg) no-repeat;
        background-size: cover;
      }
    </style>
</head>
<body class="hold-transition login-page" >
<!-- <video src="./images/dahai.mp4" controls="controls"></video> -->
<video autoplay loop poster="dahai.jpg" id="bgvid"> 
    <source src="<%=basePath %>/resource/images/dahai.mp4" type="video/mp4">
</video>
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b>用户登录</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body" style="background-color: rgba(54,167,129,.4);">
    <p class="login-box-msg">请输入您的账号密码</p>

    <form action="<%=basePath %>/login.shtml" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="请输入手机号码" pattern="1[34578]\d{9}" required="required" name="phone">
        <span style="display: block;margin-top: -30px;margin-left: 291px"><img src="<%=basePath %>/resource/images/iphone.png" style="width: 27px;height: 25px"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="请输入密码" pattern="[0-9a-zA-Z]{8,16}" required="required" name="password">
        <span style="display: block;margin-top: -30px;margin-left: 293px"><img src="<%=basePath %>/resource/images/locked.png" style="width: 20px;height: 25px"></span>
      </div>

      <div class="form-group has-feedback">
          <div>
             <input type="text" class="form-control" id="code_input"  placeholder="请输入验证码" style="width: 140px;float: left">
          </div>
          <div id="v_container" style="width: 150px;height: 40px;float: left;margin-left: 20px"></div>
  
      </div>
		 <div class="col-xs-8">
          <div class="checkbox icheck" style="margin-left:10px">
            <label>
              <input type="checkbox" name="onLine" value="3"> <span style="color:#272822">下次自动登录</span>
            </label>
          </div>
        </div>
       <div class="col-xs-4" style="width: 320px;margin-top: 1px">
          <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
      <div class="row">
       
        <!-- /.col -->
        <div class="col-xs-4" style="font-size: 14px;margin-top: 7px;margin-left:10px">
            <a href="<%=basePath %>/pages/register.jsp" class="text-center" style="color: #272822">申请合作</a>
        </div>

         <div class="col-xs-4" style="font-size: 14px;margin-top: 7px;margin-left:105px">
           <a href="<%=basePath %>/pages/wangjimima.jsp" class="text-center" style="color: #272822">忘记密码</a>
        </div>
        
        <!-- /.col -->
      </div>
    </form>

    
    <!-- /.social-auth-links -->

    
    

  </div>
  <!-- /.login-box-body -->
</div>

    
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="<%=basePath %>/resource/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=basePath %>/resource/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="<%=basePath %>/resource/js/icheck.min.js"></script>
<script src="<%=basePath %>/resource/js/gVerify.js"></script>


<script>
<#-- 获取验证码 -->
    var verifyCode = new GVerify("v_container");

    document.getElementById("code_input").onblur = function(){
      var res = verifyCode.validate(document.getElementById("code_input").value);
      if(!res){
        alert("验证码错误");
      }
    }
  </script>
</body>
</html>
