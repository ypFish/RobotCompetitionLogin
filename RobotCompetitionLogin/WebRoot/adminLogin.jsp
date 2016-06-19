<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
 	span {font-size:16px; font-family:'微软雅黑';}
 </style>
<body style="text-align:center">
<img src="image/top.jpg"  />
<div style="background-color:#39C;  margin:0px auto; width:733px; height:400px; ">
<form action="doAdminLogin.jsp" method="post">
<br/>
<br/>
<%
	if(session.getAttribute("login")!=null){
			String result=(String)session.getAttribute("login");
			if(result.equals("RobotCompetitionLoginAdmin")){
			
			}else{
			out.print("<span>"+result+"!</span>");
			}
	}
	session.removeAttribute("login");
 %>
<br/>
<br/>
<table  align="center" style=" width:340px;">
<tr align="center"  style="height: 50px;">
	<td colspan="2"><span style="font-size: 20px;">管理员登录</span></td>
</tr>
<tr align="center" style="height: 40px;" >
	<td><span>管理员名称:</span>&nbsp;</td><td><input type="text" name="adminName" id="adminName" maxlength="29" size="27" /> </td>
</tr>

<tr align="center" style="height: 40px;">
	<td><span>管理员密码:</span>&nbsp;</td><td><input type="password" name="adminPassword" id="adminPassword" maxlength="29" size="28" /></td>
</tr >

<tr align="center" style="height:60px;"><td><input type="submit" value="  确 定  "></td><td><input type="button" value="  返 回  " onclick="window.location.href='main.html'"></td></tr>
</table>

</form>
</div>
  </body>
</html>
