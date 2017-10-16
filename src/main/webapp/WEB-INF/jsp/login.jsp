<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/commonTag.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>借贷系统-登录</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
		
	
	<style type="text/css">
		body { background: url(../res/img/bg-login.jpg) !important; }
	</style>
		
</head>

<body>
		<div class="container-fluid-full">
		<div class="row-fluid">
					
			<div class="row-fluid">
				<div class="login-box">
					<ul class="nav nav-tabs" id="myTab">
					  <li style="width:50%;text-align:center;font-weight:bold;" class="active"><a href="#login">登录</a></li>
					  <li style="width:50%;text-align:center;font-weight:bold;"><a href="#register">注册</a></li>
					</ul>
					<div class="tab-content">
					  <div class="tab-pane active" id="login">
					  	<h2>使用用户或邮箱登录</h2>
						<form class="form-horizontal" id="loginForm" >
							<fieldset>
								<div class="input-prepend" title="Username">
									<span class="add-on"><i class="halflings-icon user"></i></span>
									<input class="input-large span10" name="nameOrMail" id="username" type="text" placeholder="用 户 名 "/>
								</div>
								<div class="clearfix"></div>
	
								<div class="input-prepend" title="Password">
									<span class="add-on"><i class="halflings-icon lock"></i></span>
									<input class="input-large span10" name="password" id="password" type="password" placeholder="密  码"/>
								</div>
								<div class="clearfix"></div>
								
								<span id="tip"style="display:none"></span>
								
								<label class="remember" for="remember"><input type="checkbox" id="remember" />记住密码</label>
	
								<div class="button-login">	
									<a href="javascript:void(0)" id="loginBtn"  class="btn btn-primary">登 录</a>
								</div>
								<div class="clearfix"></div>
						</form>
						<hr>
						<h3>忘记密码?</h3>
						<p>
							<a href="toForgetPassword">点击此处 </a> to get a new password.
						</p>	
					  </div>
					  <div class="tab-pane" id="register">
					  	<h2>用户注册</h2>
						<form class="form-horizontal" id="registerForm" >
							<fieldset>
								<div class="input-prepend" title="Username">
									<span class="add-on"><i class="halflings-icon user"></i></span>
									<input class="input-large span10" name="username" id="username" type="text" placeholder="用 户 名 "/>
								</div>
								<div class="clearfix"></div>
	
								<div class="input-prepend" title="Password">
									<span class="add-on"><i class="halflings-icon lock"></i></span>
									<input class="input-large span10" name="password" id="password" type="password" placeholder="密  码"/>
								</div>
								<div class="clearfix"></div>
								
								<div class="input-prepend" title="Password">
									<span class="add-on"><i class="halflings-icon envelope"></i></span>
									<input class="input-large span10" name="userMail" id="userMail" type="email" placeholder="邮 箱"/>
								</div>
								<div class="clearfix"></div>
								
								<center>
									<span style="color:red;display:none" id="registerErrorMessage" ></span>
								</center>
								
	
								<div class="button-login">	
									<a href="javascript:void(0)" id="registerBtn"  class="btn btn-primary">注  册</a>
								</div>
								<div class="clearfix"></div>
						</form>
						<hr>
				  
					  </div>
					</div>

				</div><!--/span-->
			</div><!--/row-->
			

	</div><!--/.fluid-container-->
	
		</div><!--/fluid-row-->
	<div id="loginModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center">
						<span class="glyphicon glyphicon-mail"></span>
						完成邮箱验证
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center">
							<input type="text" placeholder="验证码" 
								id="loginInputCode" class="form-control" />
							<button class="btn btn-default" id="sendCode" >发送验证码</button>
							<br> <span style="font-size:13px;color:gray" id="mailTip">检测到您没有激活账号，请绑定邮箱以激活账号</span>
						</div>

					</div>
				</div>

				<div class="modal-footer">
					<span id="loginMailCheckMessage" class="glyphicon"></span>
					<button type="button" id="loginMailCheckBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span> 激活账号
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<div id="registerModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"></span>
					</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center">
							<input type="text" placeholder="验证码"  id="registerInputCode" class="form-control" />
							<button class="btn btn-default">重新发送</button>
							<br>
							<span style="font-size:13px;color:gray">验证码已发送到您的邮箱，请在邮箱获取验证码并激活账号</span>
							<a id="goMailUrl" target="_blank" >马上前往-></a>
						</div>
						
					</div>
				</div>

				<div class="modal-footer">
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="registerMailCheckBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span> 激活账号
					</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	
	//登录
	$("#loginBtn").click(function() {

		var option = {

			url : "loginCheck",
			type : "post",
			timeout : 5000,
			headers : {
				"ClientCallMode" : "ajax"
			},
			success : function(data) {
				if (data.isSuccess) {
					alert(data.isSuccess);
					if (data.data.isActivate == 0) {//没有激活用户
						$("#sendCode").attr("lang",data.data.id); //把用户id存在按钮的lang属性中(要改)
						var loginModal = $("#loginModal");//获得弹出框节点
						//显示弹出层
						loginModal.modal({
							show : true, //打开弹出层
							backdrop : "static",//禁止位置关闭
							keyboard : false,//关闭键盘事件，禁止键盘关闭
						});
					}else{
						window.location.href = data.data.id+"/login";					
					}
				} else {
					$("#tip").html(data.errorMessage).show(300);
				}
			}

		};
		$("#loginForm").ajaxSubmit(option);
	});
	
	//提交邮箱验证
	$("#loginMailCheckBtn").click(function(){
		
		var id = $(this).attr("lang");
		var correctCode = $(this).attr("title");
	
		$.ajax({
			type:"post",
			url:"activity",
			async:true,
			dataType:"json",
			data:{id:id,inputCode:$("#loginInputCode").val(),correctCode:correctCode},
			success:function(data){
				alert(data.isSuccess);
				if(data.isSuccess){
					window.location.href = data.data.id+"/login";
				}else{
					var loginMailCheckMessage = $("#loginMailCheckMessage");
					//先hide()再show(300)是为了有更好的用户体验，隐藏中间的执行过程
					loginMailCheckMessage.hide().html("<label class='label label-danger'>"+data.errorMessage+"</label>").show(300);
				}
			
			}
		});
	});
	
	//发送邮件
	$("#sendCode").click(function(){
		
		$.ajax({
			
			url:"sendCheckMail",
			type:"post",
			async:true,
			data:{id:$("#sendCode").attr("lang")},
			dataType:"json",
			success:function(data){
				if(data.isSuccess){
					$("#loginMailCheckBtn").attr("title",data.mailCheckCode);
		  			$("#loginMailCheckBtn").attr("lang",data.data.id);
		  			$("#mailTip").hide().html("邮件已发送，请输入验证码以激活账号:<a href='http://"+data.targetMailUrl+"'></a>").show(300);
				}else{
					$("#mailTip").hide().html(data.errorMessage).show(300);
				}
			}
		});
	});
	
	//--------------------------------------------注册--------------------------------//
	
    //注册
	$("#registerBtn").click(function(){
		
			alert(1324);
			
			//异步上传表单
		  	 var option = {
		  	
		  		url:"register",
		  		type:"post",
		  		timeout: 8000,               
		  		headers:{"ClientCallMode":"ajax"},
		  		success:function(data){
		  				alert(data.isSuccess);
		  				if(data.isSuccess){
		  					$("#registerMailCheckBtn").attr("title",data.mailCheckCode);
		  					$("#registerMailCheckBtn").attr("lang",data.data.id);
		  					$("#goMailUrl").attr("href",data.targetMailUrl);
		  					alert($("#goMailUrl").attr("href"));
			  				var registerModal = $("#registerModal");//获得弹出框节点
							//显示弹出层
							registerModal.modal({
								show : true, //打开弹出层
								backdrop : "static",//禁止位置关闭
								keyboard : false,//关闭键盘事件，禁止键盘关闭
							});
						}else{
							$("#registerErrorMessage").html(data.errorMessage).show(300);
						} 		
		  		}
		  			//layer.closeAll("loading"); 
		  			
		  	  };
		  		
/* 		  		 beforeSend:function(){
		  			layer.load();
		  		},  */
		  		
/* 		  		error:function(textStatus, errorThrown){
		  			
		  			layer.closeAll("loading"); 
		  		} */
		  	$("#registerForm").ajaxSubmit(option); 

	});
	
	//提交邮箱验证
	$("#registerMailCheckBtn").click(function(){
		
		var id = $(this).attr("lang");
		var correctCode = $(this).attr("title");
	
		$.ajax({
			type:"post",
			url:"activity",
			async:true,
			dataType:"json",
			data:{id:id,inputCode:$("#registerInputCode").val(),correctCode:correctCode},
			success:function(data){
				alert(data.isSuccess);
				if(data.isSuccess){
					window.location.href=data.data.id+"/toUserInfo";
				}else{
					var killPhoneMessage = $("#killPhoneMessage");
					//先hide()再show(300)是为了有更好的用户体验，隐藏中间的执行过程
					killPhoneMessage.hide().html("<label class='label label-danger'>"+data.errorMessage+"</label>").show(300);
				}
			
			}
		});
	
	});
	
</script>
</html>
