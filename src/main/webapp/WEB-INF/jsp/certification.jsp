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
    
    <title>实名认证</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
  	<%@ include file="common/navbar.jsp" %>
  	
  	<div class="container-fluid-full">
		<div class="row-fluid">
		
		<%@ include file="common/sidebar.jsp" %>
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
				<li>
					<a href="index/toUserCenter_info">个人中心</a>
					<i class="icon-angle-right"></i>
				</li>
				<li>
					实名验证
				</li>
			</ul>
			<div class="row-fluid sortable ui-sortable">
			  			<div class="box span7">
							<div class="box-header" data-original-title="">
								<h2><i class="halflings-icon user"></i><span class="break"></span>
								实名验证
								</h2>
								<div class="box-icon">
								</div>
							</div>
			  				<div class="box-content">
					  	<c:choose>
					  		<c:when test="${user.userInfo.userRealname==null}">
					  			<span style="color:gray;font-size:15px">您还没有进行实名认证，将无法进行借贷款申请</span>
					  			<form id="myForm">
					  				真实姓名:<input type="text" name="userRealname" /><br>
					  				身份证号:<input type="text" name="userIdentitynum" /><br>
					  				证件正面照:<input type="file" name="userIdentitypic"  id="myfile"/><br>
					  				<img style="margin-left:15%;width:518px;height:390px" id="previewImg" /> 
					  				<center>
					  					<span id="tip" style="color:red"></span>
					  				</center>
					  			</form>
					  			<button class="btn btn-primary" id="subBtn">验证</button>
					  		</c:when>
			  				<c:otherwise>
			  					<div class="span12">
									<div class="priority low">
										<span>你的账户${user.user.username }已完成实名认证</span>
									</div>
									
									<div class="task low">
										<div class="desc">
											<div class="title">真实姓名:<span style="font-weight:bold;">${user.userInfo.userRealname}</span></div>
											<div class="title">证件号码:<span style="font-weight:bold;">${user.userInfo.userIdentitynum}</span></div>
											<div class="title">真实年龄:<span style="font-weight:bold;">${user.userInfo.userAge}</span></div>
											<div class="title">证件照片:<img style="margin-left:15%;width:518px;height:390px" src="<%=basePath %>${user.userInfo.userIdentitypic}"  /></div>
										</div>
										<div class="time">
											<div class="date">
												<fmt:formatDate value="${user.user.createDate }" pattern="yyyy-MM-dd"/>
											</div>
											<div> 认证时间</div>
										</div>
									</div>
								</div>
							  </c:otherwise>
							  </c:choose>
				  			</div>
				  			
			  		 </div>
			<div class="span5 noMarginLeft">
					
				<div class="dark">
					
					<h1>实名认证流程</h1>
					
					<div class="timeline">
						
					    <div class="timeslot" style="height: 150px;">
							<div class="task">
					    		<span>
									<span class="details">
										填写真实身份信息
									</span>
								</span>
								<div class="arrow"></div>
							</div>							
							<div class="icon">
								<i class="icon-map-marker"></i>
							</div>
							<div class="time">
								3:43 PM
							</div>	
					    </div>
					
						<div class="clearfix"></div>
						
						<div class="timeslot alt" style="height: 150px;">
					    	
							<div class="task">
					    		<span>
									<span class="details">
										上传身份证正面照
									</span>
								</span>
								<div class="arrow"></div>
							</div>
							<div class="icon">
								<i class="icon-phone"></i>
							</div>
							<div class="time">
								3:43 PM
							</div>	
								
					    </div>
					
						<div class="timeslot" style="height: 300px;">
					    	
							<div class="task">
					    		<span>
									<span class="details">
										完成实名认证，能够进行借贷服务
									</span>
								</span>
								<div class="arrow"></div>
							</div>
							<div class="icon">
								<i class="icon-envelope"></i>
							</div>
							<div class="time">
								3:43 PM
							</div>	
								
					    </div>
					</div>
				</div>
				
			</div>
			  		
		  	</div>
		</div>
		</div>
	</div>

  </body>
  <script type="text/javascript">
  	$(function(){
  		
  		$("#previewImg").hide();
  		
  		//图片预览读取
 		$('#myfile').change(function() {
			var file = this.files[0];
			var reader = new FileReader();
			reader.onload = function() {
				var url = reader.result;
				setImageURL(url);
			};
			reader.readAsDataURL(file);
			$("#previewImg").show(300);
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
  	
  	$("#subBtn").click(function(){
  		var option = {
  			type:"post",
  			headers:{"ClientCallMode":"ajax"},
  			url:"user/certification",
  			timeout:5000,
  			success:function(data){
  				if(data.isSuccess){
  					alert("成功！！");
  					window.location.reload();
  				}else{
  					$("#tip").html(data.errorMessage).show(300);
  				}
  			}
  		
  		};
  		$("#myForm").ajaxSubmit(option);
  	})
  	
  </script>
</html>
