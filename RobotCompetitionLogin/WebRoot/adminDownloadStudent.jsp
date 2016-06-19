<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminLoginSession.jsp" %>
<%@ page contentType="application/msexcel" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Content-disposition","attachment; filename=RobotCompetitionStudentInfo.xls"); 
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
  
  <body>
    <table align="center" border="2" cellspacing="0" cellpadding="2" width="100%">
		<tr>
			<td>学生姓名</td>
			<td>学生学号</td>
			<td>所在学院</td>
			<td>联系电话</td>
			<td>报名科目</td>
			<td>所在组队</td>
		</tr>
			<c:forEach var="tempStudent" items="${listByStudentId}">
		<tr>
			<td >${tempStudent.tsStudent.studentName }</td>
			<td >${ tempStudent.tsStudent.studentId }</td>
			<td >${ tempStudent.tsStudent.studentInstitute }</td>
			<td >${tempStudent.tsStudent.studentPhone }</td>
			<td>
				<table border="2" >
			<c:forEach var="tsSubjectName" items="${tempStudent.tsListSubjectName }">
				<tr>
					<td>${tsSubjectName }</td>
				</tr>
			</c:forEach>
				</table >
			</td>
			<td>	
				<table border="2" >	
			<c:forEach var="tsTeamName" items="${tempStudent.tsListTeamName }">
				<tr>
				<td>${ tsTeamName }</td>
				</tr>
			</c:forEach>
				</table>
				</td>
		</tr>
		</c:forEach>
		
		
	</table>
  </body>
</html>
