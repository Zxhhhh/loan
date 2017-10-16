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
    
    <title>My JSP 'loanRecord.jsp' starting page</title>
    
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
					<li>贷款记录</li>
				</ul>

			    <div class="container">
			    		<div class="panel panel-default">
			      			<div class="panel-heading" align="center">
			      				    <ul class="nav nav-tabs nav-pills ">
										<li id="personalLoanBtn" role="presentation" class="active" style="width:33%"><a href="javascript:void(0)">个人贷款</a>
										</li>
										<li id="companyLoanBtn" role="presentation" style="width:33%"><a href="javascript:void(0)" >企业贷款</a>
										</li>
										<li id="borrowBtn" role="presentation" style="width:33%"><a href="javascript:void(0)">个人借钱</a>
										</li>
									</ul>
			      			</div>
			      			<div class="panel-body" id="recordArea">
			      			
			      			</div>
			      		</div>
			    </div>
			
			</div>
		
		</div>
	</div>
  	
    <!--   借贷记录 &nbsp; <a href="index/toUserCenter" class="btn btn-default">返回</a><br> -->
  </body>
  <script type="text/javascript">
  
  $(function(){
  	$("#personalLoanBtn").attr("class","active");
  	$("#companyLoanBtn").attr("class","");
  	$("#borrowBtn").attr("class","");
  	$.ajax({
  		type:"post",
  		url:"user/personalLoanList",
  		async:true,
  		success:function(data){
  			$("#recordArea").hide();
  			$("#recordArea").html(data).show(500);
  		}
  	});
  });
  
  
  //获取个人贷款记录
  $("#personalLoanBtn").click(function(){
  	$("#personalLoanBtn").attr("class","active");
  	$("#companyLoanBtn").attr("class","");
  	$("#borrowBtn").attr("class","");
  	
  	$.ajax({
  		type:"post",
  		url:"user/personalLoanList",
  		async:true,
  		success:function(data){
  			$("#recordArea").hide();
  			$("#recordArea").html(data).show(500);
  			layer.closeAll("loading"); 
  		},
  		beforeSend:function(){
			layer.load();
		}
  	});
  });
  
  $("#companyLoanBtn").click(function(){
  	
  	$("#personalLoanBtn").attr("class","");
  	$("#companyLoanBtn").attr("class","active");
  	$("#borrowBtn").attr("class","");
  	
  	 $.ajax({
  		type:"post",
  		url:"user/companyLoanList",
  		async:true,
  		success:function(data){
  			$("#recordArea").hide();
  			$("#recordArea").html(data).show(500);
  		}
  	});
  
  });
  
  $("#borrowBtn").click(function(){
  	 $("#personalLoanBtn").attr("class","");
  	$("#companyLoanBtn").attr("class","");
  	$("#borrowBtn").attr("class","active");
  	
  	 $.ajax({
  		type:"post",
  		url:"user/borrowList",
  		async:true,
  		success:function(data){
  			$("#recordArea").hide();
  			$("#recordArea").html(data).show(500);
  		}
  	});
  
  });
  
  </script>
</html>
