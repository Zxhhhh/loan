<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%session.setAttribute("admin","admin"); %>
<%@ include file="common/commonTag.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	注册.
	<br>
	<form action="" id="myForm" >
		账号<input id="me" type="text" name="username" /><br> 密码<input
			type="password" name="password" /><br> 邮箱<input type="email"
			name="userMail" /><br>
			<span style="color:red;display:none" id="errorMessage" ></span>
	</form>
	<button id="subBtn">注册</button>

	<!-- 登录弹出层，输入邮箱验证码 -->
	<div id="killPhoneModal" class="modal fade">
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
							<input type="text" placeholder="验证码" name="killPhone" id="inputCode" class="form-control" />
							<button class="btn btn-default">重新发送</button>
							<br>
							<span style="font-size:13px;color:gray">验证码已发送到您的邮箱，请在邮箱获取验证码并激活账号</span>
							<a id="goMailUrl" target="_blank" >马上前往-></a>
						</div>
						
					</div>
				</div>

				<div class="modal-footer">
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="killPhoneBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span> 激活账号
					</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	//注册
	$("#subBtn").click(function(){
		
			alert(1324);
			
			//异步上传表单
		  	 var option = {
		  	
		  		url:"user/register",
		  		type:"post",
		  		timeout: 8000,               
		  		headers:{"ClientCallMode":"ajax"},
		  		success:function(data){
		  				
		  				alert(data.isSuccess);
		  				
		  				if(data.isSuccess){
		  					$("#killPhoneBtn").attr("title",data.mailCheckCode);
		  					$("#killPhoneBtn").attr("lang",data.data.id);
		  					$("#goMailUrl").attr("href",data.targetMailUrl);
		  					alert($("#goMailUrl").attr("href"));
			  				var killPhoneModal = $("#killPhoneModal");//获得弹出框节点
							//显示弹出层
							killPhoneModal.modal({
								show : true, //打开弹出层
								backdrop : "static",//禁止位置关闭
								keyboard : false,//关闭键盘事件，禁止键盘关闭
							});
						}else{
							$("#errorMessage").html(data.errorMessage).show(300);
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
		  	$("#myForm").ajaxSubmit(option); 

	});
	
	//提交邮箱验证
	$("#killPhoneBtn").click(function(){
		
		var id = $(this).attr("lang");
		var correctCode = $(this).attr("title");
	
		$.ajax({
			type:"post",
			url:"user/activity",
			async:true,
			dataType:"json",
			data:{id:id,inputCode:$("#inputCode").val(),correctCode:correctCode},
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
