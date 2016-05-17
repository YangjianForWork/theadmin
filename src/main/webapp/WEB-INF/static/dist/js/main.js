var indexNum = 0;
$(function() {
	var reqData = {};
	/*
	 * ajaxSeq(reqData, '11', true); ajaxSeq(reqData, '12', true);
	 * ajaxSeq(reqData, '21', true); ajaxSeq(reqData, '22', true);
	 */
	clearAlertContaint();
	// ajaxSeq(reqData, '31', true);
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
// 转化时间
function dateFormatType(millsTime) {
	var date = new Date(millsTime);
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	month = month > 9 ? month : ('0' + month);
	var day = date.getDate() > 9 ? date.getDate() : ('0' + date.getDate());
	var hour = date.getHours() > 9 ? date.getHours() : ('0' + date.getHours());
	var minute = date.getMinutes() > 9 ? date.getMinutes() : ('0' + date
			.getMinutes());
	var second = date.getSeconds() > 9 ? date.getSeconds() : ('0' + date
			.getSeconds());
	return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':'
			+ second;
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
	setTimeout("clearAlertContaint()", 2550);
}
// 模态框
function myModelForm(bodyStr, footerStr) {
	$('#myModelBody').get(0).innerHTML = bodyStr;
	$('#myModelFooter').get(0).innerHTML = footerStr;
	$('#modelActiveBtn').click();
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
	$('#modelActiveBtn').hide();
});
// ***** 预约界面 *****
var labStatusResult = true;
function initLab() {
	indexNum = 0;
	$('#reserveList').hide();
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
	for (var i = arrs.length - 1; i >= 0; i--) {
		var prop = arrs[i].prop;
		var labDiv = '<div class="col-xs-6 labCard" id="' + prop.bizNO
				+ '" onclick="selectLab(this);">' + getLabCardTable(arrs[i])
				+ '</div>';
		$('#labStationCon').append(labDiv);
	}
}
function getLabCardTable(obj) {
	var attribute = obj.attribute;
	var category = obj.category;
	var prop = obj.prop;
	var master = obj.master;
	// var class_status = 'labCard-status-' + prop.status;
	var tableStr = '<table class="table"><caption style="text-align: center;">'
			+ '<span class="label"></span>'
			+ prop.name
			+ '</caption><tbody>'
			+ '<tr><td><span class="label label-default">类别特性</span></td>'
			+ '<td colspan="2">'
			+ category.content
			+ ' '
			+ attribute.content
			+ '</td></tr>'
			+ '<tr><td><span class="label label-default"> 当前/最多 预约人数</span></td>'
			+ '<td colspan="2" >' + obj.currResCount + '/' + prop.content
			+ ' (人)</td></tr>'
			+ '<tr><td><span class="label label-default">负责人</span></td>'
			+ '<td colspan="2">' + master.prop.name
			+ '</td></tr></tbody></table>';
	return tableStr;
}
function selectLab(obj) {
	$('#labStation').hide();
	indexNum = 1;
	var selectLabStation = $('#selectLabStation').get(0);
	/*
	 * var ele = selectLabStation.childNodes; if (ele.length && ele.length > 0) {
	 * alert_info("您已选择一个实验室，请勿重复操作"); return; } updateStatus(obj.id, 2);
	 */
	if (labStatusResult) {
		$("#" + obj.id).hide();
		// console.log($("#" + obj.id).get(0));
		var labData = null;
		var reqData = {
			'service' : 'getLab',
			'bizNO' : obj.id,
		}
		$.ajax({
			url : '/api/lab',
			data : reqData,
			type : 'POST',
			cache : false,
			dataType : 'json',
			async : false,
			success : function(data) {
				labData = data;
			},
			error : function(data) {
				var respData = eval('(' + data.responseText + ')');
				alert_info(respData.resuDesc);
			}
		});
		$('#selectLabStation').get(0).innerHTML = '<caption><h4>&nbsp;[&nbsp;预约单&nbsp;]</h4></caption><tbody></tbody>';
		var tr = '<tr class="selectLabRow" ><td class="selectLabRow-td-c"><h5>预约时间</h5><div class="input-group selectLabRow-td-c-input myDatepair ">'
				+ '<span class="input-group-addon">开始时间</span>'
				+ '<input type="text" class="form-control date start" id="dateStart" placeholder="YYYY-MM-dd">'
				+ '<input type="text" class="form-control time start" id="timeStart" placeholder="HH:mm:ss"></div>'
				+ '<div class="input-group selectLabRow-td-c-input myDatepair ">'
				+ '<span class="input-group-addon">结束时间</span>'
				+ '<input type="text" class="form-control date end" id="dateEnd" placeholder="YYYY-MM-dd">'
				+ '<input type="text" class="form-control time end" id="timeEnd" placeholder="HH:mm:ss"></div></td>'
				+ '<td class="selectLabRow-td-a" >'
				+ getLabCardTable(labData.data)
				+ '</td><td>'
				+ getLabDetail(labData.data)
				+ '</td><td class="selectLabRow-td-b" >'
				+ '<button type="button"'
				+ ' class="btn btn-default selectLabRow-td-b-btn" id="'
				+ obj.id
				+ '" onclick="cancelReserve(this);" >取&nbsp;消</button>'
				+ '<button type="button" class="btn btn-primary selectLabRow-td-b-btn" id="'
				+ obj.id
				+ '" onclick="confirmReserve(this);">确&nbsp;认</button></td></tr>'
				+ '<script> $(".myDatepair .time").timepicker({"showDuration": true,"timeFormat": "H:i:s"});'
				+ '$(".myDatepair .date").datepicker({"format": "yyyy-m-d","autoclose": true});</script> ';
		$('#selectLabStation').append(tr);
	}
}
function getLabDetail(obj) {
	var tableStr = '<table class="table"><caption><span>&nbsp;</span></caption><tbody>'
			+ '<tr><td><span class="label label-default">位置</span></td>'
			+ '<td colspan="2">'
			+ obj.prop.address
			+ '</td></tr>'
			+ '<tr><td><span class="label label-default">负责人职务</span></td>'
			+ '<td colspan="2">'
			+ obj.master.role
			+ '</td></tr>'
			+ '<tr><td><span class="label label-default">负责人联系方式</span></td>'
			+ '<td colspan="2">'
			+ obj.master.customer.mobile
			+ '<input type="hidden" id="dealPersNO" value="'
			+ obj.master.prop.bizNO + '" ></td></tr></tbody></table>';
	return tableStr;
}
function cancelReserve(obj) {
	$('#labStation').show();
	indexNum = 0;
	// console.log(obj);
	// updateStatus(obj.id, 1);
	if (labStatusResult) {
		$("#" + obj.id).show();
		$('#selectLabStation').get(0).innerHTML = '';
	}
}
function confirmReserve(obj) {
	// console.log(obj.id);
	// console.log($("#" + obj.id).get(0));
	var result = false;
	var dateStart = $('#dateStart').get(0).value;
	var timeStart = $('#timeStart').get(0).value;
	var dateEnd = $('#dateEnd').get(0).value;
	var timeEnd = $('#timeEnd').get(0).value;
	if (dateStart == '' || dateStart == '' || dateStart == ''
			|| dateStart == '') {
		alert_info("时间字段不能为空");
	}
	var startD = dateStart + ' ' + timeStart;
	var endD = dateEnd + ' ' + timeEnd;
	var labNO = obj.id;
	var dealPersNO = $('#dealPersNO').get(0).value;
	var reqData = {
		"service" : "submitReserve",
		"startDateStr" : startD,
		"endDateStr" : endD,
		"prop.dealPersNO" : dealPersNO,
		"prop.labNO" : labNO
	}
	$.ajax({
		url : '/api/reserve',
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		async : false,
		success : function(data) {
			result = true;
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
			result = false;
		}
	});
	if (result) {
		alert_info("预约成功！");
		initLab();
		$('#selectLabStation').get(0).innerHTML = '';
		$('#labStation').show();
		indexNum = 0;
	}
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
function updateStatus(id, key) {
	var status = '';
	switch (key) {
	case 1:
		status = 'NORMAL';
		break;
	case 2:
		status = 'RESERVE';
		break;
	case 3:
		status = 'IN_USE';
		break;
	}
	var reqData = {
		'service' : 'updateLabStatus',
		'bizNO' : id,
		'status' : status
	}
	$.ajax({
		url : '/api/lab',
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		async : false,
		success : function(data) {
			labStatusResult = true;
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
			labStatusResult = false;
		}
	});
}
function queryReserve() {
	if ($('#reserveList').get(0) == null) {
		return;
	}
	$('#reserveList').get(0).innerHTML = '';
	var reqData = {
		'service' : 'query',
		'page' : 1,
		'itemsPerPage' : 40
	}
	$.ajax({
		url : '/api/reserve',
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		success : function(data) {
			initReserveListTable(data);
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});

}
function initReserveListTable(data) {
	$('#labStation').hide();
	indexNum = 2;
	var theadStr = '<thead><tr><td>预约单号</td><td>提交预约时间</td>'
			+ '<td>预约者</td><td>状态</td><td>实验室</td>'
			+ '<td>处理者</td><td>处理信息</td><td>预约开始时间</td>'
			+ '<td>预约结束时间</td><td>处理</td></tr></thead>';
	$('#reserveList').append(theadStr);
	$('#reserveList').append('<tbody></tbody>');
	var arrs = data.data.pdate;
	for (var i = 0; i < arrs.length; i++) {
		// console.log(arrs[i]);
		var roleLevel = arrs[i].roleLevel;
		var prop = arrs[i].prop;
		var applyPer = arrs[i].applyPer;
		var dealPer = arrs[i].dealPer;
		var lab = arrs[i].lab;
		var btnStr = '';
		if (roleLevel > 2) {
			btnStr = '<button type="button" class="btn btn-primary"'
					+ ' onclick="hideReserveList();">返&nbsp;回</button>';
		}
		if (roleLevel <= 2) {
			if (prop.status == 'WAIT_ADUIT') {
				btnStr = '<button type="button" class="btn btn-primary" id="a'
						+ prop.bizNO
						+ '" onclick="agreeRes(this);" >同意</button>&nbsp;'
						+ '<button type="button" class="btn btn-primary" id="r'
						+ prop.bizNO
						+ '" onclick="refuseResModel(this);" >拒绝</button>';
			}
			if (prop.status != 'WAIT_ADUIT') {
				btnStr = '<button type="button" class="btn btn-primary"'
						+ ' onclick="hideReserveList();">返&nbsp;回</button>';
			}
		}
		var trStr = '<tr><td>' + prop.bizNO + '</td><td>'
				+ dateFormatType(prop.bookDate) + '</td><td>'
				+ applyPer.prop.name + '</td><td>' + arrs[i].statusDesc
				+ '</td><td>' + lab.prop.name + '</td><td>' + dealPer.prop.name
				+ '</td><td>' + prop.dealReson + '</td><td>'
				+ dateFormatType(prop.beginDate) + '</td><td>'
				+ dateFormatType(prop.finishDate) + '</td><td>' + btnStr
				+ '</td></tr>';
		$('#reserveList').append(trStr);
	}
	$('#reserveList').show();
}
function hideReserveList() {
	$('#labStation').show();
	indexNum = 0;
	$('#reserveList').hide();
}
// --按钮结果
var resultStr = '';
function agreeRes(btn) {
	resultStr = "AGREE";
	adultReserve(btn.id);
}
function refuseRes(btn) {
	resultStr = "REFUSE";
	adultReserve(btn.id);
}
function refuseResModel(btn) {
	var bodyStr = '请填写原因：<input id="dealReson" />';
	var footerStr = '<button type="button" class="btn btn-default" '
			+ ' data-dismiss="modal">关闭</button>&nbsp;'
			+ '<button type="button" id="' + btn.id
			+ '" class="btn btn-primary" data-dismiss="modal" '
			+ ' onclick="refuseRes(this);" >确认</button>';
	myModelForm(bodyStr, footerStr);
}
function adultReserve(id) {
	var id = id.substring(1, id.length).trim();
	var reson = '';
	if ($('#dealReson') != null && $('#dealReson').get(0) != null) {
		reson = $('#dealReson').get(0).value;
	}
	reson = reson.trim();
	if (resultStr == 'REFUSE' && reson == '') {
		alert_info("原因未填写");
	}
	if (resultStr == 'AGREE') {
		reson = "符合情况";
	}
	var reqData = {
		"service" : "adultReserve",
		"prop.bizNO" : id,
		"adultStr" : resultStr,
		"prop.dealReson" : reson
	}
	$.ajax({
		url : '/api/reserve',
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		async : false,
		success : function(data) {
			alert_info("处理成功");
			queryReserve();
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
}
function wakeLabSiteList(id) {
	var reqData = {
		"service" : "getLabSiteList",
		"labNO" : id
	}
	$.ajax({
		url : '/api/lab',
		data : reqData,
		type : 'POST',
		cache : false,
		dataType : 'json',
		async : false,
		success : function(data) {
			initLabSiteStation(data);
		},
		error : function(data) {
			var respData = eval('(' + data.responseText + ')');
			alert_info(respData.resuDesc);
		}
	});
}
function initLabSiteStation(data) {
	$('#labStation').hide();
	indexNum = 3;
	$('#labSiteStation').get(0).innerHTML = '';
	var theadStr = '<thead><tr><td>实验室</td><td>座位号</td>'
			+ '<td>状态</td><td>实验者</td><td>处理</td></tr></thead>';
	$('#labSiteStation').append(theadStr);
	$('#labSiteStation').append('<tbody></tbody>');
	var arrs = data.data.pdate;
	for (var i = 0; i < arrs.length; i++) {
		var prop = arrs[i].prop;
		var tr = '<tr><td>' + prop.labNO + '</td><td>' + prop.siteNO + '</td>'
				+ '<td>' + prop.status + '</td><td>' + prop.currPers
				+ '</td><td>处理</td></tr>';
		$('#labSiteStation').append(tr);
	}
	$('#labSiteStation').show();
}
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
