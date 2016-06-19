<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/doRegister" />
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
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px;  ">
<br/>
<h3>选择报名科目</h3>
<h4>请从以下竞赛科目中选择一项进行报名，报名方式：以小组为单位：</h4>

	<div>
	<form action="doRegisterSelectSubject" method="post">
	
	<c:forEach var="subjectInfo" items="${listSubjectInfo}" >
		<p style="margin-left:120px; text-align:left; font-family:'微软雅黑';" ><input name="subjectInfo" type="radio" value=${subjectInfo.subjectId} checked="checked"/>${subjectInfo.subjectName}(限制报名人数：${subjectInfo.peopleNumber}人)</p>
		
	</c:forEach>
	<br/>
	<input  type="submit" value="  继  续   ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input  type="button" value="  返  回   " onclick="javascript:location.href='main.html'"> 
	</form>
	</div>

</div>
</body>
</html>
