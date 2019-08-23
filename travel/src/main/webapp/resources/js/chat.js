$(function() {
	$("#contentSubmit").click(function() {
		var data = 
		{
				"content" : $("#content").val(),
				"contentTime" : "systimestamp",
				"chatRoomNum" : $("#chatRoomNum").val(),
				"member" : $("#member").val()
		}
		$.ajax({
			url : "addContent",
			data : data,
			success : function(result) {
				$("#chatDiv").append(result)
			}
		})
	})
	$("#friend").click(function() {
		$.ajax({
			url : "menuChage.do",
			data : {"type" : "친구"},
			success : function(result) {
				$("#menuType").empty()
				$("#menuType").append(result)
			}
		})
	})
})