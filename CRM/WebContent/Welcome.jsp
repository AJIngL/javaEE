<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap/js/jquery-2.1.0.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>欢迎回来！~</title>
<style type="text/css">
	body {
	background: url("photo/Welcome_bg.jpg") no-repeat;
	background-size:100%;
	padding-top: 70px; 
	}
	.navbar-text{
	font-size: 18px;
	}
	.navbar-text a{
	text-decoration:none;
	color: red;
	}
	.navbar-text a:HOVER{
	color: gray;
	}
</style>
</head>
<body>
<%int hour = (new Date()).getHours();
  pageContext.setAttribute("hour", hour);
  %>
  
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <p class="navbar-text">
      	<s:if test="#session.username!=null">
	        <s:if test="#attr.hour>6 && #attr.hour<12">
				<%=session.getAttribute("username") %>,上午好
			</s:if>
			<s:elseif test="#attr.hour>=12 && #attr.hour<=14">
				<%=session.getAttribute("username") %>,中午好
			</s:elseif>
			<s:elseif test="#attr.hour>14 && #attr.hour<=17">
				<%=session.getAttribute("username") %>,下午好
			</s:elseif>
			<s:else>
				<%=session.getAttribute("username") %>,晚上好
			</s:else>	
		</s:if>
		<s:else>
			<s:if test="#attr.hour>6 && #attr.hour<12">
				上午好，请&nbsp;<a href="userLogin.jsp">登录</a>
			</s:if>
			<s:elseif test="#attr.hour>=12 && #attr.hour<=14">
				中午好，请&nbsp;<a href="userLogin.jsp">登录</a>
			</s:elseif>
			<s:elseif test="#attr.hour>14 && #attr.hour<=17">
				下午好，请&nbsp;<a href="userLogin.jsp">登录</a>
			</s:elseif>
			<s:else>
				晚上好，请&nbsp;<a href="userLogin.jsp">登录</a>
			</s:else>
		</s:else></p>
      <form class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="ChangePwd.jsp?username="+#session.username">修改密码</a></li>
        
        <s:if test="#session.username!=null">
        <li><a href="UpLogin.action">注销</a></li>
        </s:if>
        <s:else>
        <li><a href="userRegister.jsp">注册</a></li>
        </s:else>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>