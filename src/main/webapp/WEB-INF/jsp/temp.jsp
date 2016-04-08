<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>实验室预约系统</title>
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
					<a href="#" class="close" data-dismiss="alert">&times;</a> 系统异常
				</div>
			</div>
			<p>
				<strong>学校管理</strong>
			</p>
			<div class="tab-pane active" id="panel-805003">
				<table class="table table-hover" id="table-8050031">
				</table>
				<table class="table table-hover" id="table-8050032">
				</table>
				<table class="table table-hover" id="table-8050033">
				</table>
				<table class="table table-hover" id="table-8050034">
				</table>
				<div id="panel-8050035"></div>
			</div>
			<!-- <ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul> -->
			<br>
		</div>
	</div>

</body>
</html>