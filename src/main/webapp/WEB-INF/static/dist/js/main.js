$(function() {
	var url = '/api/lab';
	var reqData = {
		"service" : "getLabCategory",
	};
	ajaxSeq(url, reqData, 11, '实验室类别');
	var reqData = {
		"service" : "getLabAttribute"
	};
	ajaxSeq(url, reqData, 12, '实验室属性');

	url = '/api/school';
	var reqData = {
		"service" : "getSchoolType",
	};
	ajaxSeq(url, reqData, 21, '学校属性');
	var reqData = {
		"service" : "getSchoolGrade"
	};
	ajaxSeq(url, reqData, 22, '年级');

	clearAlertContaint();
});
function ajaxSeq(url, reqData, seq, tName) {
	$.ajax({
		url : url,
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		success : function(data) {
			data['seq'] = seq;
			data['tName'] = tName;
			initTable(data);
		},
		error : function(data) {
			alert(date);
		}
	});
}
// 初始化表单
function initTable(data) {
	var arrs = data.data;
	var mTable;
	switch (data.seq) {
	case 11:
		mTable = $('#table-805001-1');
		break;
	case 12:
		mTable = $('#table-805001-2');
		break;
	case 21:
		mTable = $('#table-805002-1');
		break;
	case 22:
		mTable = $('#table-805002-2');
		break;
	}
	var mTHead = '<caption class="caption-default" data-toggle="tooltip" '
			+ '  data-placement="bottom"   title="单击显示/隐藏" '
			+ ' onclick="hideOrShow(this);"><h4>&nbsp;&nbsp;'
			+ data.tName
			+ '</h4></caption>'
			+ '<thead id="'
			+ myRandomID(3)
			+ '" ><tr><th>名称</th><th class="table-tr-op">'
			+ '<a href="#" id="'
			+ mTable.get(0).id
			+ '1'
			+ '" onclick="addTableRow(this);return false;"  class="btn btn-info btn-sm">'
			+ ' <span class="glyphicon glyphicon-plus"></span>&nbsp;新增'
			+ data.tName + ' </a></th></tr></thead><tbody id="' + myRandomID(3)
			+ '" ></tbody>';
	mTable.append(mTHead);
	fillTableBody(mTable, arrs);
}
// 填充表单body
function fillTableBody(mTable, arrs) {
	for (var i = 0; i < arrs.length; i++) {
		var obj = arrs[i];
		var prop = obj.prop;
		var num = obj.bizNO;
		var temp = '<tr><td>'
				+ prop.content
				+ '</td><td class="table-tr-op"><div class="btn-group btn-group-xs">'
				+ '<button type="button" value="'
				+ num
				+ '" class="btn btn-info" onclick="clickSTPencilBtn(this.value);" >'
				+ '<span class="glyphicon glyphicon-pencil">'
				+ '</span> 修改</button></div></td></tr>';
		mTable.append(temp);
	}
}
// 显示或隐藏
function hideOrShow(obj) {
	while (obj.nextSibling) {
		var temp = obj.nextSibling;
		if ($("#" + temp.id).is(':visible') == true) {
			$('#' + temp.id).hide(400);
		} else {
			$('#' + temp.id).show(400);
		}
		obj = obj.nextSibling;
	}
}
// 随机ID
function myRandomID(n) {
	return new Date().getTime() + myRandom(n);
}
// 随机数，长度n
function myRandom(n) {
	var rd = '';
	for (var i = 0; i < n; i++) {
		rd = rd + Math.floor(Math.random() * 9 + 1);
	}
	return rd
}
// 给表格添加一行
function addTableRow(obj) {
	var tid = obj.id.substring(0, obj.id.length - 1);
	var mTable = $("#" + tid);
	var rowId = myRandomID(4);
	var temp = '<tr id="'
			+ rowId
			+ '" ><td><input id="propContent" /></td>'
			+ '<td class="table-tr-op"><div class="btn-group btn-group-xs">'
			+ '<button type="button" value="'
			+ rowId
			+ '" class="btn btn-info" '
			+ ' onclick="removeById(this.value);">'
			+ '<span class="glyphicon glyphicon-remove"></span>&nbsp;取消'
			+ '</button><button type="button" value="1" class="btn btn-info" '
			+ 'onclick="clickSTPencilBtn(this.value);">'
			+ '<span class="glyphicon glyphicon-ok"></span>&nbsp;确定</button></div></td></tr>';
	if ($('#propContent').length == 0) {
		mTable.append(temp);
	} else {
		var msg = "请勿重复操作！";
		alert_info(msg);
	}
}
// 弹出框
function alert_info(msg) {
	clearAlertContaint();
	var myAlert = '<div id="myAlert" class="alert alert-info"> ' + msg + '</div>';
	$('#alertCont').get(0).innerHTML = myAlert;
	setTimeout("clearAlertContaint()", 1250);
}
// 清楚alertContain
function clearAlertContaint() {
	$('#alertCont').get(0).innerHTML = '';
}
// 给表格移去一行
function removeById(id) {
	$("#" + id).remove();
}
// =====待用=====
function hoverCaption(obj) {

}
function testClick(obj) {
	console.log(obj.parentNode);
	console.log(obj.nextSibling);
	var temp = obj.nextSibling;
	console.log(temp.nextSibling);
	var table = obj.parentNode;
	while (obj.nextSibling) {
		console.log('1');
		obj = obj.nextSibling;
	}
	if ($("#" + table.id).is(':visible') == true) {
		console.log('show');
	} else {
		console.log('hide');
	}
	alert('click');
}
function clickSTPencilBtn(num) {
	alert(num);
}
