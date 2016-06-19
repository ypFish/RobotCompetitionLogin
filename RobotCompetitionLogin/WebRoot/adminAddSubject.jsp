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
	<h3>添加竞赛科目</h3>
	<br/>
	<form action="doAdminAddSubject.jsp" method="post" onsubmit="return check()">
	
	<p>竞赛科目名称：<input type="text" maxlength="28" name="subjectName" size="28"  id="subjectName" onblur="subjectNameBlur()" onclick="subjectNameClick()"><span style="color:#F00; font-size:14px; display:none;" id="spanName">科目名称不能为空</span></p>
    <p>允许最大报名人数：<select name="peopleNumber" id="peopleNumber">
    					<option value="1" >1人</option>
                        <option value="2" >2人</option>
                        <option value="3" selected="selected" >3人</option>
                        <option value="4" >4人</option>
                        <option value="5" >5人</option>

    					</select>
	<p>竞赛科目介绍（包括竞赛规则、实现方式等）</p>
    <textarea name="subjectInformation" id="subjectInformation" rows="10"  cols="50"></textarea>
    
    <p><input type="submit" value="确认提交"></p>
</form>
<script type="text/javascript">
function subjectNameBlur(){
	var spanName=document.getElementById("spanName");
	var inputName=document.getElementById("subjectName");
	if(inputName.value.length==0){
		spanName.style.display="block";
			return false;
		}else{
			spanName.style.display="none";
			return true;
		}
	}

function subjectNameClick(){
	spanName=document.getElementById("spanName").style.display="none";
	}

function check(){
	if((subjectNameBlur())){
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
