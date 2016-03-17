$(function(){
	loadEnumItemPage();
});

function loadEnumItemPage(){
	$('#main_frame').get(0).innerHTML='<div class="container"><div class="jumbotron"><div id="alertCont"><div id="myAlert" class="alert alert-warning"><a href="#" class="close" data-dismiss="alert">&times;</a> 系统异常</div></div><p><strong>属性管理</strong></p><div class="tabbable" id="tabs-399042"><ul class="nav nav-tabs"><li class="active"><a href="#panel-805001" data-toggle="tab">实验室</a></li><li><a href="#panel-805002" data-toggle="tab">学校</a></li></ul><div class="tab-content"><div class="tab-pane active" id="panel-805001"><table class="table table-hover" id="table-8050011"></table><table class="table table-hover" id="table-8050012"></table></div><div class="tab-pane" id="panel-805002"><table class="table table-hover" id="table-8050021"></table><table class="table table-hover" id="table-8050022"></table></div></div></div></div></div>';
}