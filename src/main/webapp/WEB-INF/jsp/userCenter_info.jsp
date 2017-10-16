<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
	  .infotd{
	  	text-align:center;
	  }
	  
	  .value{
	  	font-weight: bold;
	  }
	  
	</style>
	
  </head>
  
  <body>
  	 <%@include file="common/navbar.jsp" %>
  	 
  	 <div class="container-fluid-full">
		<div class="row-fluid">
		
		<%@include file="common/sidebar.jsp" %>
		
		<noscript>
			<div class="alert alert-block span10">
				<h4 class="alert-heading">Warning!</h4>
				<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
			</div>
		</noscript>
		
		<div id="content" class="span10">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					借贷系统 
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="index/toIndex">首页 </a>
					<i class="icon-angle-right"></i>
				</li>
				<li>个人中心</li>
			</ul>

			<div class="row-fluid">	
				<div class="box blue span12">
					<div class="box-header">
					
					</div>
					<div class="box-content">
						
						<a class="quick-button span2">
							<i class="icon-group"></i>
							<p>我 的 资 料</p>
							<span class="notification blue">1.367</span>
						</a>
						<a class="quick-button span2" href="index/toFeedbackRecord">
							<i class="icon-comments-alt"></i>
							<p>我 的 反馈</p>
							<span class="notification green">167</span>
						</a>
						<a class="quick-button span2" href="index/toRemindCenter">
							<i class="icon-envelope"></i>
							<p>我 的 消 息</p>
						</a>
						<a class="quick-button span2" href="index/toLoanRecord">
							<i class="icon-shopping-cart"></i>
							<p>我 的 贷 款</p>
						</a>
						<a class="quick-button span2" href="index/toUserRole">
							<i class="icon-barcode"></i>
							<p>我 的  权 限</p>
						</a>
						<a class="quick-button span2">
							<i class="icon-calendar"></i>
							<p>我 的 实 名</p>
							<span class="notification red">68</span>
						</a>
						<div class="clearfix"></div>
					</div>	
				</div><!--/span-->
			</div>
			<div class="row-fluid sortable ui-sortable">
				<div class="box span7">
					<div class="box-header" data-original-title="">
						<h2><i class="halflings-icon user"></i><span class="break"></span>
						个人信息
						</h2>
						<div class="box-icon">
							<a class="btn-minimize" href="#"><i class="halflings-icon white chevron-up"></i></a>
							<a class="btn-close" href="#"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<center>
							<table style="width:50%" class="table table-hover">
								<tbody>
									<tr>
										<td style="text-align:center" colspan="2">
											<center>
												<img src="<%=basePath %>${user.userInfo.userLogo}" style="border-radius:10px" width="80" height="80"  />
											</center>
										</td>
									</tr>
									<tr>
										<td class="infotd">用户名:</td>
										<td class="infotd value" >${user.user.username }</td>
									</tr>
									<tr>
										<td class="infotd">手 机:</td>
										<td class="infotd value" >${user.userInfo.userPhone }</td>
									</tr>
									<tr>
										<td class="infotd">邮 箱:</td>
										<td class="infotd value" >${user.user.usermail }</td>
									</tr>
									<tr>
										<td class="infotd">地 址 :</td>
										<td class="infotd value" >${user.userInfo.userAddr }</td>
									</tr>
									<tr>
										<td class="infotd">性 别 :</td>
										<td class="infotd value" >
											<c:choose>
												<c:when test="${user.userInfo.userSex=='m' }">男</c:when>
												<c:otherwise>女</c:otherwise>
											</c:choose>										
										</td>
									</tr>
									<tr>
										<td class="infotd">年 龄 :</td>
										<td class="infotd value" >${user.userInfo.userAge}</td>
									</tr>
									<tr>
										<td></td>
										<td>
											<button class="btn btn-primary" id="infoDetail">修改资料</button>
											&nbsp;&nbsp;
											<a class="btn btn-primary" id="toChangePassBtn" href="javascript:void(0)">修改密码</a>
										</td>
									</tr>																											
								</tbody>
							</table>
						</center>
					</div>
				</div>
				
				<div class="box span5">
					<div class="box-header" data-original-title="">
						<h2><i class="halflings-icon inbox"></i><span class="break"></span>实名认证</h2>
						<div class="box-icon">
							<a class="btn-minimize" href="#"><i class="halflings-icon white chevron-up"></i></a>
							<a class="btn-close" href="#"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<c:choose>
							<c:when test="${user.userInfo.userRealname==null}">
								<center>
									<h4 style="color:gray">尚未进行实名认证 <a href="index/toCertification" class="toSecureSetBtn">马上设置</a></h4>
								</center>
							</c:when>
							<c:otherwise>
								<h4>已完成实名认证</h4>
								<table class="table">
									<tbody>
										<tr>
											<td>真实姓名:</td>
											<td class="value"><span style="font-weight:bold;">${user.userInfo.userRealname}</span></td>
										</tr>
										<tr>
											<td>身份证号:</td>
											<td class="value"><span style="font-weight:bold;">${user.userInfo.userIdentitynum}</span></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td>
												<a class="btn btn-primary" href="index/toCertification">查看实名详细</a>
											</td>
										</tr>
									</tbody>
								</table>
							</c:otherwise>
						</c:choose>	
					</div>
				</div>
				
				<div class="box span5">
					<div class="box-header" data-original-title="">
						<h2><i class="halflings-icon inbox"></i><span class="break"></span>安全设置</h2>
						<div class="box-icon">
							<a class="btn-minimize" href="#"><i class="halflings-icon white chevron-up"></i></a>
							<a class="btn-close" href="#"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<c:choose>
							<c:when test="${user.userSecure==null }">
								<center>
									<h4 style="color:gray">尚未进行安全设置 <a href="javascript:void(0)" class="toSecureSetBtn">马上设置</a></h4>
								</center>
							</c:when>
							<c:otherwise>
								<h4>已完成安全设置</h4>
								<table class="table">
									<tbody>
										<tr>
											<td>设置时间</td>
											<td class="value">
												<fmt:formatDate value="${user.userSecure.createDate}" pattern="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td>安全问题</td>
											<td class="value">${user.userSecure.secureQuestion}?</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td>
												<button class="btn btn-primary toSecureSetBtn">修改安全设置</button>
											</td>
										</tr>
									</tbody>
								</table>
							</c:otherwise>
						</c:choose>					
					</div>
				</div>				
			</div>
		</div>
		
		</div>
	 </div>
   
   
	<!-- 登录弹出层,查看详细页面 -->
	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center">
						<span class="glyphicon glyphicon-mail"></span>
						用户信息
					</h5>
				</div>
				<div class="modal-body">
						<div align="center">
							
							    <table class="table">
							    	<tbody>
							    		<tr>
							    			<td>头像</td>
							    			<td>
							    			<form id="logoForm" enctype="multipart/form-data" >
							    				<img id="previewImg" src="<%=basePath %>${user.userInfo.userLogo}" style="border-radius:5px" width="80" height="80" />
							    				<input  class="updateIpt" type="file" style="width:200px" id="myfile" name="userLogo1" />
							    				<button id="logoSubBtn" class="btn btn-primary">上传</button>
							    			</form>
							    			</td>
							    		</tr>
							    	</tbody>
							    	<form id="myForm">
							    	<tbody>	
							    		<tr>
							   				<td>用户名:</td>
							   				<td>
							   					${user.user.username }
							   				</td>
							   			</tr>
							   			<tr>
							   				<td>邮箱:</td>
							   				<td>
							   					${user.user.usermail }
							   				</td>
							   			</tr>
							   			<tr>
							   				<td>手机</td>
							   				<td>
							   					<span class="checkSpan">${user.userInfo.userPhone }</span>
							   					<input type="text"  name="userPhone" value="${user.userInfo.userPhone}" class="updateIpt" />
							   				</td>
							   			</tr>
							   			<tr>
											<td>地址</td>
											<td>
												<span class="checkSpan">${user.userInfo.userAddr }</span>
												<input type="text" name="userAddr" value="${user.userInfo.userAddr}" class="updateIpt" />
											</td>   			
							   			</tr>
							   			<tr>
											<td>性别</td>
											<td>
												<span class="checkSpan">
													<c:choose>
														<c:when test="${user.userInfo.userSex=='m' }">男</c:when>
														<c:otherwise>女</c:otherwise>
													</c:choose>
												</span>
												<span class="updateIpt">
													<c:choose>
														<c:when test="${user.userInfo.userSex=='m' }">
															<input required="required" type="radio" name="userSex" value="m" checked="checked" />男  
															<input type="radio" name="userSex" required="required" value="f"/>女
														</c:when>
														<c:otherwise>
															<input required="required" type="radio" name="userSex" value="m" />男  
															<input type="radio" name="userSex" required="required" value="f"  checked="checked"/>女													
														</c:otherwise>
													</c:choose>
												</span>
											</td>
							   			</tr>
							   			<tr>
							   				<td >年龄</td>
							   				<td>
							   					<span class="checkSpan">${user.userInfo.userAge }</span>
							   					<input type="text" value="${user.userInfo.userAge}" name="userAge" class="updateIpt" />
							   				</td>
							   			</tr>
							    	</tbody>
							    	 </form>
							    </table>
						   
						</div>
					<div align="center">
						<span style="color:red" id="tip"></span>
					</div>
				</div>
				

				<div class="modal-footer">
					<button type="button" id="toUpdate" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span> 修改信息
					</button>
					<a href="javascript:void(0)" id="closeBtn" class="btn btn-success" data-dismiss="modal">关闭</a>
					<button type='button' id='cancel' class='btn btn-success'>取消</button>
					<button type='button' id='update' class='btn btn-success'>确定更新</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改密码模态框 -->
	<div id="changePassModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center">
						<span class="glyphicon glyphicon-mail"></span>
						修 改 密 码
					</h5>
				</div>
				<div class="modal-body" id="changePassArea">

				</div>
				
				<div class="modal-footer">
					<a href="javascript:void(0)" id="closeBtn" class="btn btn-success" data-dismiss="modal">关 闭</a>
					<button type='button' id="changePassBtn" class='btn btn-success'>修 改</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 安全设置模态框 -->
	<div id="secureSetModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center">
						<span class="glyphicon glyphicon-mail"></span>
						安 全 设 置
					</h5>
				</div>
				<div class="modal-body" id="secureSetArea">

				</div>
				
				<div class="modal-footer">
					<a href="javascript:void(0)" id="closeBtn" class="btn btn-success" data-dismiss="modal">关 闭</a>
					<button type='button' id="secureSetBtn" class='btn btn-success'>提 交</button>
				</div>
			</div>
		</div>
	</div>
	
   
  </body>
  <script type="text/javascript">
  	$(function(){
  		$(".updateIpt").hide();
  		$("#cancel").hide();
  		$("#update").hide();
  		$("#logoSubBtn").hide();
  		$("#uniform-myfile").hide();
  		
  		//图片预览读取
 		$('#myfile').change(function() {
			var file = this.files[0];
			var reader = new FileReader();
			reader.onload = function() {
				var url = reader.result;
				setImageURL(url);
			};
			reader.readAsDataURL(file);
			$("#logoSubBtn").show(300);
		});
		var image = $("#previewImg")[0];
		function setImageURL(url) {
			image.src = url;
		}
		
		var la = $("#large");
		la.hide();
		
		$("#previewImg").mousemove(function(e){
			la.css({
				position:'absolute',
				top:e.pageY-150,
				left:e.pageX-150
			}).html('<img src = "'+this.src+'"/>').show();
		}).mouseout(function(){
			la.hide();
		});
  	});
  	
  	$("#infoDetail").click(function(){
 		var killPhoneModal = $("#killPhoneModal");//获得弹出框节点
		//显示弹出层
		killPhoneModal.modal({
			show : true, //打开弹出层
			backdrop : "static",//禁止位置关闭
			keyboard : false,//关闭键盘事件，禁止键盘关闭
		});  		
  	});
  	
  	//要求修改用户信息
  	$("#toUpdate").click(function(){
  		$(".checkSpan").hide(300);
  		$(".updateIpt").show(300);
  		$("#closeBtn").hide(300);
  		$("#toUpdate").hide(300);
  		$("#cancel").show(300);
  		$("#update").show(300);
  		$("#uniform-myfile").show(300);
  	});
  	
  	//取消修改用户信息
  	$("body").on("click","#cancel",function(){
  		var footer = $(".modal-footer");
  		//footer.html();
  		$(".checkSpan").show(300);
  		$(".updateIpt").hide(300);
  		$("#closeBtn").show(300);
  		$("#toUpdate").show(300);
  		$("#cancel").hide(300);
  		$("#update").hide(300);
  		$("#myfile").show(300);
  		$("#uniform-myfile").hide();
  	});
  	
  	//修改用户信息提交表单
  	$("body").on("click","#update",function(){
  		var flag = window.confirm("确定要修改?");
  		if(flag){
	  		  	var option = {
	  			type:"post",
	  			url:"user/updateUserInfo",
	  			timeout:5000,
	  			headers:{"ClientCallMode":"ajax"},
	  			success:function(data){
	  				if(data.isSuccess){
	  					alert("用户信息修改成功");
	  					window.location.href="toUserCenter_info";
	  				}else{
	  					$("#tip").html(data.errorMessage);
	  				}
	  			}
	  		};
	  		$("#myForm").ajaxSubmit(option);
  		}

  	});
  	
  	$("#logoSubBtn").click(function(){
  		var option = {
  			type:"post",
  			url:"user/logoUpload",
  			timeout:5000,
  			headers:{"ClientCallMode":"ajax"},
  			async:true,
  			success:function(data){
  				alert("完成");
  			}
  		}
  		$("#logoForm").ajaxSubmit(option);
  	});
  	
  	$("#toChangePassBtn").click(function(){
  		$.ajax({
  			type:"post",
  			url:"index/toChangePassword_login",
  			async:true,
  			success:function(data){
  				$("#changePassArea").html(data);
  				var changePassModal = $("#changePassModal");
				//显示弹出层
				changePassModal.modal({
					show : true, //打开弹出层
					backdrop : "static",//禁止位置关闭
					keyboard : false,//关闭键盘事件，禁止键盘关闭
				});  	  				
  			}
  		});
  	});
  	
  	$("#changePassBtn").click(function() {
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
	
	$(".toSecureSetBtn").click(function(){
  		$.ajax({
  			type:"post",
  			url:"index/toSecureSet",
  			async:true,
  			success:function(data){
  				$("#secureSetArea").html(data);
  				var secureSetModal = $("#secureSetModal");
				//显示弹出层
				secureSetModal.modal({
					show : true, //打开弹出层
					backdrop : "static",//禁止位置关闭
					keyboard : false,//关闭键盘事件，禁止键盘关闭
				});  	  				
  			}
  		});		
	});
	
	$("#secureSetBtn").click(function(){
	
  		//异步提交
  		var option = {
  			type:"post",
  			url:"user/secureSet",
  			timeout:5000,
  			headers :{"ClientCallMode" : "ajax"},
  			success:function(data){
  				if(data.isSuccess){
  					//layer.alert("安全设置修改成功");
  					$("#secureSetModal").modal("hide");
  				}else{
  					$("#secureSetTip").text(data.errorMessage);
  				}
  			}
  		};
  		$("#secureSetForm").ajaxSubmit(option);
	
	});
  	
  </script>
</html>
