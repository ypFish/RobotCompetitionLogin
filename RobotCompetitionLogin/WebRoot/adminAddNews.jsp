<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="shortcut icon" type="image/x-icon" href="image/robot32.ico" media="screen" />
    <base href="<%=basePath%>">
    
    <title>北京工业大学机器人竞赛报名平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body style="text-align:center">
<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="adminMenu.jsp" %>

	<div>
	<br/>
	<h3>添加竞赛通知</h3>
	<br/>
	
	<form action="doAdminAddNews.jsp" method="post" onsubmit="return check()">
	
	<p>竞赛通知名称：<input type="text" maxlength="28" name="newsName" size="28" id="newsName" onblur="newsNameBlur()" onclick="newsNameClick()"><span style="color:#F00; font-size:14px; display:none;" id="spanName">通知名称不能为空</span></p>

	<p>竞赛通知内容 (注意：发布时间默认为系统当前时间):</p>
    <textarea  rows="10"  cols="60" name="newsContent" id="newsContent" onblur="newsContentBlur()" onclick="newsContentClick()" ></textarea>
    <span style="color:#F00; font-size:14px; display:none;" id="spanContent">科目内容不能为空</span>
   
    <p><input type="submit" value="确认提交"></p>
</form>
<script type="text/javascript">
function newsNameBlur(){
	var spanName=document.getElementById("spanName");
	var inputName=document.getElementById("newsName");
	if(inputName.value.length==0){
		spanName.style.display="block";
			return false;
		}else{
			spanName.style.display="none";
			return true;
		}
	}

function newsNameClick(){
	document.getElementById("spanName").style.display="none";
	}
	
function newsContentBlur(){
	var spanName=document.getElementById("spanContent");
	var inputName=document.getElementById("newsContent");
	if(inputName.innerHTML.length==0&&inputName.value.length==0){
		spanName.style.display="block";
			return false;
		}else{
			spanName.style.display="none";
			return true;
		}
	}

function newsContentClick(){
	document.getElementById("spanContent").style.display="none";
	}

function check(){
	if(newsNameBlur()&&newsContentBlur()){
		return true;
	}else{
		return false;
		}	
	}

</script>
	
	</div>

</div>
</body>
</html>
