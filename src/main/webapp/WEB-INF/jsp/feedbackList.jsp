<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="common/commonTag.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'feedbackList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
      <div class="container">
	  	<table class="table table-hover">
			<thead>
				<tr>
					<th>发送日期</th>
					<th>反馈内容</th>
					<th>反馈状态</th>
					<th>是否查看</th>
					<th>操作 </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${feedbacks}" var="feedback">
					<tr>
						<td>
							<fmt:formatDate value="${feedback.createDate}" pattern="yyyy-MM-dd hh:mm"/>
						</td>
						<td>
							${feedback.feedbackContent }
						</td>
						<td>
							<c:choose>
								<c:when test="${feedback.feedbackState=='0' }">
									未回复
								</c:when>
								<c:otherwise>
									已回复
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${feedback.feedbackState=='1' }">
									已查看
								</c:when>
								<c:when test="${feedback.feedbackState=='2' }">
									未查看
									<span class="label label-important">New</span>
								</c:when>
								<c:otherwise>
								
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${feedback.feedbackState!='0' }">
									<input  type="hidden" value="${feedback.feedbackAnswer}" />
									<button lang="${feedback.feedbackState }" title="${feedback.id }"  class="btn btn-success checkFeedbackBtn">查看回复</button>
								</c:when>
								<c:otherwise>
									<button lang="${feedbback.id }" class="btn btn-danger deleteFeedbackBtn">撤回反馈</button>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	  	</table>
							<div class="ps0" style="float:right;">

								<span>${feedbacksPageInfo.pageNum }/${feedbacksPageInfo.pages}</span>
								<c:choose>
									<c:when test="${feedbacksPageInfo.hasPreviousPage}">
										<span> <a href="index/toFeedbackRecord?page=1&check=${check }&repay=${repay}">首页</a> </span>
										<span> <a
											href="index/toFeedbackRecord?page=${feedbacksPageInfo.prePage }&check=${check }&repay=${repay}">上一页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>首页 </span>
										<span>上一页</span>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${feedbacksPageInfo.hasNextPage}">
										<span><a
											href="index/toFeedbackRecord?page=${feedbacksPageInfo.nextPage }&check=${check }&repay=${repay}">下一页</a>
										</span>
										<span><a
											href="index/toFeedbackRecord?page=${feedbacksPageInfo.pages }&check=${check }&repay=${repay}">尾页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>下一页 </span>
										<span>尾页</span>
									</c:otherwise>
								</c:choose>

								<span> <select id="pageNum" onchange="pageNum()">
										<c:forEach var="index" begin="1"
											end="${feedbacksPageInfo.pages }">
											<c:choose>
												<c:when test="${feedbacksPageInfo.pageNum==index }">
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
							反馈回复
						</h5>
					</div>
					<div class="modal-body">
						<div class="row">
							<div align="center" id="contentArea">
								
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
  $(".checkFeedbackBtn").click(function(){
  		var content = $(this).prev().val();
  		var state = $(this).attr("lang");
  		if(state=="1"){
  		
  		}else{
  		
  		}
 		$("#contentArea").html("来自管理员的回复:"+content);
		var killPhoneModal = $("#killPhoneModal");
		killPhoneModal.modal({
			show : true, //打开弹出层
			backdrop : "static",//禁止位置关闭
			keyboard : false,//关闭键盘事件，禁止键盘关闭
	    });
  });
  
  </script>
</html>
