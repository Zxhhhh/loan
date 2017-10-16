<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
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
	<title>借贷系统-忘记密码</title>
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
						忘 记 密 码
					</div>
					<h4 style="text-align:center;">找回流程:输入用户 > 选择找回方式  > 验证  > 重置密码</h4>
					<form class="form-horizontal" id="myForm" >
						<fieldset>
							<div class="input-prepend" title="Phone">
								<span class="add-on">用户名:</span>
								<input type="text" value="" id="checkIpt" />
							</div>
							<div class="clearfix"></div>
							
							<center>
								<span style="color:red;display:none" id="tip" ></span>
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
		
	<!-- 登录弹出层，进行密码验证 -->
	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-left">密码找回方式:</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div style="float:left;width:50%">
							<div align="center">
								<div id="mailArea">
									<button class="btn btn-default btn-lg" id="sendCode">邮箱验证找回</button>
								</div>
								<br> <br> <span
									style="font-size:13px;color:gray" id="mailTip">发送验证码到用户邮箱</span>
							</div>
						</div>
						<div style="float:right;width:50%">
							<div align="center">
								<div  id="secureArea">
									<button class="btn btn-default btn-lg" id="secureQues">安全问题找回</button>
								</div>
								<br> <br> <span
									style="font-size:13px;color:gray" id="quesTip">通过安全问题找回密码</span>
							</div>
						</div>

					</div>
				</div>

				<div class="modal-footer">
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="killPhoneBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span> 找回密码
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
<script type="text/javascript">
	$("#subBtn")
			.click(
					function() {
						$("#tip").html("");
						$.ajax({
									type : "post",
									url : "checkUser",
									data : {
										username : $("#checkIpt").val()
									},
									dataType : "json",
									success : function(data) {
										if (data.isSuccess) {
											var killPhoneModal = $("#killPhoneModal");//获得弹出框节点
											killPhoneModal.modal({
												show : true, //打开弹出层
												backdrop : "static",//禁止位置关闭
												keyboard : false,//关闭键盘事件，禁止键盘关闭
											});
											$("#killPhoneBtn").attr("lang",data.data.user.id);//把id暂存
											if (data.data.userSecure == null) {
												$("#secureQues").attr("disabled","disabled");
												$("#quesTip").html("<span style='color:red'>用户未进行安全绑定，无法使用安全问题</span>");
											}else{
												$("#secureQues").attr("title",data.data.userSecure.secureQuestion);
											}
										} else {
											$("#tip").html(data.errorMessage);
										}
									}
								})
					});

	//发送邮件
	$("#sendCode").click(function(){
				$.ajax({
									url : "sendCheckMail",
									type : "post",
									async : true,
									data : {
										id : $("#killPhoneBtn").attr("lang")
									},
									dataType : "json",
									success : function(data) {
										if (data.isSuccess) {
											$("#killPhoneBtn").attr("title",
													data.mailCheckCode);
											$("#killPhoneBtn").attr("lang",
													data.data.id);
											$("#mailTip")
													.hide()
													.html(
															"邮件已发送，请输入验证码以验证账号<br/><a href='http://"+data.targetMailUrl+"'>马上前往</a>")
													.show(300);
											$("#mailArea").html("<input placeholder='验证码' class='form-control' id='inputCode' /> <button class='btn btn-default ' id='sendCode'  >重发</button>");
											$("#secureQues").attr("disabled","disabled");
										} else {
											$("#mailTip").hide().html(
													data.errorMessage)
													.show(300);
										}
									}
								});
					});
	
	$("#secureQues").click(function(){

		var secureQues = $("#secureQues").attr("title");
		$("#secureArea").html("<input placeholder='安全问题答案' class='form-control' id='quesAnswer' />");
		$("#quesTip").html("<h3>安全问题:"+secureQues+"</h3>");
		$("#sendCode").attr("disabled","disabled");
	});
				
	//提交验证
	$("#killPhoneBtn").click(function(){
		var sendCode = $("#sendCode");
		var secureQues = $("#secureQues");
		alert(sendCode.attr("disabled")+"--"+secureQues.attr("disabled"));
		if(sendCode.attr("disabled")==undefined){
			var id = $(this).attr("lang");
			var correctCode = $(this).attr("title");
			alert(id+"--"+correctCode);
			if(correctCode!=undefined){
				$.ajax({
					type:"post",
					url:"check",
					async:true,
					dataType:"json",
					data:{id:id,inputCode:$("#inputCode").val(),correctCode:correctCode},
					success:function(data){
						alert(data.isSuccess);
						if(data.isSuccess){
							window.location.href = data.data.id+"/toChangePass";
						}else{
							var killPhoneMessage = $("#killPhoneMessage");
							//先hide()再show(300)是为了有更好的用户体验，隐藏中间的执行过程
							killPhoneMessage.hide().html("<label class='label label-danger'>"+data.errorMessage+"</label>").show(300);
						}
					}
				}); 
			}else{
				var killPhoneMessage = $("#killPhoneMessage");
				killPhoneMessage.hide().html("<label class='label label-danger'>请先发送验证邮件</label>").show(300);
			}
		}else if(secureQues.attr("disabled")==undefined){
			alert("这是安全问题检验");
			$.ajax({
				type:"post",
				url:"checkQuesAnswer",
				async:true,
				data:{id:$("#killPhoneBtn").attr("lang"),quesAnswer:$("#quesAnswer").val()},
				dataType:"json",
				success:function(data){
					alert(data.isSuccess);
					if(data.isSuccess){
						alert("进入");
						window.location.href ="/loan/user/"+ data.data.id+"/toChangePass";
					}else{
						var killPhoneMessage = $("#killPhoneMessage");
						//先hide()再show(300)是为了有更好的用户体验，隐藏中间的执行过程
						killPhoneMessage.hide().html("<label class='label label-danger'>"+data.errorMessage+"</label>").show(300);
					}
				}
			});
		}
	});
</script>
</html>

