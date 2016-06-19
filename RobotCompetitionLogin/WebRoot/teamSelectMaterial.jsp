<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="TeamMenu.jsp" %>
<style>
	tr { height: 30px;}

</style>
<br/>
<br/>
	<div>
	<span style="font-size:20px; font-family:'微软雅黑';">提供资料下载</span>
		<br/>
		<span style="font-size:14px; font-family:'微软雅黑';">(点击文件名称即可下载)</span>
	<br/>
		<table style="padding-left: 30px;">
	<tr >
		<td style="width: 400px; font-family:'微软雅黑'; height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资料下载</td> <td style="width: 100px; height: 40px; font-family:'微软雅黑'; ">&nbsp;状态</td>
	</tr>
		<c:forEach var="mi" items="${ listMaterial }" >
	<tr>
		<td style="width: 400px; font-family:'微软雅黑';"><a href="doTeamDownloadMaterial?materialName=${mi.materialName}&materialURL=${mi.materialURL}">[${mi.materialName }]</a></td><td style="width: 100px; font-family:'微软雅黑'; ">可下载</td>
	
	</tr>
		</c:forEach>
	</table>


	<br/>
	</div>

</div>
</body>
</html>
