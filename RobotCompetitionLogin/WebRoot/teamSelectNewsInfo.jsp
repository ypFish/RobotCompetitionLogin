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
  
<body style="text-align:center">
<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1100px; ">
<%@ include file="TeamMenu.jsp" %>

<br/>


	<span style="font-size:20px; font-family:'微软雅黑';">标题：${ni.newsName } </span>

	<p><span style="font-size:16px; font-family:'微软雅黑';">发布时间：${ni.datetime}</span></p>

	<div style="float:right; width: 520px; height:900px; border-style:solid; border-width:2px; background-color: white;  text-align: left; font-family:'微软雅黑'; margin-right:30px; padding-left: 10px; padding-right: 10px; padding-top: 10px;  word-spacing:30px; line-height: 24px;">
		${ni.newsContent}
	</div>
	
	
	<br/>
	</div>


</body>
</html>
