<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<script src="/loan/res/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="/loan/dwr/util.js"></script>
	<script type="text/javascript" src="/loan/dwr/engine.js"></script>
	
	<!-- dwr自动生成的js文件，格式:/工程/路径/interface/java类名.js -->
 	<script type='text/javascript' src='/loan/dwr/interface/DwrPush.js'></script>
        <script type="text/javascript">  
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
		alert("消息:"+msg);
		layer.alert("消息:"+msg);
	}
          
          
      </script>