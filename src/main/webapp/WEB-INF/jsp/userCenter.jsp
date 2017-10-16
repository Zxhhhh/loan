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
    
    <title>My JSP 'userrCenter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<%-- 	<link rel="stylesheet" href="<%=basePath%>/res/css/bootstrap.css">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/res/js/jquery-form.js"></script> --%>

  </head>
  
  <body>
    个人中心 &nbsp; <a href="index/toIndex" class="btn btn-default">返回</a> <br>
  功能:<a href="index/toUserCenter_info">个人信息</a> <a href="index/toCertification">实名认证</a> <a href="index/toLoanRecord">借贷记录</a> <a href="index/toRemindCenter">消息中心</a> <a>其他</a>
  </body>
</html>
