<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="common/commonTag.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- jQuery countDown倒计时插件 -->
<script
	src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

</head>

<body>
	<div class="panel panel-primary" style="margin-left:20px">
		<div class="panel-heading">
			<h4>贷款信息</h4>
		</div>
		<div class="panel-body">
			<!-- text-danger/success/primary 等可以给里面的图标/文字换颜色 -->
			<h2 class="text-danger"></h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td>贷款者姓名</td>
						<td><strong>${im.info.loanName }</strong>
						</td>
					</tr>
					<tr>
						<td>贷款者电话</td>
						<td><strong>${im.info.loanPhone }</strong>
						</td>
					</tr>
					<tr>
						<td>联系地址</td>
						<td><strong>${im.info.loanLocation }</strong>
						</td>
					</tr>
					<tr>
						<td>贷款金额</td>
						<td>${im.info.loanMoney }</td>
					</tr>
					<tr>
						<td>还款金额</td>
						<td>${im.info.loanReturnMoney }</td>
					</tr>
					<tr>
						<td>贷款申请日期</td>
						<td><strong><fmt:formatDate
									value="${im.info.createDate }" pattern="yyyy-MM-dd hh:mm:ss" />
						</strong>
						</td>
					</tr>
					<tr>
						<td>还款期限</td>
						<td>
						<c:choose>
								<c:when test="${im.info.isRepay=='2' }">
		   								领款后的${im.info.loanMonth}个月
		   							</c:when>
								<c:otherwise>
								<span lang="${im.info.loanDeadline.time}" id="countdownArea" style="color:red" ></span>
									(<fmt:formatDate
											value="${im.info.loanDeadline }"
											pattern="yyyy-MM-dd" />)
								</c:otherwise>
							</c:choose> 
						</td>
					</tr>
					<tr>
						<td>贷款状态</td>
						<td><c:choose>
								<c:when test="${im.info.loanState=='0' }">
									<span style="color:blue">未处理</span>
								</c:when>
								<c:when test="${im.info.loanState=='1' }">
									<span style="color:green">已通过</span>
								</c:when>
								<c:otherwise>
									<span style="color:red">被驳回</span>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>还款状态</td>
						<td><c:choose>
								<c:when test="${im.info.isRepay=='0' }">
													未还款
		   									</c:when>
								<c:when test="${im.info.isRepay=='1' }">
									<span style="color:green">已还款</span>
								</c:when>
								<c:when test="${im.info.isRepay=='2' }">
									<span style="color:blue">未领款</span>
								</c:when>
								<c:when test="${im.info.isRepay=='3' }">
									<span style="color:red">超时未还</span>
								</c:when>
								<c:otherwise>
		   										已还款，欢迎下次再来
		   									</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>审核评语</td>
						<td>${im.info.remindContent }</td>
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
							<div class="text-center">
								<h4>
									<strong>个人相关资料</strong>
								</h4>
							</div> <img src="<%=basePath %>/${im.material.materialPersonal}"
							alt="${im.material.materialPersonal}" /></td>
					</tr>
					<tr>
						<td>
							<div class="text-center">
								<h4>
									<strong>相关抵押资料</strong>
								</h4>
							</div> <img src="<%=basePath %>/${im.material.materialMortgage}"
							alt="${im.material.materialMortgage}" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
	   if($("#countdownArea")!=undefined){
			$.get("/loan/loan/now", {}, function(result) { //ajax的get方法获取json参数
				if (result && result["success"]) {
					var nowTime = result["data"];
					var startTime = $("#countdownArea").attr("lang");
					countdown(nowTime,startTime);//时间判断，计时交互
				} else {
	
				}
			});
		}
	});

	function countdown(nowTime,startTime) {
		
		var seckillBox = $("#countdownArea"); //获得倒计时区域元素

		//判断时间
		if (nowTime<startTime) {
		
			alert("进入方法:"+nowTime+"---"+startTime);

			var killTime = new Date(startTime - 0 + 1000); //+1000:防止时间偏移

			seckillBox.countdown(killTime, function(event) {//回调函数:不停检测时间，显示到页面上
				var format = event.strftime("%m月 %D天 %H时 %M分 %S秒");
				seckillBox.html(format);
				/*时间倒计时完成后回调事件*/
			}).on("finish.countdown", function() {
				//获取秒杀地址，控制显示逻辑，执行秒杀
				//seckill.handleSeckill(seckillId,seckillBox);
				alert("完成")
			});
		} else {
			alert("done");
		}
	}
</script>
</html>
