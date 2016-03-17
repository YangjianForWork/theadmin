$(function() {
	var reqData = {};
/*	 ajaxSeq(reqData, '11', true);
	 ajaxSeq(reqData, '12', true);
	ajaxSeq(reqData, '21', true);
	ajaxSeq(reqData, '22', true);*/
	clearAlertContaint();
	ajaxSeq(reqData, '31', true);
});

// 根据自定义序列号选择URL
function getParamsBySeq(seq) {
	var params = {
		url : '',
		tName : '',
		mTable : null,
		getItem : '',
		saveItem : '',
		filltable: '1'
	}
	switch (seq) {
	case '11':
		params = {
			url : '/api/lab',
			tName : '实验室类别',
			mTable : $('#table-8050011'),
			getItem : 'getLabCategory',
			saveItem : 'saveLabCategory',
			filltable: '1'
		}
		break;
	case '12':
		params = {
			url : '/api/lab',
			tName : '实验室属性',
			mTable : $('#table-8050012'),
			getItem : 'getLabAttribute',
			saveItem : 'saveLabAttribute',
			filltable: '1'
		}
		break;
	case '21':
		params = {
			url : '/api/school',
			tName : '学校类别',
			mTable : $('#table-8050021'),
			getItem : 'getSchoolType',
			saveItem : 'saveSchoolType',
			filltable: '1'
		}
		break;
	case '22':
		params = {
			url : '/api/school',
			tName : '年级',
			mTable : $('#table-8050022'),
			getItem : 'getSchoolGrade',
			saveItem : 'saveSchoolGrade',
			filltable: '1'
		}
		break;
	case '31':
		params = {
			url : '/api/school',
			tName : '',
			mTable : $('#table-8050031'),
			getItem : 'query',
			saveItem : 'save',
			filltable: '2'
		}
		break;
	}
	return params;
}
function ajaxSeq(reqData, seq, init) {
	var params = getParamsBySeq(seq);
	if (init) {
		reqData['service'] = params.getItem;
	} else {
		reqData['service'] = params.saveItem;
	}
	var url = params.url;
	$.ajax({
		url : url,
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		success : function(data) {
			data['tName'] = params.tName;
			data['init'] = init;
			data['mTable'] = params.mTable;
			switch(params.filltable){
			case '1':fillTable1(data);break;
			case '2':fillTable2(data);break;
			}
			
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
}

function getmTHead(data, mTable) {
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
	return mTHead;
}
//初始化表单
function fillTable1(data) {
	var arrs = data.data;
	var mTable = data.mTable;
	if (data.init) {
		var mTHead = getmTHead(data, mTable);
		mTable.append(mTHead);
	}
	fillTableBody1(mTable, arrs);
}
// 填充表单body
function fillTableBody1(mTable, arrs) {
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
function fillTable2(data) {
	var vdata = data.data;
	var arrs = vdata.pdate;
	var mTable = data.mTable;
	if (data.init) {
		var mTHead = getmTHead(data, mTable);
		mTable.append(mTHead);
	}
	fillTableBody2(mTable, arrs);
}
// 填充表单body2
function fillTableBody2(mTable, arrs) {
	for (var i = 0; i < arrs.length; i++) {
		var obj = arrs[i];
		var prop = obj.prop;
		var num = prop.bizNO;
		var content = prop.name;
		var temp = '<tr><td>'
				+ content
				+ '</td><td class="table-tr-op"><div class="btn-group btn-group-xs">'
				+ '<button type="button" value="'
				+ num
				+ '" class="btn btn-info" onclick="clickSTPencilBtn(this.value);" >'
				+ '<span class="glyphicon glyphicon-pencil">'
				+ '</span> 修改</button><button type="button" value="'
				+ num
				+ '" class="btn btn-info" onclick="clickSTPencilBtn(this.value);" >'
				+ '<span class="glyphicon glyphicon-th-large"></span> 学院管理</button></div></td></tr>';
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
			+ '</button><button type="button" value="'
			+ tid
			+ '" class="btn btn-info" '
			+ 'onclick="clickOKBtn(this.value);">'
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
	var myAlert = '<div id="myAlert" class="alert alert-info"> ' + msg
			+ '</div>';
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
// 点击确定按钮
function clickOKBtn(tableID) {
	var seq = tableID.substring(tableID.length - 2);
	var content = $('#propContent').val();
	var reqData = {
		'content' : content
	};
	ajaxSeq(reqData, seq, false);
	var tr = $('#propContent').get(0).parentNode.parentNode;
	removeById(tr.id);
}
//点击修改
function clickEditBtn(){
	
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
