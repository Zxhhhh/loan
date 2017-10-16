<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html"><span>借贷系统</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<li class="dropdown hidden-phone">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#" id="lockBtn">
								<i class="icon-lock"></i>
								<span class="badge ">
								锁屏 </span>
							</a>
<!-- 							<ul class="dropdown-menu notifications">
								<li class="dropdown-menu-title">
 									<span>您有 11 条反馈得到回复</span>
									<a href="#refresh"><i class="icon-repeat"></i></a>
								</li>	
                            	<li>
                                    <a href="#">
										<span class="icon blue"><i class="icon-user"></i></span>
										<span class="message">New user registration</span>
										<span class="time">1 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">7 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">8 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">16 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon blue"><i class="icon-user"></i></span>
										<span class="message">New user registration</span>
										<span class="time">36 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon yellow"><i class="icon-shopping-cart"></i></span>
										<span class="message">2 items sold</span>
										<span class="time">1 hour</span> 
                                    </a>
                                </li>
								<li class="warning">
                                    <a href="#">
										<span class="icon red"><i class="icon-user"></i></span>
										<span class="message">User deleted account</span>
										<span class="time">2 hour</span> 
                                    </a>
                                </li>
								<li class="warning">
                                    <a href="#">
										<span class="icon red"><i class="icon-shopping-cart"></i></span>
										<span class="message">New comment</span>
										<span class="time">6 hour</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">yesterday</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon blue"><i class="icon-user"></i></span>
										<span class="message">New user registration</span>
										<span class="time">yesterday</span> 
                                    </a>
                                </li>
                                <li class="dropdown-menu-sub-footer">
                            		<a>View all notifications</a>
								</li>	
							</ul> -->
						</li>
						
						<!-- start: Message Dropdown -->
						<li class="dropdown hidden-phone">
							<a class="btn dropdown-toggle" data-toggle="dropdown"  data-original-title="有新消息,请尽快查看" data-placement="bottom" href="#" id="remindStart">
								<i class="icon-envelope"></i>
								<span class="badge red" id="remindCount">
								${unreadRemindCount } </span>
							</a>
							<ul class="dropdown-menu messages" id="remindUl">
								<li class="dropdown-menu-title">
 									<span>您有 ${unreadRemindCount } 条未读消息</span>
									<a href="javascript:window.reload();"><i class="icon-repeat"></i></a>
								</li>
								<c:forEach items="${unreadRemind }" var="r" begin="0" end="5" step="1">
									<li class="remindLi" lang="${r.remindContent }" title="${r.id }" >
	                                    <a href="#">
											<span class="avatar"><img src="/loan/res/img/timg.jpg" alt="Avatar"></span>
											<span class="header">
												<span class="from">
											    	<c:choose>
											    		<c:when test="${r.remindType=='0' }">
											    				系统推送
											    		</c:when>
											    		<c:when test="${r.remindType=='1' }">
											    				贷款反馈
											    		</c:when>
											    		<c:when test="${r.remindType=='2' }">
											    				借款反馈
											    		</c:when>
											    		<c:when test="${r.remindType=='3' }">
											    				审核提醒
											    		</c:when>
											    	</c:choose>
											     </span>
												<span class="time">
													<fmt:formatDate pattern="yyyy-mm-dd hh:mm" value="${r.createDate }"/>
											    </span>
											</span>
	                                        <span class="message">
	                                        	<c:choose>
	                                        		<c:when test="${fn:length(r.remindContent)>10 }">
	                                        			${fn:substring(r.remindContent,0,10)}...
	                                        		</c:when>
	                                        		<c:otherwise>
	                                        			${r.remindContent }
	                                        		</c:otherwise>
	                                        	</c:choose>
	                                        	
	                                        </span>  
	                                    </a>
	                                </li>
								</c:forEach>

								<li>
                            		<a href="index/toRemindCenter" class="dropdown-menu-sub-footer">查看全部新通知</a>
								</li>	
							</ul>
						</li>
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> ${user.user.username }
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>个人中心</span>
								</li>
								<li><a href="index/toUserCenter_info"><i class="halflings-icon user"></i>个人信息</a></li>
								<li><a href="index/toCertification"><i class="halflings-icon list-alt"></i>实名认证</a></li>
								<li><a href="index/toUserRole"><i class="halflings-icon lock"></i>我的权限</a></li>
								<li><a href="user/logout"><i class="halflings-icon off"></i>退出系统</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
  	<div id="navbarModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center">
						新消息
					</h5>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center" id="navbarArea" style="text-align:center;margin-left:10px">
							
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<a href="javascript:void(0)" id="closeBtn" class="btn btn-success" data-dismiss="modal">关 闭</a>
				</div>
			</div>
		</div>
	</div>	
	
	<script type="text/javascript">
	
		$(function(){
			var count = parseInt($("#remindCount").text());
			if(count>0){
				$('#remindStart').tooltip('show');
			}
		});
		$("#remindStart").hover(function(){
			$('#remindStart').tooltip('destroy');
			$('#remindStart').attr("data-original-title","");
		});
		
		$(".remindLi").click(function(){
			var content = $(this).attr("lang");
			var id = $(this).attr("title");
			var li = $(this);
			var newUnread = parseInt($("#remindCount").html())-1;
			$.ajax({
	  			type:"post",
	  			url:"remind/"+id+"/Y/remindStateChange",
	  			async:true,
	  			success:function(data){
	  				if(data.isSuccess){
						$("#navbarArea").html("<center>"+content+"</center>");
						var navbarModal = $("#navbarModal");//获得弹出框节点
						//显示弹出层
						navbarModal.modal({
							show : true, //打开弹出层
							backdrop : "static",//禁止位置关闭
							keyboard : false,//关闭键盘事件，禁止键盘关闭
						});
						$("#remindCount").html(newUnread);
						li.remove();
					}else{
					
					}
	  			}
	  		});
		});
		
		$("#lockBtn").click(function(){
			window.sessionStorage.setItem("lock",true);
			window.location.reload();
		});
		
		
	</script>