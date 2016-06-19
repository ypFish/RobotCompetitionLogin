<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ include file="teamLoginSession.jsp" %>
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
  
<style>
	span { font-size: 16px; font-family:'微软雅黑'; }
	.check {text-align:left; color: red; font-size: 14px; margin-left: 10px;  visibility: hidden;}
</style>
<body style="text-align:center; ">

<div style="background-color:#39C; margin:0px auto; width:733px; height:1800px; ">

<img src="image/top.jpg"  />
<%@ include file="TeamMenu.jsp" %>
<br/>
<br/>
<br/>
<p><span style="font-size:20px; font-family:'微软雅黑';">修改组队报名信息 </span></p>
<div style="padding-left: 210px;">

<br/>
<div style="text-align: left; margin-left: 40px; ">
<form method="post" action="doTeamUpdateTeam" onsubmit="return check()">



<p><span>报名科目：</span>&nbsp;<input type="text" size="28" name="subjectName" value="${subjectName}"  disabled="disabled">&nbsp;&nbsp;<span style="color:black; font-size: 14px;">（不可修改）</span></p>
<input type="hidden" name="subject" value="${subjectId}" />

	<p><span>组队名称：</span>&nbsp;<input id="teamName" name="teamName" type="text" size="28" maxlength="28" value="${ teamName }" onblur="teamNameBlur()"  onfocus="teamNameFocus()"><span class="check" id="teamNameSpan">组队名称不能为空</span></p>

	<p> <span>设置密码：</span>&nbsp;<input id="password" name="password" type="text" size="28" maxlength="28" value="${teamPassword }" onblur="passwordBlur()" onfocus="passwordFocus()"><span class="check" id="passwordSpan">组队密码大于6位</span></p>
	
	<p><span>指导老师：</span>&nbsp;<input name="teacherName" type="text" value="${teacherName } " size="28"></p>
<br/>
<p style="margin-left: 50px;" ><input type="submit" value="确认修改" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="returnBack()" value=" 返 回 " /></p>

</form>
</div> 
</div>
</div>
</body>
</html>
<script type="text/javascript">


	
	function returnBack(){
		location.href="teamMain.jsp";
	}

 	function teamNameBlur(){
 		var teamNameInput=document.getElementById("teamName");
 		var teamNameSpan=document.getElementById("teamNameSpan");
 		var name=teamNameInput.value.replace(/\s/g, '')
 		if(name.length>0){
 			teamNameSpan.style.visibility="hidden";
 			return true;
 		}else{
 			teamNameSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function teamNameFocus(){
 		document.getElementById("teamNameSpan").style.visibility="hidden";
 	}
 	
 	function passwordBlur(){
 		var passwordInput=document.getElementById("password");
 		var passwordSpan=document.getElementById("passwordSpan");
 		var pass=passwordInput.value.replace(/\s/g, '')
 		if(pass.length>=6){
 			passwordSpan.style.visibility="hidden";
 			return true;
 		}else{
 			passwordSpan.style.visibility="visible";
 			return false;
 		}
 	}
 	function passwordFocus(){
 		document.getElementById("passwordSpan").style.visibility="hidden";
 	}
 	
 
 	
 	function check(){

 		if((teamNameBlur()==true)&&(passwordBlur()==true)){
 			if(confirm("确认是否修改？")){
 				return true;
 			}else{
 				return false;
 			}
 		}else{
 				alert("修改的信息不符合提交规则，请检查……");
 				return false;
 		}
 	}

</script>
