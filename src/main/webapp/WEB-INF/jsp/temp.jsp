<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap 实例 - 超大屏幕（Jumbotron）</title>
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
			<p>
				<strong>枚举项管理</strong>
			</p>
			<div class="tabbable" id="tabs-399042">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#panel-477589" data-toggle="tab">实验室</a>
					</li>
					<li><a href="#panel-805038" data-toggle="tab">学校</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-477589">
					</div>
					<div class="tab-pane" id="panel-805038">
						<table class="table table-hover" id="table-805038-1">
							<caption>
								<h4>学校类别</h4>
							</caption>
							<thead>
								<tr>
									<th>名称</th>
									<th class="table-tr-op"><a href="#"
										class="btn btn-info btn-lg"> <span
											class="glyphicon glyphicon-plus"></span> 新增类别
									</a></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Tanmay</td>
									<td class="table-tr-op"><div
											class="btn-group btn-group-xs">
											<button type="button" class="btn btn-info"><span
											class="glyphicon glyphicon-pencil"></span> 修改</button>
											<button type="button" class="btn btn-info">详情</button>
										</div></td>
								</tr>
								<tr>
									<td>Trace</td>
									<td class="table-tr-op"><div
											class="btn-group btn-group-xs">
											<button type="button" class="btn btn-info">修改</button>
											<button type="button" class="btn btn-info">详情</button>
										</div></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>