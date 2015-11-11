<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>helloworld</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
</head>

<body>
	<script type="text/javascript">
		function User(userId, name) {
			this.userId = userId;
			this.name = name;
		}
		function requestServlet() {
			var urlStr = "/RestWeb/servlet/helloServlet";
			var user = JSON.stringify(new User(101, "阿猫"));////将json对象转换为String

			//调用JQuery提供的Ajax方法 
			$.ajax({
				type : "POST",
				url : urlStr,
				data : user,
				dataType : "json",//此处要设置成jason 
				success : callback,
				error:function()
				{  
			    		alert("系统出现问题");      
				}  
			});//回调函数 
		}
		function callback(jasonObj) {
			console.log("obj:"+jasonObj);
			var obj = eval(jasonObj);//将String转换为json对象
			console.log("errNum:"+obj.errNum+",errInfo:"+obj.errInfo);
		}
		requestServlet();
	</script>
</body>
</html>
