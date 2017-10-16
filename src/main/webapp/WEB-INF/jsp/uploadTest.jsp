<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/commonTag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>文件上传</title>
    <style media="screen">
    .wrap{
      width: 450px;
      height: 450px;
      border: 1px solid black;
      margin: 100px auto;
      padding: 20px;
    }
    .file-name{

    }
    .progressNumber{
      width: 80%;
      height: 20px;
      background: #ccc;
      margin: auto;
      border-radius: 10px;
      text-align: center;
    }
    .file-wrap{
      position: relative;
      width: 80%;
      margin: 30px auto;
    }
    .file-div{
      position: absolute;
      left: 36%;
      z-index: 50;
    }
    .fileInputP{
      display: inline-block;
      width: 120px;
      height: 30px;
      border-radius: 5px;
      overflow: hidden;
      position: relative;
    }
    .fileInputP span{
      display: inline-block;
      width: 110px;
      height: 30px;
      color: #fff;
      background: #0e90d2;
      text-align: center;
      line-height: 30px;
      cursor: pointer;
      border-radius: 5px;

    }
    .fileInputP input{
      position: absolute;
      left: 0;
      top: 0;
      right: 0;
      bottom: 0;
      opacity: 0;
    }
    .fileSpan {
      display: inline-block;
      width: 100%;
      height: 150px;
      border: 2px dashed #ccc;
      text-align: center;
      line-height: 100px;
      position: relative;
    }

    
    .file{
      position: relative;
    }
    .updata{
      cursor: pointer;
      color: #142ae4;
      font-weight: bold;
      position: absolute;
      right: 30px;ß
    }
    </style>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  </head>
  <body>
  <form id="myForm" enctype="multipart/form-data">
	  <div class="wrap">
	    <div class="file">
	      <p>
	        <span>个人相关资料文件：</span>
	        <span id="file-name1"></span>
	        <span class="updata">上传</span>
	      </p>
	      <p class="progressNumber" id="progressNumber"> 我是进度条 </p>
	    </div>
	    <div class="file-wrap">
	      <div class="file-div">
	        <p class="fileInputP">
	            <span>选择文件</span>
	            <input type="file" multiple id="fileInput_1" name="file" />
	        </p>
	      </div>
	
	      <span id="fileSpan1" class="fileSpan">
	         <img width="200" height="100" id="previewImg1" />
	      </span>
	      
	    </div>
	    <hr>
	    <div class="file">
	      <p>
	        <span>相关抵押资料文件：</span>
	        <span id="file-name2"></span>
	      </p>
	     <!--  <p class="progressNumber" id="progressNumber"> 我是进度条 </p> -->
	    </div>
	    <div class="file-wrap">
	      <div class="file-div">
	        <p class="fileInputP">
	            <span>选择文件</span>
	            <input type="file" multiple id="fileInput_2" name="file2" />
	        </p>
	      </div>
	
	      <span id="fileSpan2" class="fileSpan">
	      	  <img width="200" height="200" id="previewImg2" />
	      </span>
	    </div>
	    
	  </div>
	  
	  
	  
  </form>
  </body>
  <script type="text/javascript">
    var fileObj1; // 文件对象
    var fileobj2;
    $("#fileInput_1").on("change",function(){
      // 当前所选文件
      fileList1(this.files);
    });

    // 拖拽外部文件，进入目标元素触发 dragenter 用户开始拖动元素时触发
    $("#fileSpan1").on("dragenter",function(){
      $(this).css("background","#ccc");
      $("#span-p1").text('可以释放鼠标了');
    });
    //拖拽外部文件，进入目标，离开目标，防止连续触发
    //ondragover - 当某被拖动的对象在另一对象容器范围内拖动时触发此事件
    $("#fileSpan1").on("dragover",function(){
      return false;
    });
    //拖拽外部文件，离开目标元素触发
    //ondragleave - 当被鼠标拖动的对象离开其容器范围内时触发此事件
    $("#fileSpan1").on("dragleave",function(){
      $(this).css("background","none");
    });
    //ondrop - 在一个拖动过程中，释放鼠标键时触发此事件
    $("#fileSpan1").on("drop",function(e){
      //HTML5的File API提供了一个fileList1的接口，它
      // 可以通过拖拽事件的e.dataTransfer.files来传递的文件信息，获取本地文件列表信息。
      var file = e.originalEvent.dataTransfer.files;
      fileList1(file);
      
      $(this).css("background", "none");
        return false;
    });

    function fileList1(obj){
      // 如果没有文件
      if(obj.length < 1){
        return false;
      }else if(obj.length > 1){
        $("#fileSpan1").text("每次只能上传一个文件！");
      }else {
      
      }
      fileObj1 = obj[0]; // 获取当前的文件对象
      var name = obj[0].name;
      $("#file-name1").html(name);
      
	  var reader = new FileReader();
	  reader.onload = function() {
		var url = reader.result;
		setImageURL1(url);
	  };
	  reader.readAsDataURL(fileObj1);
    }
        var image1 = $("#previewImg1")[0];
		function setImageURL1(url) {
			image1.src = url;
		}
    
    $("#fileInput_2").on("change",function(){
      // 当前所选文件
      fileList2(this.files);
    });
    // 拖拽外部文件，进入目标元素触发 dragenter 用户开始拖动元素时触发
    $("#fileSpan2").on("dragenter",function(){
      $(this).css("background","#ccc");
      $("#span-p2").text('可以释放鼠标了');
    });
    //拖拽外部文件，进入目标，离开目标，防止连续触发
    //ondragover - 当某被拖动的对象在另一对象容器范围内拖动时触发此事件
    $("#fileSpan2").on("dragover",function(){
      return false;
    });
    //拖拽外部文件，离开目标元素触发
    //ondragleave - 当被鼠标拖动的对象离开其容器范围内时触发此事件
    $("#fileSpan2").on("dragleave",function(){
      $(this).css("background","none");
    });
    //ondrop - 在一个拖动过程中，释放鼠标键时触发此事件
    $("#fileSpan2").on("drop",function(e){
      //HTML5的File API提供了一个fileList1的接口，它
      // 可以通过拖拽事件的e.dataTransfer.files来传递的文件信息，获取本地文件列表信息。
      var file = e.originalEvent.dataTransfer.files;
      fileList2(file);
      $(this).css("background", "none");
        return false;
    });

    function fileList2(obj){
      // 如果没有文件
      if(obj.length < 1){
        return false;
      }else if(obj.length > 1){
        $("#fileSpan2").text("每次只能上传一个文件！");
      }else {
      
      }
      fileobj2 = obj[0]; // 获取当前的文件对象
      var name = obj[0].name;
      $("#file-name2").html(name);
      
      var reader = new FileReader();
	  reader.onload = function() {
		var url = reader.result;
		setImageURL2(url);
	  };
	  reader.readAsDataURL(fileobj2);
    }
        var image2 = $("#previewImg2")[0];
		function setImageURL2(url) {
			image2.src = url;
		}
    
    
   
	     // 点击文件上传的方法
	    function uploadFileFun(){
	      var fd = new FormData(); // 定义fromdata对象
	      fd.append("file",fileObj1); // 传给后台的参数 “file” 参数名 fileObj 文件对象
	      fd.append("file2",fileobj2);
	      /**
	      可以通告append 方法在 FormData对象里面添加参数
	      //fd.append("fileOid",fileOid);
	      // 可以在添加参数，fileOid是后台返回的，判断当前上传的文件是第几次上传的，第一次 传空字符串
	      XMLHTTPRequest 对象，有progress 事件，用来返回进度信息
	      -- 下载的progress 事件属于XMLHTTPRequest 对象
	      -- 上传的progress 事件属于 XMLHTTPRequest.upload 对象
	      **/
	      var xhr;
	      xhr = new XMLHttpRequest();
	      
	      xhr.upload.addEventListener("progress",uploadProgress,false); // 传输进度
	      xhr.addEventListener("load",uploadComplete,false);// 传输成功
	      xhr.addEventListener("error",uploadFailed,false); //传输中出现错误
	      // xhr.addEventListener("loadstart", " 我是函数名 ",false); // 传输开始
	      // xhr.addEventListener("loadEnd", " 我是函数名 ",false); // 传输结束，但是不知道是否成功
	      xhr.open("POST", "/loan/loan/uploadMe"); // 给后台提交的路径
	      xhr.send(fd);
	    }

    // 传输进度的方法 进度条显示
    function uploadProgress(evt) {
        if (evt.lengthComputable) {
          //evt.total 需要传输的总字符，evt.loaded 是已经上传的字节
          // if evt.lengthComputable 不为真  evt.total 等于 0
            var percentComplete = Math.round(evt.loaded * 100 / evt.total);
            // 上传的进度状态
            $('#progressNumber').progressbar('setValue', percentComplete);
        }
        else {//大小无法计算
            document.getElementById('progressNumber').innerHTML = "大小无法计算";
        }
    }
    //传输成功的方法
    function uploadComplete(evt){
      //服务器返回的数据
      var message = JSON.parse(evt.target.responseText);
      if(message.isSuccess){ // 后台返回的code值
        alert("上传成功！");
      }else if(message.code == "fail"){
        alert("上传失败！");
      }
    }
    // 传输中出现错误
    function uploadFailed(evt){
      alert("删除出错！");
    }
    
     $(".updata").click(function(){
     	uploadFileFun();
     });
    
    
/*     $(".updata").click(function(){
    	var option ={
    		type:"post",
    		url:"/loan/loan/uploadMe",
    		headers:{"ClientCallMode":"ajax"},
    		timeout:3000,
    		success:function(data){
    			alert(1);
    		}
    	};
    	$("#myForm").ajaxSubmit(option);
    }); */
    
  </script>
</html>