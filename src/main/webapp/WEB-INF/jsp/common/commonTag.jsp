<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
  <head>
	
	<link rel="stylesheet" href="/loan/res/css/bootstrap.css">
	<link id="bootstrap-style" href="/loan/res/css/bootstrap.min.css" rel="stylesheet">
	<link href="/loan/res/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="/loan/res/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="/loan/res/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="/loan/res/img/favicon.ico">
	
	
		<script src="/loan/res/js/jquery-1.9.1.min.js"></script>
			<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<!-- <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> -->
		<script src="/loan/res/js/jquery-migrate-1.0.0.min.js"></script>
		<script src="/loan/res/js/jquery-ui-1.10.0.custom.min.js"></script>
		<script src="/loan/res/js/jquery.ui.touch-punch.js"></script>
		<script src="/loan/res/js/modernizr.js"></script>
		<script src="/loan/res/js/bootstrap.min.js"></script>
		<script src="/loan/res/js/jquery.cookie.js"></script>
		<script src="/loan/res/js/fullcalendar.min.js"></script>
		<script src="/loan/res/js/jquery.dataTables.min.js"></script>
		<script src="/loan/res/js/excanvas.js"></script>
		<script src="/loan/res/js/jquery.flot.js"></script>
		<script src="/loan/res/js/jquery.flot.pie.js"></script>
		<script src="/loan/res/js/jquery.flot.stack.js"></script>
		<script src="/loan/res/js/jquery.flot.resize.min.js"></script>
		<script src="/loan/res/js/jquery.chosen.min.js"></script>
		<script src="/loan/res/js/jquery.uniform.min.js"></script>
		<script src="/loan/res/js/jquery.cleditor.min.js"></script>
		<script src="/loan/res/js/jquery.noty.js"></script>
		<script src="/loan/res/js/jquery.elfinder.min.js"></script>
		<script src="/loan/res/js/jquery.raty.min.js"></script>
		<script src="/loan/res/js/jquery.iphone.toggle.js"></script>
		<script src="/loan/res/js/jquery.uploadify-3.1.min.js"></script>
		<script src="/loan/res/js/jquery.gritter.min.js"></script>
		<script src="/loan/res/js/jquery.imagesloaded.js"></script>
		<script src="/loan/res/js/jquery.masonry.min.js"></script>
		<script src="/loan/res/js/jquery.knob.modified.js"></script>
		<script src="/loan/res/js/jquery.sparkline.min.js"></script>
		<script src="/loan/res/js/counter.js"></script>
		<script src="/loan/res/js/retina.js"></script>
		<script src="/loan/res/js/custom.js"></script>
	
	<script src="/loan/res/js/bootstrap.min.js"></script> 
	<!-- <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<script src="/loan/res/js/jquery-form.js"></script>
	<script src="/loan/res/js/jquery.validate.min.js"></script>
	<script src="/loan/res/layer/layer.js"></script>
	
	<script type="text/javascript" src="/loan/dwr/util.js"></script>
	<script type="text/javascript" src="/loan/dwr/engine.js"></script>
	
	<!-- dwr自动生成的js文件，格式:/工程/路径/interface/java类名.js -->
 	<script type='text/javascript' src='/loan/dwr/interface/DwrPush.js'></script>

  </head>
  <body>
  		<div id="message"></div> 
  		
	<div id="lockModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"></span>
					</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div align="center">
							<input type="text"   id="lockCode" class="form-control" />
							<br>
							<span style="font-size:13px;color:gray">输入用户名以解锁</span>
						</div>
						
					</div>
				</div>

				<div class="modal-footer">
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="unlockBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-lock"></span> 解锁
					</button>
				</div>
			</div>
		</div>
	</div>  		
  		
  </body>
        <script type="text/javascript">  
        
        function lock(){
			var lockModal = $("#lockModal");//获得弹出框节点
			//显示弹出层
			lockModal.modal({
				show : true, //打开弹出层
				backdrop : "static",//禁止位置关闭
				keyboard : false,//关闭键盘事件，禁止键盘关闭
			});        
        }
/*           var websocket = null;  
             
          //判断当前浏览器是否支持WebSocket  
          if('WebSocket' in window){  
              websocket = new WebSocket("ws://localhost:8080/loan/websocket");  
          }  
          else{  
              alert('Not support websocket')  
          }  
             
          //连接发生错误的回调方法  
          websocket.onerror = function(){  
              setMessageInnerHTML("error");  
          };  
             
          //连接成功建立的回调方法  
          websocket.onopen = function(event){  
              //setMessageInnerHTML("open");  
          }  
             
          //接收到消息的回调方法  
          websocket.onmessage = function(event){  
              setMessageInnerHTML(event.data);  
          }  
             
          //连接关闭的回调方法  
          websocket.onclose = function(){  
              //setMessageInnerHTML("close");  
          }  
             
          //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。  
          window.onbeforeunload = function(){  
              websocket.close();  
          }  
             
          //将消息显示在网页上  
          function setMessageInnerHTML(innerHTML){ 
             // document.getElementById('message').innerHTML += innerHTML + '<br/>';
             alert(innerHTML);  
          }  
             
          //关闭连接  
          function closeWebSocket(){  
              websocket.close();  
          }  
             
          //发送消息  
          function send(){  
              var message = document.getElementById('text').value;  
              websocket.send(message);  
          }   */
          
     $(function() {
		// 页面加载的时候进行反转的激活
		/* dwr.engine.setActiveReverseAjax(true); */
		dwr.engine.setActiveReverseAjax(true);
		dwr.engine.setNotifyServerOnPageUnload(true);
		onLoadPage();
		if(window.sessionStorage.getItem("lock")=='true'){
        	lock();
        }
	});
	
	$("#unlockBtn").click(function(){
		var ipt = $("#lockCode").val();
		if(ipt=='zxh'){
			window.sessionStorage.setItem("lock",false);
			$("#lockModal").modal('hide');
		}
	});
	
	function onLoadPage(){
		var role = '';
		var name = '';
		var user = "${user}";
		if(user != null && user != undefined && user != ''){
			role = "user";
			name = "${user.user.username}";
		}else{
			var admin = "${admin}";
			if(admin != null && admin != undefined && admin != ''){
				role = "admin";
				name = "admin"; //TODO
			}
		}
		DwrPush.OnPage(role,name);
	}
	
	//////////////////////////////////////用于后台调取的函数
	function callback(msg) {
		layer.open({
		  title: '反馈'
		  ,content: msg,
		  offset:'rb',
		  anim:2,
		  shade:0,
		  skin: 'layui-layer-lan'
		}); 
	}
	
	//接到通知的js操作
	function serverCall(msg){
		//alert("serverCall:"+msg);
		
		//右下角提示
		layer.open({
		  title: '消息推送'
		  ,content: msg,
		  offset:'rb',
		  anim:2,
		  shade:0,
		  skin: 'layui-layer-lan',
		  yes:function(){
		  	window.location.reload();
		  }
		});
		
		//右上角提示
		$('#remindStart').attr("data-original-title","有一条新消息,请查看");
		$('#remindStart').tooltip('show');
		
		
		//右上角标志		
		var newUnread = parseInt($("#remindCount").html())+1;
		$("#remindCount").html(newUnread);
		
	}
          
      </script>
  
</html>
