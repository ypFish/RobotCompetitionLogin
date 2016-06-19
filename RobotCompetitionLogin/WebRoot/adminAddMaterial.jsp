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
<br/>
	<div>
	<h3>添加竞赛资料</h3>
	<br/>
	<br/>
	<form action="adminUploadMaterial2.jsp"  enctype="multipart/form-data" method="post" accept-charset="utf-8">
	
	<p>添加资料：<input type="file" name="materialName" /></p>
	<p  style="font-size: 14px;">（注意：上传文件大小限制为20M。）</p>
	<br/>
	<p>设定权限：<select name="materialLimit">
					<option value="3">全部可见</option>
					<option value="2" selected="selected">报名小组及管理员可见</option>
					<option value="1">仅管理员可见</option>
				</select>
	</p>
	<br/>
	<br/>
	<p><input type="submit" value=" 上 传  " />&nbsp;&nbsp;&nbsp;<input type="button" value="  返 回  " onclick="javascirpt:location.href='admin.jsp'" /></p>
	
	</form>
	
	
	</div>

</div>
</body>
</html>
