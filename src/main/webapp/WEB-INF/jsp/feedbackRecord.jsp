<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="common/commonTag.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>反馈记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<%@include file="common/navbar.jsp" %>
   	<div class="container-fluid-full">
  		<div class="row-fluid">
  		
  		<%@include file="common/sidebar.jsp" %>
  		
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
					<li>反馈记录</li>
				</ul>
				
				<div class="container">
			  		<div class="panel panel-default">
			  			<div class="panel-head">
			  					筛选:
			  					<select id="repaySelect">
			  						<option value="0">全部</option>
			  						<option value="1">管理员已回复</option>
			  						<option value="2">管理员未回复</option>
			  					</select>
			  					
			  					<select id="checkSelect">
			  						<option value="0">全部</option>
			  						<option value="1">我已查看</option>
			  						<option value="2">我未查看</option>
			  					</select>
			  					
			  			</div>
			  			<div class="panel-body" id="feedbackArea"> 
			  			</div>
			  			
			  		</div>
				</div>
				
  			</div>
  		</div>
  	</div> 
  </body>
  <script type="text/javascript">
  	$(function(){
  		$.ajax({
  			type:"post",
  			url:"feedback/${page}/getUserFeedbacks",
  			data:{check:"${check}",repay:"${repay}"},
  			async:true,
  			success:function(data){
  				alert("chenggong");
  				$("#feedbackArea").html(data);
  				//layer.closeAll("loading"); 
  			}
  		});
  	});
  	
  	$("#repaySelect").change(function(){
  		$.ajax({
  			type:"post",
  			url:"feedback/1/getUserFeedbacks",
  			data:{repay:$(this).val()},
  			async:true,
  			success:function(data){
  				alert("chenggong");
  				$("#feedbackArea").html(data);
  				//layer.closeAll("loading"); 
  			}
  		});	
  	});
 
  	$("#checkSelect").change(function(){
 
  		$.ajax({
  			type:"post",
  			url:"feedback/1/getUserFeedbacks",
  			data:{check:$(this).val()},
  			async:true,
  			success:function(data){
  				alert("chenggong");
  				$("#feedbackArea").html(data);
  				//layer.closeAll("loading"); 
  			}
  		});	
  	
  	});	
  	
  </script>
</html>
