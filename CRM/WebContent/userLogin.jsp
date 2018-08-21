<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap/js/jquery-2.1.0.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>用户登录</title>
<style type="text/css">
	body{
	background: url("photo/login_bg.jpg") no-repeat;
	background-size:100%;
	}
	.form_div{
	width:50%;
	margin-left:300px;
	background-color:rgba(140,140,140,0.2);

	}
	h3{
	background-color: #87CEFA;
	color: white;
	}
	.form-group{
	margin-left: 170px;
	height:70px;
	}
	.btn{
	margin-top:10px;
	margin-right:10px;
	margin-bottom: 50px;
	height: 40px;
	width: 85px;
	}
	.btn-success{
	margin-left: 170px;
	width: 200px;
	}
	
	.form-control{
	width: 300px;
	size: 16px;
	}
</style>
</head>
<body>
	<div class="form_div">
	<form action="login.action" method="post"  validate="true">
	<h3>用户登录</h3>
	  <div class="form-group" id="un_group">
	    <label for="username">用户名</label>
	    <input type="text" class="form-control" id="username" name="p.username" value="${username }"><s:fielderror fieldName="p.username" style="color:red;" />
	  </div>
	  <div class="form-group" id="pw_group">
	    <label for="password">密码</label>
	    <input type="password" class="form-control" id="password" name="p.password"><s:fielderror fieldName="p.password" style="color:red;"/>
	  </div>
	  <button type="submit" class="btn btn-success">登录</button>
	  <button type="reset" class="btn btn-primary">重置</button>
	</form>
	</div>
</body>
</html>