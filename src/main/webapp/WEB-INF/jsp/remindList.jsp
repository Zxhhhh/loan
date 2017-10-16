<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/commonTag.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'remindList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <div class="container">
  	<table class="table">
		<thead>
			<tr>
				<th>推送日期</th>
				<th>消息类型</th>
				<th>消息状态</th>
				<th>操作 </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reminds}" var="remind">
				<tr>
					<td>
						
						<fmt:formatDate value="${remind.createDate}" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						<c:choose>
							<c:when test="${remind.remindType=='0' }">
								系统推送
							</c:when>
							<c:when test="${remind.remindType=='1' }">
								贷款反馈
							</c:when>
							<c:when test="${remind.remindType=='2' }">
								借钱反馈
							</c:when>
							<c:otherwise>
								审核提醒
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${remind.remindState=='0' }">
								<span style="color:red">未查看</span>
							</c:when>
							<c:otherwise>
								已查看
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<input  type="hidden" value="${remind.remindContent }" />
						<button class="btn btn-primary showRemind" lang="${remind.id }" >查看消息</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>  	
  	</table>							
						<div class="ps0" style="float:right;">

								<span>${remindsPageInfo.pageNum }/${remindsPageInfo.pages}</span>
								<c:choose>
									<c:when test="${remindsPageInfo.hasPreviousPage}">
										<span> <a href="index/toRemindCenter?page=1&remindType=${remindType }&remindState=${remindState}">首页</a> </span>
										<span> <a
											href="index/toRemindCenter?page=${remindsPageInfo.prePage }&remindType=${remindType }&remindState=${remindState}">上一页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>首页 </span>
										<span>上一页</span>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${remindsPageInfo.hasNextPage}">
										<span><a
											href="index/toRemindCenter?page=${remindsPageInfo.nextPage }&remindType=${remindType }&remindState=${remindState}">下一页</a>
										</span>
										<span><a
											href="index/toRemindCenter?page=${remindsPageInfo.pages }&remindType=${remindType }&remindState=${remindState}">尾页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>下一页 </span>
										<span>尾页</span>
									</c:otherwise>
								</c:choose>

								<span> <select id="pageNum" onchange="pageNum()">
										<c:forEach var="index" begin="1"
											end="${remindsPageInfo.pages }">
											<c:choose>
												<c:when test="${remindsPageInfo.pageNum==index }">
													<option value="${index }" selected="selected">${index}</option>
												</c:when>
												<c:otherwise>
													<option value="${index }">${index}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
								</select> </span>

							</div>
  </div>
  	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center">
						历 史 消 息
					</h5>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center" id="contentArea" style="text-align:center;margin-left:10px">
							
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<a href="index/toRemindCenter" id="closeBtn" class="btn btn-success">关闭</a>
				</div>
			</div>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  	//查看消息内容
  	$(".showRemind").click(function(){
  		var content = $(this).prev().val();
  		$.ajax({
  			type:"post",
  			url:"remind/"+$(this).attr("lang")+"/Y/remindStateChange",
  			async:true,
  			success:function(data){
  				if(data.isSuccess){
				  		$("#contentArea").html("管理员消息:"+content);
				  		var killPhoneModal = $("#killPhoneModal");
				  		killPhoneModal.modal({
							show : true, //打开弹出层
							backdrop : "static",//禁止位置关闭
							keyboard : false,//关闭键盘事件，禁止键盘关闭
						});
				}else{
					alert(data.errorMessage);
				}
  			}
  		});
  	})
  </script>
</html>
