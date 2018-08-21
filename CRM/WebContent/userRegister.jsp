<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap/js/jquery-2.1.0.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>用户注册</title>
<style type="text/css">
body{
	background: url("photo/register_bg.jpg") no-repeat;
	background-size:100%;
	}
	.form_div{
	width:50%;
	margin-left:300px;
	background-color:rgba(144,144,144,0.2);

	}
	h3{
	background-color: #87CEFA;
	color: white;
	}
	.form-group{
	margin-left: 170px;
	height:60px;
	}
	.form-control{
	width: 300px;
	size: 16px;
	}
	span{
	font-size: 14px;
	color: red;
	}
	.btn{
	margin-top:30px;
	margin-right:10px;
	margin-bottom: 50px;
	height: 40px;
	width: 85px;
	}
	.btn-success{
	margin-left: 170px;
	width: 200px;
	}
</style>
</head>
<body>
	<div class="form_div">
	<form action="register.action" method="post">
	<h3>用户登录</h3>
	  <div class="form-group">
	    <label for="username"><span>*</span>用户名</label>
	    <input type="text" class="form-control" id="username" name="p.username" ><s:fielderror fieldName="p.username" style="color:red;" />
	  </div>
	  <div class="form-group">
	    <label for="password"><span>*</span>密码</label>
	    <input type="password" class="form-control" id="password" name="p.password"><s:fielderror fieldName="p.password" style="color:red;"/>
	  </div>
	  <div class="form-group">
	    <label for="confirmpassword"><span>*</span>确认密码</label>
	    <input type="password" class="form-control" id="confirmpassword" name="p.confirmPassword"><s:fielderror fieldName="p.confirmPassword" style="color:red;"/>
	  </div>
	  <div class="form-group">
	    <label for="email"><span>*</span>邮箱</label>
	    <input type="text" class="form-control" id="email" name="p.email"><s:fielderror fieldName="p.email" style="color:red;"/>
	  </div>
	  <button type="submit" class="btn btn-success">注册</button>
	  <button type="reset" class="btn btn-primary">重置</button>
	</form>
	</div>
</body>
</html>