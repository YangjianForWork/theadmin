<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>枚举项管理</title>
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
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<div id="alertCont">
				<div id="myAlert" class="alert alert-warning">
					<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>警告！</strong>您的网络连接有问题。
				</div>
			</div>
			<p>
				<strong>枚举项管理</strong>
			</p>
			<div class="tabbable" id="tabs-399042">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#panel-805001" data-toggle="tab">实验室</a>
					</li>
					<li><a href="#panel-805002" data-toggle="tab">学校</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-805001">
						<table class="table table-hover" id="table-805001-1">
						</table>
						<table class="table table-hover" id="table-805001-2">
						</table>
					</div>
					<div class="tab-pane" id="panel-805002">
						<table class="table table-hover" id="table-805002-1">
						</table>
						<table class="table table-hover" id="table-805002-2">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>