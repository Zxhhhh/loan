<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
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
    
    <title>My JSP 'personalLoanList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	


	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- jQuery countDown倒计时插件 -->
	<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script> 

  </head>
  
  <body>
   <table class="table table-hover">
   		<thead>
   			<tr>
   				<th>借款人</th>
   				<th>借款金额</th>
   				<th>借款日期</th>
   				<th>还款日期</th>
   				<th>借款状态</th>
   				<th>操作</th>
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach items="${loans}" var="loan">
   				<tr>
   					<td>
   						${loan.loanName }
   					</td>
   					<td>
   						${loan.loanMoney }
   					</td>
   					<td>
   						<fmt:formatDate value="${loan.createDate }" pattern="yyyy-MM-dd hh:mm:ss" />
   					</td>
   					<td>
   						<c:choose>
	   						<c:when test="${loan.isRepay=='2' }">
	   							暂无
	   						</c:when>
	   						<c:otherwise>
	   							<fmt:formatDate value="${loan.loanDeadline }" pattern="yyyy-MM-dd hh:mm:ss" />
	   						</c:otherwise>
   						</c:choose>
   					</td>
   					<td>
   						<c:choose>
   							<c:when test="${loan.loanState=='0' }">
   								<span>未处理</span>
   							</c:when>
   							<c:when test="${loan.loanState=='1' }">
   								<span style="color:green">已通过</span>
   							</c:when>
   							<c:otherwise>
   								<span style="color:red">被驳回</span>
   							</c:otherwise>
   						</c:choose>
   					</td>
   					<td>
   						<a href="javascript:void(0)" lang="${loan.id }" class="detailsBtn">查看详情</a> &nbsp;
   						<c:choose>
   							<c:when test="${loan.loanState=='1' }">
   								<c:choose>
   									<c:when test="${loan.isRepay=='0' }">
   										<button lang="${loan.id }" title="${loan.loanReturnMoney }"  class="btn btn-primary repayBtn">还款</button>
   									</c:when>
   									<c:when test="${loan.isRepay=='2' }">
   										<button lang="${loan.id }" class="btn btn-success takemoney" title="${loan.loanReturnMoney }">领款</button>
   									</c:when>
   									<c:otherwise>
   										已还款
   									</c:otherwise>
   								</c:choose>
   							</c:when>
   							<c:when test="${loan.loanState=='2' }">
   								<button class="btn btn-danger reason" lang="${loan.remindContent}" >驳回原因</button>
   							</c:when>
   							<c:otherwise>
   								<button lang="${loan.id}" class="btn btn-danger deletePersonaloan">撤回申请</button>
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
						个人贷款详细
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center" id="detailArea">
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
  		$.ajax({
  			type:"post",
  			url:"user/"+$(this).attr("lang")+"/personalLoanDetail",
  			async:true,
  			success:function(data){
  				$("#detailArea").html(data);
		  		var killPhoneModal = $("#killPhoneModal");
				killPhoneModal.modal({
					show : true, //打开弹出层
					backdrop : "static",//禁止位置关闭
					keyboard : false,//关闭键盘事件，禁止键盘关闭
				}); 
  			}
  		});
  	});
  	
  	$(".reason").click(function(){
  		var content = $(this).attr("lang");
  		$("#detailArea").html("审核评语:"+content);
		var killPhoneModal = $("#killPhoneModal");//获得弹出框节点
		//显示弹出层
		killPhoneModal.modal({
			show : true, //打开弹出层
			backdrop : "static",//禁止位置关闭
			keyboard : false,//关闭键盘事件，禁止键盘关闭
		});
  	
  	});
  	
  	//还款
  	$(".repayBtn").click(function(){
  		var id = $(this).attr("lang");
  		layer.confirm("应还款:"+$(this).attr("title")+",确认要还款吗",{
			btn:["确定","取消"],  		
  		},function(){
  			$.ajax({
  				type:"post",
  				url:"loan/"+id+"/repayPersonalLoan",
  				async:true,
  				dataType:"json",
				success:function(data){
					if(data.isSuccess){
					
						layer.alert(data.data, {
							icon: 6,
							yes:function(){
								window.location.href="toLoanRecord";
							}
							});
					}else{
						layer.msg(data.errorMessage, {icon: 5});
					}
				}  			
  			});
  		},function(){
  		
  		});
  	});
  	
  	//领款
  	$(".takemoney").click(function(){
  		var id = $(this).attr("lang");
  		layer.confirm("总计"+$(this).attr("title")+"元将汇入您的账户中",{
			btn:["确定","取消"],  		
  		},function(){
  			$.ajax({
  				type:"post",
  				url:"loan/"+id+"/takemoneyPersonalLoan",
  				async:true,
  				dataType:"json",
				success:function(data){
					if(data.isSuccess){
					
						layer.alert(data.data, {
							icon: 6,
							yes:function(){
								window.location.href="toLoanRecord";
							}
							});
					}else{
						layer.msg(data.errorMessage, {icon: 5});
					}
				}  			
  			});
  		},function(){
  		
  		});
  	});
  	
  	
  	//撤回贷款申请
  	$(".deletePersonaloan").click(function(){
  		var id = $(this).attr("lang");
  		layer.confirm("确定要撤回申请吗",{
			btn:["确定","取消"],  		
  		},function(){
  			$.ajax({
  				type:"post",
  				url:"loan/"+id+"/deletePersonalLoan",
  				async:true,
  				dataType:"json",
				success:function(data){
					if(data.isSuccess){
					
						layer.alert(data.data, {
							icon: 6,
							yes:function(){
								window.location.href="toLoanRecord";
							}
							});
					}else{
						layer.msg(data.errorMessage, {icon: 5});
					}
				}  			
  			});
  		},function(){
  		
  		});
  	});
  	
  </script>
</html>
