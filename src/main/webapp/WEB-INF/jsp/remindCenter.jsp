<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newsCenter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
					<li>消息中心</li>
				</ul>
				
			  <div class="container">
			  		<div class="panel panel-default">
			  			<div class="panel-head">
			  					筛选:
			  					<select id="remindTypeSelect">
			  						<option value="0">系统推送</option>
			  						<option value="1">贷款反馈</option>
			  						<option value="2">借钱反馈</option>
			  						<option value="3">审核提醒</option>
			  					</select>
			  					&nbsp;&nbsp;&nbsp;
			  					<select id="remindStateSelect">
			  						<option value="0">未查看</option>
			  						<option value="1">已查看</option>
			  					</select>
			  					<button class="btn" id="reset">重置</button>
			  			</div>
			  			<div class="panel-body" id="remindArea"> 
			  			
			  			</div>
			  			
			  		</div>
			  </div>
		  </div>
		</div>
	</div>
    消息推送<br>
  </body>
  <script type="text/javascript">
  	$(function(){
  		$.ajax({
  			type:"post",
  			url:"remind/${page}/getRemindList",
  			data:{remindState:"${remindState}",remindType:"${remindType}"},
  			async:true,
  			success:function(data){
  				$("#remindArea").html(data);
  				layer.closeAll("loading"); 
  			},
  			beforeSend:function(){
				layer.load();
			}
  		});
  	});
  	
  	$("#reset").click(function(){
  		$.ajax({
  			type:"post",
  			url:"remind/1/getRemindList",
  			async:true,
  			success:function(data){
  				$("#remindArea").html(data);
  				layer.closeAll("loading"); 
  			},
  			beforeSend:function(){
				layer.load();
			}
  		});  	
  	});
  	
  	$("#remindTypeSelect").change(function(){
  		 $.ajax({
  			type:"post",
  			url:"remind/1/getRemindList",
  			data:{remindType:$(this).val(),remindState:$("#remindStateSelect").val()},
  			async:true,
  			success:function(data){
  				$("#remindArea").html(data);
  				layer.closeAll("loading"); 
  			},
  			beforeSend:function(){
				layer.load();
			}
  		});
  	});
  	
  	$("#remindStateSelect").change(function(){
  		 $.ajax({
  			type:"post",
  			url:"remind/1/getRemindList",
  			data:{remindState:$(this).val(),remindType:$("#remindTypeSelect").val()},
  			async:true,
  			success:function(data){
  				$("#remindArea").html(data);
  				layer.closeAll("loading"); 
  			},
  			beforeSend:function(){
				layer.load();
			}
  		});
  	});
  </script>
</html>
