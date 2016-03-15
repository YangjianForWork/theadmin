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
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 自定义 -->
<script src="/dist/js/main.js"></script>
<link href="/dist/css/style.css" rel="stylesheet">
<title>实验室预约系统</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li><a href="#">主页</a> <span class="divider">/</span></li>
					<li><a href="#">类目</a> <span class="divider">/</span></li>
					<li class="active">主题</li>
				</ul>
			</div>
		</div>
		<div class="row-fluid">
			<div class="col-xs-6 span9">
				<form action="/api/person?service=getByKey" method="post">
					业务号<input name="bizNO" /> <input type="submit" value="submit" />
				</form>
				<hr>
				<form action="/api/person?service=save" method="post">
					手机号：<input name="customer.mobile" /> 昵称：<input
						name="customer.nickname" /> 密码：<input type="password"
						name="customer.password"> 学号：<input name="customer.extNO">
					男：<input type="radio" name="sex" value="1"> 女：<input
						type="radio" name="sex" value="0"> <input type="submit"
						value="submit" />
				</form>
			</div>
			<div class="col-xs-6 span3"></div>
		</div>
	</div>

</body>
</html>