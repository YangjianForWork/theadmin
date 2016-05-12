$(function() {
	clearAlertContaint();
	$('#loginBtn').click(function() {
		console.log($('#userName').get(0).value);
		console.log($('#pwd').get(0).value);
		var reqData = {
			"userName" : $('#userName').get(0).value,
			"pwd" : $('#pwd').get(0).value
		}
		$.ajax({
			url : '/api/dologin',
			data : reqData,
			type : 'POST',
			cache : false,
			dataType : 'json',
			success : function(data) {
				$('#secondLogin').submit();
			},
			error : function(data) {
				var respData = eval('(' + data.responseText + ')');
				alert_info(respData.resuDesc);
			}
		});
	});
});

//弹出框
function alert_info(msg) {
	clearAlertContaint();
	var myAlert = '<div id="myAlert" class="alert alert-info"> ' + msg
			+ '</div>';
	$('#alertCont').get(0).innerHTML = myAlert;
	setTimeout("clearAlertContaint()", 1250);
}
//清楚alertContain
function clearAlertContaint() {
	$('#alertCont').get(0).innerHTML = '';
}