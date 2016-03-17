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
	<div id="loginPanel" class="panel panel-primary">
		<div class="panel-body pBody">
			<form action="/home" class="bs-example bs-example-form"
				role="form" method="post">
				<div class="input-group">
					<span class="input-group-addon span_light_cyan"></span><input
						type="text" class="form-control" name="userName" placeholder="用户名">
				</div>
				<br />
				<div class="input-group">
					<span class="input-group-addon span_light_cyan"></span><input
						type="password" class="form-control" name="pwd"
						placeholder="密   码">
				</div>
				<br />
				<div align="center">
					<input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"
						class="btn btn-info btn-sm loginBtn" />
				</div>
				<br />
			</form>
		</div>
	</div>
</body>
</html>