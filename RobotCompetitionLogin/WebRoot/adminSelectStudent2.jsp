<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="adminLoginSession.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("listShow")==null){
	response.sendRedirect("doAdminSelectStudent");
}
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
<img src="image/top.jpg" width="732px;"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="adminMenu.jsp" %>
<style type="text/css">
	span { font-size: 14px;font-family:"微软雅黑"; }
	 tr{ text-align: center; font-family:"微软雅黑"; font-size: 14px; }
</style>
	<div>
	<br/>
	<h3>查看已报名学生信息</h3>
	<p>&nbsp;&nbsp;<input type="button" value="一键导入Excel" onclick="javascript:location.href='adminDownloadStudent.jsp'" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span style="font-size: 14px; font-family:'微软雅黑'; text-align: right;">(点击列名可以按此列排序)</span></p>

<div id="tab" >
	<table align="center" border="2 " cellspacing="0" cellpadding="2" bordercolor="white"  bordercolor="#FFFFFF" style="font-size:14px; border-style:solid; border-width:1px; width:530px;">
		<tr>
			<td><span><a href="doAdminSelectStudent?info=tab&show=">[学生姓名]</a></span></td>
			<td><span><a href="doAdminSelectStudent?info=tab&show=byStudentId">[学生学号]</a></span></td>
			<td><span><a href="doAdminSelectStudent?info=tab&show=byStudentInstitute">[所在学院]</a></span></td>
			<td><span><a href="doAdminSelectStudent?info=tab&show=">[联系电话]</a></span></td>
			<td><span><a href="doAdminSelectStudent?info=tab&show=byTeamName">[报名科目]</a></span></td>
			<td><span><a href="doAdminSelectStudent?info=tab&show=byTeamName">[所在组队]</a></span></td>
		</tr>
		<c:forEach var="tempStudent" items="${listShow}">
		<tr>
			<td >${tempStudent.tsStudent.studentName }</td>
			<td >${ tempStudent.tsStudent.studentId }</td>
			<td >${ tempStudent.tsStudent.studentInstitute }</td>
			<td >${tempStudent.tsStudent.studentPhone }</td>
			<td>
				<table style="font-size: 14px;">
			<c:forEach var="tsSubjectName" items="${tempStudent.tsListSubjectName }">
				<tr>
					<td>${ tsSubjectName }</td>
				</tr>
			</c:forEach>
				</table >
			</td>
			<td>	
				<table style="font-size: 14px;">	
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
	<br/>
	<p>
	页数：
	<c:forEach var="p" items="${listP}">
		<span><a href="doAdminSelectStudent?p=${p}&show=${whichList}">[${p}]</a></span>&nbsp;
		
	</c:forEach>
	</p>
</div>
</div>
</div>
</body>
</html>
