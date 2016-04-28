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
<!-- 引入Timepicker -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/dist/js/jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="/dist/css/jquery.timepicker.css" />
<script type="text/javascript"
	src="/dist/jquery-timepicker/bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="/dist/jquery-timepicker/bootstrap-datepicker.css" />
<script type="text/javascript" src="/dist/jquery-timepicker/site.js"></script>
<link rel="stylesheet" type="text/css"
	href="/dist/jquery-timepicker/site.css" />
<!-- 自定义 -->
<script src="/dist/js/main.js"></script>
<link href="/dist/css/style.css" rel="stylesheet">
<title>实验室预约系统</title>
</head>
<body>
	<div class="container-fluid">
		<div id="alertCont">
				<div id="myAlert" class="alert alert-warning">
					<a href="#" class="close" data-dismiss="alert">&times;</a> 系统异常
				</div>
		</div>
		<div class="row-fluid myrowfluid">
			<div class="span12 myspan12">
				<ul class="nav nav-pills">
					<li class="active"><a href="#">首页</a></li>
					<li class="disabled"><a href="#">信息</a></li>
					<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">我的<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#">操作</a></li>
							<li><a href="#">设置栏目</a></li>
							<li><a href="#">更多设置</a></li>
							<li class="divider"></li>
							<li><a href="#">分割线</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span9">
				<div class="container" id="labStation">
					<div class="jumbotron" id="labStationCon">
					</div>
				</div>
			</div>
			<div class="span3">
				<table class="table" id="selectLabStation"></table>
			</div>
		</div>
	</div>
</body>
</html>