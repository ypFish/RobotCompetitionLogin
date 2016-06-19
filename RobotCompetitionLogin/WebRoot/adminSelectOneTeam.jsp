<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style>
    p{ font-size: 14px; font-family:"微软雅黑"; }
    tr{font-size: 14px; font-family:"微软雅黑"; }
</style>
<br/>

	<div>
	<h3>组队信息</h3>

<table border="1" cellspacing="0" cellpadding="2" bordercolor="white" width="560px" align="center">
<tr><td colspan="5">报名科目：${subjectName }</td></tr>
<tr><td colspan="5">组队名称：${teamInfo.teamName }</td></tr>
<tr><td colspan="5">组队密码：${teamInfo.teamPassword }</td></tr>
<tr><td colspan="5">指导教师：${teamInfo.teacherName }</td></tr>
<tr>
	<td>学生名称</td>
	<td>学生学号</td>
	<td>所在学院</td>
	<td>联系电话</td>
	<td>联系邮箱</td>
</tr>
	<c:forEach var="student" items="${listStudent}" >
	<tr>
		<td>${student.studentName }</td>
		<td>${student.studentId }</td>
		<td>${student.studentInstitute }</td>
		<td>${student.studentPhone }</td>
		<td>${student.studentEmail }</td>
	</tr>
	</c:forEach>
</table>
	</div>

</div>
</body>
</html>
