<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#btn1").click(function(){
		$.ajax({
			url : '/jersey-ajax/rest/user/add',
			type : 'POST',
			data : {name:"posly",age:29},
			dataType : 'json',
			contentType:'application/json',
			async : false,
			success : function(data) {
				console.log("data.status:"+data.status);
				console.log("data.information:"+data.information);
			},
			error : function() {
				alert("error");
			}
		});
	});
});

</script>
</head>
<body>
<button id="btn1">添加用户</button>
</body>
</html>
