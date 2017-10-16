<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>借贷系统-更改密码</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	
			<style type="text/css">
			body { background: url(/loan/res/img/bg-login.jpg) !important; }
		</style>
		
		
		
</head>

<body>
		<div class="container-fluid-full">
		<div class="row-fluid">
					
			<div class="row-fluid">
				<div class="login-box">
					<div class="icons" style="text-align:center;font-weight:bold;font-size:17px ">
						更 换 密 码
					</div>
					<h2>请输入新密码:应由数字与小写字母组成</h2>
						<form class="form-horizontal" id="myForm" >
							<input type="hidden" name="id" value="${id}" />
							<fieldset>
								<div class="input-prepend" title="Password">
									<span class="add-on"><i class="halflings-icon user"></i></span>
									<input class="input-large span10" name="newPassword"  type="password" placeholder="新 密 码 "/>
								</div>
								<div class="clearfix"></div>
	
								<div class="input-prepend" title="Password">
									<span class="add-on"><i class="halflings-icon lock"></i></span>
									<input class="input-large span10"  type="password" name="confirmPassword" id="confirmPassword" placeholder="确认新密码"/>
								</div>
								<div class="clearfix"></div>
								
								<center>
									<span style="color:red;display:none" id="tip" ></span>
								</center>
								
	
								<div class="button-login">	
									<a href="javascript:void(0)" id="subBtn"  class="btn btn-primary">更 改</a>
								</div>
								<div class="clearfix"></div>
							</fieldset>
						</form>						
					<hr>	
				</div><!--/span-->
			</div><!--/row-->
			

	</div><!--/.fluid-container-->
	
		</div><!--/fluid-row-->
	
</body>
<script type="text/javascript">
  	$("#subBtn").click(function(){
  		var option = {
  		
  			url : "/loan/user/changePass",
			type : "post",
			timeout : 5000,
			headers : {
				"ClientCallMode" : "ajax"
			},
			success:function(data){
				if(data.isSuccess){
					layer.alert("密码修改完成，请重新登录<br><a href='user/toLogin'>返回</a>");
					window.location.href="/loan/user/toLogin";
				}else{
					$("#tip").html(data.errorMessage);
				}
			}
  		};
  		$("#myForm").ajaxSubmit(option);
  	});
</script>
</html>
