<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<%-- 	<link rel="stylesheet" href="<%=basePath%>/res/css/bootstrap.css">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> --%>
	

  </head>
  
  <body>
  <%@include file="common/navbar.jsp" %>
  
  
  
	<div class="container-fluid-full">
		<div class="row-fluid">
			
			<!-- sidebar-lef：侧边栏 -->
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
				<li><a href="index/toIndex">首页 </a></li>
			</ul>	
			
			<!-- 轮播图 -->		
			<div id="myCarousel" class="carousel slide span11"  >
			    <!-- 轮播（Carousel）指标 -->
			    <ol class="carousel-indicators">
			        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			        <li data-target="#myCarousel" data-slide-to="1"></li>
			        <li data-target="#myCarousel" data-slide-to="2"></li>
			    </ol>   
			    <!-- 轮播（Carousel）项目 -->
			    <div class="carousel-inner">
			        <div class="item active">
			            <img src="/loan/res/img/img1.jpg" style="width:100%;height:300px" alt="First slide">
			        </div>
			        <div class="item">
			            <img src="/loan/res/img/img1.jpg" alt="Second slide">
			        </div>
			        <div class="item">
			            <img src="/loan/res/img/img1.jpg" alt="Third slide">
			        </div>
			    </div>
			    <!-- 轮播（Carousel）导航 -->
			    <a class="carousel-control left" href="#myCarousel" 
			        data-slide="prev">&lsaquo;
			    </a>
			    <a class="carousel-control right" href="#myCarousel" 
			        data-slide="next">&rsaquo;
			    </a>
			</div>
			
			<div class="row-fluid">
				
				<div class="span4 statbox purple" ondesktop="span4" ontablet="span6">
					<div class="number">${loanCount }<i class="icon-arrow-up"></i></div>
					<div class="title">visits</div>
					<div class="footer">
						<a href="#"> 我 的 贷 款</a>
					</div>	
				</div>
				<div class="span4 statbox green" ondesktop="span4" ontablet="span6">
					<div class="number">${remindCount }<i class="icon-arrow-up"></i></div>
					<div class="title">sales</div>
					<div class="footer">
						<a href="#"> 我 的 消 息</a>
					</div>
				</div>
				<div class="span4 statbox blue noMargin" ondesktop="span4" ontablet="span6">
					<div class="number">${feedbackCount }<i class="icon-arrow-up"></i></div>
					<div class="title">orders</div>
					<div class="footer">
						<a href="#"> 我 的 反 馈</a>
					</div>
				</div>	
				
			</div>		
						
			
			</div>
			
			
		</div>
 	</div>
  

  </body>
  <script type="text/javascript">
  	$(function(){
  		var secure = "${user.userSecure}";
  		if(secure == null || secure == undefined || secure == ''){
  			alert("您尚未进行安全设置，请尽早设置");
  		}
  		var error = "${error}";
  		if(error != null && error != undefined && error != ''){
  			alert(error);
  		}
  	});
  </script>
  
</html>
