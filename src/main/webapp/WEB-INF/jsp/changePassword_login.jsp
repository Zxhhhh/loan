<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forgetPassword_login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>/res/css/bootstrap.css">
	
  </head>
  
  <body>
    <!-- 更改密码(登录状态下) -->
  
		  <form id="changePassForm" style="margin-left:50px">
		  	<fieldset>
				<div class="input-prepend" title="Username">
					<span class="add-on"><i class="halflings-icon lock"></i></span>
					<input class="input-large span5" type="password" name="oldPass" placeholder="原 密 码 "/>
				</div>
				<div class="clearfix"></div>
		
				<div class="input-prepend" title="Username">
					<span class="add-on"><i class="halflings-icon lock"></i></span>
					<input class="input-large span5" type="password" name="newPass" placeholder="新 密 码 "/>
				</div>
				<div class="clearfix"></div>
		
				<div class="input-prepend" title="Username">
					<span class="add-on"><i class="halflings-icon lock"></i></span>
					<input class="input-large span5" type="password" name="confirmPass" placeholder="确认新密码 "/>
				</div>
				<div class="clearfix"></div>
		  	</fieldset>
		  </form>
		  	<center>
		  		<span id="changePassTip" style="color:red"></span>
		  	</center>
  </body>
  <script type="text/javascript">
	//登录
	$("#subBtn").click(function() {
		var option = {
			url : "user/changePass_login",
			type : "post",
			timeout : 5000,
			headers : {
				"ClientCallMode" : "ajax"
			},
			success : function(data) {
				alert(data.isSuccess);
				if (data.isSuccess) {
					alert(data.data.user.username+"更改密码成功");
					window.location.href="toUserCenter_info";
				} else {
					$("#changePassTip").html(data.errorMessage).show(300);
				}
			}
		}
		$("#changePassForm").ajaxSubmit(option);
	});
  
  </script>
</html>
