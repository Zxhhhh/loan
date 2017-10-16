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
    
    <title>My JSP 'personalLoanInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <%@include file="common/navbar.jsp" %>
  
  	<div class="container-fluid-full">
		<div class="row-fluid">
		
		<%@include file="common/sidebar.jsp" %>
		
		<div id="content" class="span10">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					借贷系统 
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="index/toIndex">首页 </a>
					<i class="icon-angle-right"></i>
				</li>
				<li>企业贷款</li>
			</ul>
			
			<div class="row-fluid sortable ui-sortable">
				<div class="box span9">
					<div class="box-header" data-original-title="">
						<h2><i class="halflings-icon user"></i><span class="break"></span>
							企业贷款-信息填写
						</h2>
						<div class="box-icon">
							<a class="btn-minimize" href="#"><i class="halflings-icon white chevron-up"></i></a>
							<a class="btn-close" href="#"><i class="halflings-icon white remove"></i></a>
						</div>					
					</div>
					<div class="box-content">
		  			<form id="myForm" class="form-horizontal">
		  				<fieldset>
			  				<input type="hidden" name="userId" value="${userId}" />
							<div class="control-group">
								<label class="control-label" for="loanName">
									企业名称
								</label>
								<div class="controls">
								  <input class="input-xlarge " id="loanName" type="text" name="loanName" value="" required="required" >
								</div>
							</div>
							  
							  <div class="control-group">
								<label class="control-label" for="loanContactPhone">企业联系人电话：</label>
								<div class="controls">
								  <input class="input-xlarge " id="loanContactPhone" type="text" name="loanContactPhone" value="${user.userInfo.userPhone }" required="required">
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label" for="loanContactName">企业联系人名称：</label>
								<div class="controls">
								  <input class="input-xlarge " id="loanContactName" type="text" name="loanContactName" value="${user.userInfo.userRealname }" required="required" />
								</div>
							  </div>

							  <div class="control-group">
								<label class="control-label" for="loanMoneyIpt">贷款金额：</label>
								<div class="controls">
								  <input class="input-xlarge " type="text" id="loanMoneyIpt" name="loanMoney" value="" required="required" />
								</div>
							  </div>

							  <div class="control-group">
								<label class="control-label" for="loanMonthSelect">贷款时限：</label>
								<div class="controls">
								 <!--  <input class="input-xlarge " type="text" id="loanMoneyIpt" name="loanMoney" value="" /> -->
								  <select class="input-xlarge " id="loanMonthSelect" name="loanMonth" >
			  							<option value="1">一个月</option>
			  							<option value="3">三个月</option>
			  							<option value="6">半年</option>
			  							<option value="12">一年</option>						
			  					  </select><br>
								</div>
							  </div>

							  <div class="control-group">
								<label class="control-label" for="returnMoneyIpt">还款金额：</label>
								<div class="controls">
								  <input class="input-xlarge " type="text" name="loanReturnMoney" readonly="readonly" id="returnMoneyIpt" />
								  &nbsp;&nbsp;<a href="javascript:void(0)" id="returnDetail" class="btn btn-primary">查看还款详情</a>
								</div>
							  </div>
							  
							 <center>
							  	<span id="tip" style="color:red"></span>
							 </center>
							  
							  <div class="form-actions">
								<a class="btn btn-primary" href="javascript:void(0)" id="subBtn" >下一步</a>
								<input type="reset" class="btn" value="重置"  />
							  </div>
							  						  							  								  				
		  				</fieldset>
		  			</form>
		  							
					</div>
				</div>
			</div>
					
		</div>
		
		</div>
	</div>
  
  		<div id="killPhoneModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-center"  id="modalTitle">
							还 款 详 细
						</h5>
					</div>
					<div class="modal-body">
						<div class="row">
							<div align="center" id="detailArea">

							</div>
	
						</div>
					</div>
					<div class="modal-footer">
							
					</div>
				</div>
			</div>
		</div>
  </body>
  <script type="text/javascript">
  	//更换还款期限触发
  	$("#loanMonthSelect").change(function(){
  		var loanMonth = $(this).val();
  		var loanMoney = $("#loanMoneyIpt").val();
  		if(loanMonth != null && loanMonth != undefined && loanMonth != ''&& loanMoney != null && loanMoney != undefined && loanMoney != ''){
  			$.ajax({
  				type:"post",
  				url:"loan/"+loanMoney+"/"+loanMonth+"/getReturnMoney",
  				async:true,
  				success:function(data){
  					if(data.isSuccess){
  						$("#returnMoneyIpt").val(data.data);
  					}else{
  						$("#tip").html(data.errorMessage);
  					}
  				}
  			});
  		}
  	});
  	
  	//输入还款金额触发
  	$("#loanMoneyIpt").blur(function(){
  	    var loanMonth = $("#loanMonthSelect").val();
  		var loanMoney = $(this).val();
  		if(loanMonth != null && loanMonth != undefined && loanMonth != ''&& loanMoney != null && loanMoney != undefined && loanMoney != ''){
  			$.ajax({
  				type:"post",
  				url:"loan/"+loanMoney+"/"+loanMonth+"/getReturnMoney",
  				async:true,
  				success:function(data){
  					if(data.isSuccess){
  						$("#returnMoneyIpt").val(data.data);
  					}else{
  						$("#tip").html(data.errorMessage);
  					}
  				}
  			});
  		}
  	});
  	
  	//获取还款详情
  	$("#returnDetail").click(function(){
  		var loanMoney = $("#loanMoneyIpt").val();
  		var loanMonth = $("#loanMonthSelect").val();
  		if(loanMonth != null && loanMonth != undefined && loanMonth != ''&& loanMoney != null && loanMoney != undefined && loanMoney != ''){
  			alert(loanMoney+"--"+loanMonth);
  			$.ajax({
  				type:"post",
  				url:"loan/"+loanMoney+"/"+loanMonth+"/getReturnDetail",
  				async:true,
  				success:function(data){
  					$("#detailArea").html(data);
  				    $(".modal-footer").html("<a href='javascript:void(0)' id='closeBtn' class='btn btn-success' data-dismiss='modal'>关闭</a>");
  					var killPhoneModal = $("#killPhoneModal");//获得弹出框节点
  					killPhoneModal.modal({
						show : true, //打开弹出层
						backdrop : "static",//禁止位置关闭
						keyboard : false,//关闭键盘事件，禁止键盘关闭
					});
  				}
  			});
  		}else{
  			alert("先输入贷款金额与贷款期限");
  		}
  	});
  	
  	//提交企业贷款信息
  	$("#subBtn").click(function(){
  		var option={
  			url:"loan/saveCompanyLoanInfo",
  			type:"post",
  			headers:{"ClientCallMode" : "ajax"},
			timeout:3000,
			success:function(data){
				alert(1);
				if(data.isSuccess){
					$("#modalTitle").html("资 料  上 传");
					$.ajax({
						type:"post",
						url:"index/toCompanyLoanMaterial",
						async:true,
						success:function(result){
						    $("#detailArea").html(result);
						     $(".modal-footer").html("<a href='javascript:uploadFileFun()' class='btn btn-success'>上传</a>"); //uploadFileFun():上传文件的js方法
						     $(".modal-footer").append("<a href='javascript:void(0)' id='closeBtn' class='btn btn-success' data-dismiss='modal'>上一步</a>");
						   	var killPhoneModal = $("#killPhoneModal");//获得弹出框节点
						    killPhoneModal.modal({
								show : true, //打开弹出层
								backdrop : "static",//禁止位置关闭
								keyboard : false,//关闭键盘事件，禁止键盘关闭
							});
						}
					}); 
				}else{
					$("#tip").html(data.errorMessage);
				}
			}  			
  		};
  		$("#myForm").ajaxSubmit(option);
  	});
  </script>
</html>
