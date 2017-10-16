<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
    
    <title>My JSP 'returnDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <!-- 还款详情页 -->
    <div class="panel panel-default" style="margin-left:50px">
    	<div class="panel-head primary">
    		
    		<h4 class="modal-title text-center">
				<span class="glyphicon glyphicon-mail"></span>
				贷款金额:${returnDetail.invest} &nbsp;&nbsp; 年利率:${returnDetail.yearRate } 
			</h4>
    	</div>
    	<div class="panel-body">
    		<table class="table table-hover">
    			<thead>
    				<tr>
    					<th align="center">月数</th>
    					<th align="center">本金</th>
    					<th align="center">利息</th>
    					<th align="center">本息和</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach items="${returnDetail.details }" var="detail">
    					<tr>
    						<td align="center">
    							第${detail.month }月
    						</td>
    						<td align="center">
    							${detail.principal}
    						</td>
    						<td align="center">
    							${detail.interest  }
    						</td>
    						<td align="center">
    							${detail.principalInterest }
    						</td>
    					</tr>
    				</c:forEach>
    			</tbody>
    			<tfoot>
    				<tr>
    					<td>合计</td>
    					<td>本金:<strong>${returnDetail.invest}</strong></td>
    					<td>总利息:<strong>${returnDetail.interestCount}</strong></td>
    					<td>应还款:<strong>${returnDetail.returnInvest}</strong></td>
    				</tr>
    			</tfoot>
    		</table>
    	</div>
    </div>
  </body>
</html>
