<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有用户</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script>
$(document).ready(function(){
  $("#btn1").click(function(){
	  $.ajax({
		url : '/jersey-ajax/rest/user/findUsers',
		type: "get",
		dataType: "json",
      contentType:"application/json",  
		complete:function(){$("#load").hide();},
		success:function(msg){//返回的msg是一个json对象
			console.log('msg：',msg); 
			var jsonObj = eval(msg); //将String转换为json对象
			console.log("jsonObj:",jsonObj);
			var text = JSON.stringify(msg); //将json对象转换为String
			console.log("text:",text);
			//JSON解析只会识别JSON文本并且它更安全,下面调用json的parse函数对文本数据转换生成json数据结构 
			//var obj = JSON.parse(jsontext);
			console.log("obj:"+obj);
		},
		error:function()
		{  
	    		alert("系统出现问题");      
		} 
	});
  });
});

</script>
</head>
<body>
<button id="btn1">查询所有用户</button>
<button id="load">loading</button>
</body>
</html>
