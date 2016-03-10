<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<!-- 自定义 -->
<script src="/dist/js/main.js"></script>
<link href="/dist/css/style.css" rel="stylesheet" >
<title>实验室预约系统</title>
</head>
<body>
	<hr>
	<form action="/api/customer?service=getByKey" method="post"  >
		业务号<input name="bizNO" />
		<input type="submit" value="submit" /> 
	</form>
	<hr>
	<form action="/api/customer?service=save" method="post">
		手机号：<input name="prop.mobile"/>
		昵称：<input name="prop.nickname"/>
		密码：<input type="password" name="prop.password">
		学号：<input name="prop.extNO">
		<input type="submit" value="submit" /> 
	</form>
</body>
</html>