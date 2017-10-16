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
    
    <title>安全设置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <!-- 安全设置 -->
    <form action="" id="secureSetForm" style="margin-left:50px;margin-top:20px">
    	<fieldset>
				<div class="input-prepend" title="Username">
					<span class="add-on">安全问题:</span>
					<input class="input-large span5"  type="text" value="${user.userSecure.secureQuestion}" name="secureQuestion" />
				</div>
				<div class="clearfix"></div>

				<div class="input-prepend" title="Username">
					<span class="add-on">问题答案:</span>
					<input class="input-large span5"  type="text" value="${user.userSecure.secureAnswer }" name="secureAnswer" />
				</div>
				<div class="clearfix"></div>
    	</fieldset>
    	
    </form>
	<center>
		<span id="secureSetTip" style="color:red"></span>
	</center>    
<!--     <button id="subBtn">设置</button>
    <a class="btn" href="index/toUserCenter_info">返回</a> -->
  </body>
  <script type="text/javascript">
  	$("#subBtn").click(function(){
  	
  		//异步提交
  		var option = {
  			type:"post",
  			url:"user/secureSet",
  			timeout:5000,
  			headers :{"ClientCallMode" : "ajax"},
  			success:function(data){
  				if(data.isSuccess){
  					alert("安全设置修改成功");
  					window.location.href="toUserCenter_info";//回到用户信息
  				}else{
  					$("#secureSetTip").text(data.errorMessage);
  				}
  			}
  		};
  		$("#secureSetForm").ajaxSubmit(option);
  	});
  
  </script>
</html>
