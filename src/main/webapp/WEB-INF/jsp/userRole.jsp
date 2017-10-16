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

<title>实名认证</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<%@ include file="common/navbar.jsp"%>

	<div class="container-fluid-full">
		<div class="row-fluid">

			<%@ include file="common/sidebar.jsp"%>
			<div id="content" class="span10">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> 借贷系统 <i class="icon-angle-right"></i>
					</li>
					<li><a href="index/toIndex">首页 </a> <i
						class="icon-angle-right"></i></li>
					<li><a href="index/toUserCenter_info">个人中心</a> <i
						class="icon-angle-right"></i></li>
					<li>权限一览</li>
				</ul>
				<div class="row-fluid sortable ui-sortable">
					<div class="box span11">
						<div class="box-header" data-original-title="">
							<h2>
								<i class="halflings-icon user"></i><span class="break"></span>
								我的权限
							</h2>
							<div class="box-icon"></div>
						</div>
						<div class="box-content">

							<table
								class="table table-striped table-bordered bootstrap-datatable datatable "
								id="DataTables_Table_0">
								<thead>
									<tr role="row">
										<c:forEach items="${types}" var="type">
											<th tabindex="0" class="sorting_asc" role="columnheader"
												aria-controls="DataTables_Table_0" style="width: 238px;"
												aria-label="Username: activate to sort column descending"
												aria-sort="ascending" rowspan="1" colspan="1">
												${type.roleName }</th>
										</c:forEach>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<tr class="even">
										<c:forEach items="${user.userRoles}" var="role">
											<c:choose>
												<c:when test="${role.roleLevel=='1' }">
													<td class="center"><span class="label label-success">YES</span>
													</td>
												</c:when>
												<c:otherwise>
													<td class="center"><span class="label label-important">NO</span>
													</td>
												</c:otherwise>
											</c:choose>
										</c:forEach>

									</tr>
								</tbody>
							</table>
							<a class="btn btn-primary" href="index/toFeedback">前往反馈</a>

						</div>
					</div>
				</div>
				<div class="row-fluid sortable ui-sortable">
					<div class="box span11">
						<div class="box-header">
							<h2><i class="halflings-icon white list"></i><span class="break"></span>我的状态</h2>
							<div class="box-icon">
							</div>
						</div>
						<div class="box-content">
							<ul class="dashboard-list metro">
								<li>
										<i class="icon-arrow-up green"></i>                               
										<strong>实名验证</strong>
										<c:choose>
											<c:when test="${user.userState.isCertification=='1' }">
												<span class="label label-success">YES</span>
											</c:when>
											<c:otherwise>
												<span class="label label-important">NO</span>
											</c:otherwise>
										</c:choose> 
										没有实名认证将无法进行借贷服务                           
								</li>
							  <li>
								  <i class="icon-arrow-down red"></i>
								  <strong>账户屏蔽</strong>
										<c:choose>
											<c:when test="${user.userState.isShield=='1' }">
												<span class="label label-success">YES</span>
											</c:when>
											<c:otherwise>
												<span class="label label-important">NO</span>
											</c:otherwise>
										</c:choose>
										账户被屏蔽时无法使用反馈服务
							  </li>
							  <li>
								<a href="#">
								  <i class="icon-minus blue"></i>
								  <strong>账户冻结</strong>
										<c:choose>
											<c:when test="${user.userState.isFreeze=='1' }">
												<span class="label label-success">YES</span>
											</c:when>
											<c:otherwise>
												<span class="label label-important">NO</span>
											</c:otherwise>
										</c:choose>
										账户被冻结时无法登录                             
								</a>
							  </li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	
</script>
</html>
