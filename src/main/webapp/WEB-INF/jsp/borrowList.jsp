<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
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
    
    <title>My JSP 'personalLoanList.jsp' starting page</title>
    
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
   <table class="table table-hover">
   		<thead>
   			<tr>
   				<th>联系方式</th>
   				<th>企业名称</th>
   				<th>财务信息</th>
   				<th>借款日期</th>
   				<th>借款状态</th>
   				<th>操作</th>
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach items="${loans}" var="loan">
   				<tr>
   					<td>
   						${loan.borrowContact }
   					</td>
   					<td>
   						${loan.borrowCompanyName }
   					</td>
   					<td>
   						${loan.borrowFinance }
   					</td>
   					<td>
   						${loan.createDate }
   					</td>
   					<td>
   						<c:choose>
   							<c:when test="${loan.borrowState=='0' }">
   								<span class="primary">未查看</span>
   							</c:when>
   							<c:when test="${loan.borrowState=='1' }">
   								<span class="success">已通过</span>
   							</c:when>
   							<c:otherwise>
   								<span class="danger">被驳回</span>
   							</c:otherwise>
   						</c:choose>
   					</td>
   					<td>
   						<a href="javascript:void(0)" class="detailsBtn">查看详情</a> &nbsp;
   						<c:choose>
   							<c:when test="${loan.borrowState=='1' }">
   								<c:choose>
   									<c:when test="${loan.isRepay=='0' }">
   										<button class="btn btn-primary">还款</button>
   										距离还款期限还有: 
   									</c:when>
   									<c:when test="${loan.isRepay=='2' }">
   										<button class="btn btn-success">领款</button>
   									</c:when>
   									<c:otherwise>
   										已还款，欢迎下次再来
   									</c:otherwise>
   								</c:choose>
   							</c:when>
   							<c:when test="${loan.borrowState=='2' }">
   								<button class="btn btn-danger">驳回原因</button>
   							</c:when>
   							<c:otherwise>
   								<button class="btn btn-danger">撤回申请</button>
   							</c:otherwise>
   						</c:choose>
   					</td>
   				</tr>
   			</c:forEach>
   		</tbody>
   </table>
   
	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center">
						<span class="glyphicon glyphicon-mail"></span>
						借钱详细
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center">
							信息
						</div>

					</div>
				</div>

				<div class="modal-footer">
					<a href="javascript:void(0)" id="closeBtn" class="btn btn-success" data-dismiss="modal">关闭</a>
				</div>
			</div>
		</div>
	</div>
  </body>
  <script>
  	$(".detailsBtn").click(function(){
  		var killPhoneModal = $("#killPhoneModal");
		killPhoneModal.modal({
			show : true, //打开弹出层
			backdrop : "static",//禁止位置关闭
			keyboard : false,//关闭键盘事件，禁止键盘关闭
		});  		
  	});
  </script>
</html>
