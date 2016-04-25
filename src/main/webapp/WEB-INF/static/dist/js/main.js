$(function() {
	var reqData = {};
	/*
	 * ajaxSeq(reqData, '11', true); ajaxSeq(reqData, '12', true);
	 * ajaxSeq(reqData, '21', true); ajaxSeq(reqData, '22', true);
	 */
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
		filltable : '1'
	}
	switch (seq) {
	case '11':
		params = {
			url : '/api/lab',
			tName : '实验室类别',
			mTable : $('#table-8050011'),
			getItem : 'getLabCategory',
			saveItem : 'saveLabCategory',
			filltable : '1'
		}
		break;
	case '12':
		params = {
			url : '/api/lab',
			tName : '实验室属性',
			mTable : $('#table-8050012'),
			getItem : 'getLabAttribute',
			saveItem : 'saveLabAttribute',
			filltable : '1'
		}
		break;
	case '21':
		params = {
			url : '/api/school',
			tName : '学校类别',
			mTable : $('#table-8050021'),
			getItem : 'getSchoolType',
			saveItem : 'saveSchoolType',
			filltable : '1'
		}
		break;
	case '22':
		params = {
			url : '/api/school',
			tName : '年级',
			mTable : $('#table-8050022'),
			getItem : 'getSchoolGrade',
			saveItem : 'saveSchoolGrade',
			filltable : '1'
		}
		break;
	case '31':
		params = {
			url : '/api/school',
			tName : '',
			mTable : $('#table-8050031'),
			getItem : 'query',
			saveItem : 'save',
			filltable : '2'
		}
		break;
	case '32':
		params = {
			url : '/api/school',
			tName : '学院列表',
			mTable : $('#table-8050032'),
			getItem : 'getInsitituteList',
			saveItem : 'save',
			filltable : '3'
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
			switch (params.filltable) {
			case '1':
				fillTable1(data);
				break;
			case '2':
				fillTable2(data);
				break;
			case '3':
				fillTable3(data);
				break;
			}

		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
}
function getCaptionStr(tName) {
	var captionStr = '<caption class="caption-default" data-toggle="tooltip" '
			+ '  data-placement="bottom"   title="单击显示/隐藏" '
			+ ' onclick="hideOrShow(this);"><h4>&nbsp;&nbsp;' + tName
			+ '</h4></caption>';
	return captionStr;
}
function getmTHead(data, mTable) {
	var mTHead = getCaptionStr(data.tName)
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
function getmTHead1(data, mTable) {
	var mTHead = getCaptionStr(data.tName)
			+ '<thead id="'
			+ myRandomID(3)
			+ '" ><tr><th>名称</th><th>代码</th><th class="table-tr-op">'
			+ '<a href="#" id="'
			+ mTable.get(0).id
			+ '1'
			+ '" onclick="saveRow(this);return false;"  class="btn btn-info btn-sm">'
			+ ' <span class="glyphicon glyphicon-plus"></span>&nbsp;新增'
			+ data.tName + ' </a></th></tr></thead><tbody id="' + myRandomID(3)
			+ '" ></tbody>';
	return mTHead;
}
// 初始化表单
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
		var prop = arrs[i].prop;
		var num = arrs[i].bizNO;
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
	if (mTable.get(0) == null)
		return;
	mTable.get(0).innerHTML = '';
	mTable.show();
	if (data.init) {
		var mTHead = getmTHead1(data, mTable);
		mTable.append(mTHead);
	}
	fillTableBody2(mTable, arrs);
}
// 填充表单body2
function fillTableBody2(mTable, arrs) {
	for (var i = 0; i < arrs.length; i++) {
		var prop = arrs[i].prop;
		var temp = '<tr><td>'
				+ prop.name
				+ '</td><td>'
				+ prop.code
				+ '</td><td class="table-tr-op"><div class="btn-group btn-group-xs">'
				+ '<button type="button" value="'
				+ prop.bizNO
				+ '" class="btn btn-info" onclick="fillSaveSchool(this.value);" >'
				+ '<span class="glyphicon glyphicon-pencil">'
				+ '</span> 修改</button><button type="button" value="'
				+ prop.bizNO
				+ '" class="btn btn-info" onclick="clickManageInstitute(this.value);" >'
				+ '<span class="glyphicon glyphicon-th-large"></span> 学院管理</button></div></td></tr>';
		mTable.append(temp);
	}
}
// 点击学院管理
function clickManageInstitute(NO) {
	var reqData = {
		"service" : "",
		"schoolNO" : NO
	}
	ajaxSeq(reqData, "32", true);
	$('#table-8050031').hide();

}
// fillTable2
function fillTable3(data) {
	var arrs = data.data;
	var mTable = data.mTable;
	if (data.init) {
		var mTHead = getmTHead1(data, mTable);
		mTable.append(mTHead);
	}
	fillTableBody3(mTable, arrs);
}
function fillTableBody3(mTable, arrs) {
	for (var i = 0; i < arrs.length; i++) {
		var prop = arrs[i].prop;
		var temp = '<tr><td>'
				+ prop.name
				+ '</td><td>'
				+ prop.code
				+ '</td><td class="table-tr-op"><div class="btn-group btn-group-xs">'
				+ '<button type="button" value="'
				+ prop.bizNO
				+ '" class="btn btn-info" onclick="clickSTPencilBtn(this.value);" >'
				+ '<span class="glyphicon glyphicon-pencil">'
				+ '</span> 修改</button><button type="button" value="'
				+ prop.bizNO
				+ '" class="btn btn-info" onclick="clickSTPencilBtn(this.value);" >'
				+ '<span class="glyphicon glyphicon-th-large"></span> 专业管理</button></div></td></tr>';
		mTable.append(temp);
	}
}
// 显示或隐藏
function hideOrShow(obj) {
	while (obj.nextSibling) {
		var temp = obj.nextSibling;
		if ($("#" + temp.id).is(':visible') == true) {
			$('#' + temp.id).hide();
		} else {
			$('#' + temp.id).show();
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
// 添加，修改
function saveRow(obj) {
	var tid = obj.id.substring(0, obj.id.length - 1);
	var mTable = $("#" + tid);
	switch (tid) {
	case "table-8050031":
		fillSaveSchool('');
		break;
	}
}
// 激活确认按钮
function ableSaveSchoolBtn() {
	$("#saveSchoolBtn").removeClass("disable").removeAttr('disabled');
}
// 新增或修改学校
function fillSaveSchool(num) {
	var myForm = '<div><span class="input-group-addon addon0">学校信息</span></div>'
			+ '<input type="hidden" class="form-control" id="shNO">'
			+ '<div class="input-group input0"><span class="input-group-addon">学校名称</span>'
			+ '<input type="text" class="form-control" id="shName" >'
			+ '</div><div class="form-group input2">'
			+ '<select class="form-control input" id="shType">'
			+ '<option value="">学校类型</option></select>'
			+ '</div><div class="input-group input2"><span class="input-group-addon"  >学校代码</span>'
			+ '<input type="text" class="form-control" id="shCode"  ></div>'
			+ '<button type="button" class="btn btn-info btn0" id="saveSchoolBtn" '
			+ ' onclick="saveSchool();">确定</button>';
	$('#panel-8050035').get(0).innerHTML = myForm;
	$("#table-8050031").hide();
	schoolTypeSelect();
	if (num != '') {
		$.ajax({
			url : "/api/school",
			data : {
				"service" : "getByNO",
				"bizNO" : num
			},
			type : 'POST',
			cache : false,
			dataType : 'json',
			success : function(data) {
				var prop = data.data.prop;
				$('#shName').attr("value", prop.name);
				$('#shCode').attr("value", prop.code);
				$('#shNO').attr("value", prop.bizNO);
				$.each($("#shType option"), function(i, n) {
					if ($(n).val() == prop.typeNO) {
						$(n).attr("selected", true);
					}
				});
			},
			error : function(data) {
				var respData = eval('(' + data.responseText + ')');
				alert_info(respData.resuDesc);
			}
		});
	}
}
function saveSchool() {
	var name = $('#shName').get(0).value;
	var code = $('#shCode').get(0).value;
	var bizNO = $('#shNO').get(0).value;
	var typeNO = $("#shType").find("option:selected").val();
	$.ajax({
		url : "/api/school",
		data : {
			"service" : "save",
			"prop.name" : name,
			"prop.typeNO" : typeNO,
			"prop.code" : code,
			"prop.bizNO" : bizNO
		},
		type : 'POST',
		cache : false,
		dataType : 'json',
		success : function(data) {
			$('#panel-8050035').get(0).innerHTML = '';
			var reqData = {};
			ajaxSeq(reqData, '31', true);
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
}
// 学校类型下拉框
function schoolTypeSelect() {
	$.ajax({
		url : "/api/school",
		data : {
			"service" : "getSchoolType"
		},
		type : 'POST',
		cache : false,
		dataType : 'json',
		success : function(data) {
			var arrs = data.data;
			var typeSelect = $('#shType');
			for (var i = 0; i < arrs.length; i++) {
				var option = '<option value="' + arrs[i].bizNO + '">'
						+ arrs[i].prop.content + '</option>';
				typeSelect.append(option);
			}
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
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
// 点击修改
function clickEditBtn() {

}
$(function() {
	initLab();
});
// ***** 预约界面 *****
function initLab() {
	var reqData = {
		'service' : 'queryLab',
		'page' : 1,
		'itemsPerPage' : 9
	}
	$.ajax({
		url : '/api/lab',
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		success : function(data) {
			addLabDiv(data);
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
}
function addLabDiv(data) {
	if ($('#labStationCon').get(0) == null) {
		return;
	}
	$('#labStationCon').get(0).innerHTML = '';
	var arrs = data.data.pdate;
	for (var i = 0; i < arrs.length; i++) {
		console.log(arrs[i]);
		var attribute = arrs[i].attribute;
		var category = arrs[i].category;
		var prop = arrs[i].prop;
		var master = arrs[i].master;
		console.log(prop);
		console.log(master);
		var labDiv = '<div class="col-xs-6 labCard" id="'+prop.bizNO+'" onclick="selectLab(this);">'
				+ '<table class="table"><caption style="text-align: center;">'
				+ '<span class="label"></span>实验室</caption><tbody>'
				+ '<tr><td><span class="label label-default">类别特性</span></td>'
				+ '<td colspan="2">'+attribute.content+' '+category.content+'</td></tr>'
				+ '<tr><td><span class="label label-default">状态</span></td>'
				+ '<td colspan="2">'+arrs[i].statuDesc+'</td></tr>'
				+ '<tr><td><span class="label label-default">负责人</span></td>'
				+ '<td colspan="2">'+master.customer.nickname+'</td></tr></tbody></table></div>';
		$('#labStationCon').append(labDiv);
	}

}
function selectLab(obj) {
	$("#" + obj.id).hide();
	// $('#labStation').hide();
	$('#selectLabStation').get(0).innerHTML = '<caption><h4>&nbsp;[&nbsp;预约单&nbsp;]</h4></caption><tbody></tbody>';
	var tr = '<tr class="selectLabRow" ><td class="selectLabRow-td-c"><h5>预约时间</h5><div class="input-group selectLabRow-td-c-input myDatepair ">'
			+ '<span class="input-group-addon">开始时间</span>'
			+ '<input type="text" class="form-control date start" placeholder="YYYY-MM-dd">'
			+ '<input type="text" class="form-control time start" placeholder="HH:mm:ss"></div>'
			+ '<div class="input-group selectLabRow-td-c-input myDatepair ">'
			+ '<span class="input-group-addon">结束时间</span>'
			+ '<input type="text" class="form-control date end" placeholder="YYYY-MM-dd">'
			+ '<input type="text" class="form-control time end" placeholder="HH:mm:ss"></div></td>'
			+ '<td class="selectLabRow-td-a" >'
			+ $("#" + obj.id).get(0).innerHTML
			+ '</td><td class="selectLabRow-td-b" >'
			+ '<button type="button"'
			+ ' class="btn btn-default selectLabRow-td-b-btn" '
			+ ' onclick="cancelReserve('
			+ obj.id
			+ ');" >取&nbsp;消</button>'
			+ '<button type="button" class="btn btn-primary selectLabRow-td-b-btn">确&nbsp;认</button></td></tr>'
			+ '<script> $(".myDatepair .time").timepicker({"showDuration": true,"timeFormat": "H:i:s"});'
			+ '$(".myDatepair .date").datepicker({"format": "yyyy-m-d","autoclose": true});</script> ';
	$('#selectLabStation').append(tr);
}
function cancelReserve(obj) {
	$("#" + obj.id).show();
	// $('#labStation').show();
	$('#selectLabStation').get(0).innerHTML = '';
}
$(function() {
	$('#datepairExample .time').timepicker({
		'showDuration' : true,
		'timeFormat' : 'g:ia'
	});

	$('#datepairExample .date').datepicker({
		'format' : 'yyyy-m-d',
		'autoclose' : true
	});
});

// ***** 预约界面 *****
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
