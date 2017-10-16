<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logoUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>/res/css/bootstrap.css">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/res/js/jquery-form.js"></script>

  </head>
  <script type="text/javascript">
	$(function() {
		$('#myfile').change(function() {
			var file = this.files[0];
			var reader = new FileReader();
			reader.onload = function() {
				var url = reader.result;
				setImageURL(url);
			};
			reader.readAsDataURL(file);
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
	</script>
  
  <body>
    	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="show-top-grids">
			<div class="main-grids about-main-grids">
				<div class="recommended-info">

					<h3>更改上传</h3>
					<div
						style="width:50%;height:150px;margin-left:200px;margin-left:10px">
						<form class="form-horizontal"
							action="servlet/UserServlet?flag=logoUpload"
							enctype="multipart/form-data" method="post">
							<table class="table">
								<tr>
									<td><strong style="font-size:18px">选择路径</strong></td>
									<td><input id="myfile" type="file" name="photo"></td>
								</tr>
								<tr>
									<td><strong style="font-size:18px">效果预览</strong></td>
									<td><img id="previewImg" src="<%=basePath%>/res/img/logo.jpg"
										width="80px" height="80px" style="float:left" /></td>
									<div id="large"></div>
								</tr>

								<tr>
									<td><input type="submit" value="上传"
										class="btn btn-primary"></td>
								</tr>
							</table>
						</form>
					</div>
					<div style="width:100%;height:400px"></div>
				</div>
			</div>
		</div>
  </body>
</html>
