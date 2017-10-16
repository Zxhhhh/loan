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
	<title>完善个人资料</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
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
						完善个人信息
					</div>
					<form class="form-horizontal" id="myForm">
						<input type="text" name="userId" value="${id}" readonly="readonly" />
						<fieldset>
							<div class="input-prepend" title="Phone">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="userPhone" id="username" type="text" placeholder="手 机 号 "/>
							</div>
							<div class="clearfix"></div>

							
							<div class="input-prepend" title="Sex">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="userAddr" id="userAddr" type="text" placeholder="联 系 地 址"/>
							</div>
							<div class="clearfix"></div>
							
							<div class="input-prepend" title="Age">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="userAge" id="userAge" type="text" placeholder="年龄"/>
							</div>
							<div class="clearfix"></div>
							
							<div style="margin-left:27px">
								<span class="add-on">性 别</span>
								<label class="radio inlines">
									<input  type="radio" name="userSex" value="m" /> 男
									<input  type="radio" name="userSex" value="f" /> 女
								</label>
							</div>
							<div class="clearfix"></div>
							
							<center>
								<span style="color:red;display:none" id="userInfoErrorMessage" ></span>
							</center>
							

							<div class="button-login">	
								<a href="javascript:void(0)" id="subBtn"  class="btn btn-primary">提 交</a>
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
	  	
	  		url:"/loan/user/infoImprove",
	  		type:"post",
	  		timeout:8000,
	  		headers:{"ClientCallMode":"ajax"},
	  		success:function(data){
	  			alert(data.isSuccess);
	  			if(data.isSuccess){
	  				window.location.href="integrationUser";
	  			}else{
	  				$("tips").hide().html(data.errorMessage).show(300);
	  			}
	  		}
	  	};
	  	
	  	$("#myForm").ajaxSubmit(option); 
	  
	  });
  
  </script>
</html>