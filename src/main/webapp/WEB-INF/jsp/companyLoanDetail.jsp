<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalLoanDetail.jsp' starting page</title>
    
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
	<div class="panel panel-primary" style="margin-left:20px">
      			<div class="panel-heading">
      				<h4>贷款信息</h4>
      			</div>
      			<div class="panel-body">
      				 <!-- text-danger/success/primary 等可以给里面的图标/文字换颜色 -->
      				 <h2 class="text-danger">
      				 </h2>
      			<table class="table table-bordered">
		   			<tbody>
		   				<tr>
		   					<td>公司名</td>
		   					<td><strong>${im.info.loanName }</strong></td>
		   				</tr>
		   				<tr>
		   					<td>公司联系人</td>
		   					<td><strong>${im.info.loanContactName }</strong></td>
		   				</tr>
		   				<tr>
		   					<td>联系人电话</td>
		   					<td><strong>${im.info.loanContactPhone }</strong></td>
		   				</tr>
		   				<tr>
		   					<td>贷款金额</td>
		   					<td>${im.info.loanMoney }</td>
		   				</tr>
		   				<tr>
		   					<td>贷款申请日期</td>
		   					<td><strong><fmt:formatDate value="${im.info.createDate }" pattern="yyyy-MM-dd hh:mm:ss" /></strong></td>
		   				</tr>
		   				<tr>
		   					<td>还款期限</td>
		   					<td><strong><fmt:formatDate value="${im.info.loanDeadline }" pattern="yyyy-MM-dd hh:mm:ss" /></strong></td>
		   				</tr>
		   				<tr>
		   					<td>贷款状态</td>
		   					<td>
		   					   <c:choose>
		   							<c:when test="${im.info.loanState=='0' }">
		   								<span style="color:blue">未处理</span>
		   							</c:when>
		   							<c:when test="${im.info.loanState=='1' }">
		   								<span style="color:green">已通过</span>
		   							</c:when>
		   							<c:otherwise>
		   								<span style="color:red">被驳回</span>
		   							</c:otherwise>
		   						</c:choose>
		   					</td>
		   				</tr>
		   				<tr>
		   					<td>还款状态</td>
		   					<td>
		   						
		   					</td>
		   				</tr>
		   				<tr>
		   					<td>操作</td>
		   					<td>
		   						 <c:choose>
		   							<c:when test="${im.info.loanState=='1' }">
		   								<c:choose>
		   									<c:when test="${im.info.isRepay=='0' }">
		   										<button class="btn btn-primary">还款</button>
		   										距离还款期限还有: 
		   									</c:when>
		   									<c:when test="${im.info.isRepay=='2' }">
		   										<button class="btn btn-success">领款</button>
		   									</c:when>
		   									<c:otherwise>
		   										已还款，欢迎下次再来
		   									</c:otherwise>
		   								</c:choose>
		   							</c:when>
		   							<c:when test="${im.info.loanState=='2' }">
		   								<button class="btn btn-danger">驳回原因</button>
		   							</c:when>
		   							<c:otherwise>
		   								<button class="btn btn-danger">撤回申请</button>
		   							</c:otherwise>
		   						</c:choose>
		   					</td>
		   				</tr>	   				
		   			</tbody>
		   		</table>
      		</div>
    </div>
    <div class="panel panel-primary">
    	<div class="panel-heading">
      		<h4>贷款资料</h4>
      	</div>
      	<div class="panel-body">
      		<table class="table">
      			<tbody>
      				<tr>
      					<td>
      						<div class="text-center"><h4><strong>企业资质资料</strong></h4></div>
      						<img src="<%=basePath %>/${im.material.materialAptitude}" alt="${im.material.materialAptitude}" />
      					</td>
      				</tr>
      				<tr>
      					<td>
      						<div class="text-center"><h4><strong>相关抵押资料</strong></h4></div>
      						<img src="<%=basePath %>/${im.material.materialMortgage}" alt="${im.material.materialMortgage}" />
      					</td>
      				</tr>      				
      			</tbody>
      		</table>
      	</div>
    </div>
    
    
  </body>
</html>
