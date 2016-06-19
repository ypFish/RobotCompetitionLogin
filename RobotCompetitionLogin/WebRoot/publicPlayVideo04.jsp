<%@ page language="java" import="java.util.*,com.yupeng.entity.*,com.yupeng.biz.*,com.yupeng.biz.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%@ include file="publicMenu.jsp" %>

<br/>
	<span style="font-size:20px; font-family:'微软雅黑';">往届机器人作品展示</span>
<br/>
<br/>
<span style="font-size:14px; font-family:'微软雅黑';"><a href="publicPlayVideo01.jsp">[随动机器人展示]</a></span>
&nbsp;&nbsp;<span style="font-size:14px; font-family:'微软雅黑';"><a href="publicPlayVideo02.jsp">[蛙跳机器人展示]</a></span>
&nbsp;&nbsp;<span style="font-size:14px; font-family:'微软雅黑';"><a href="publicPlayVideo03.jsp">[足球机器人展示]</a></span>
&nbsp;&nbsp;<span style="font-size:14px; font-family:'微软雅黑';"><a href="publicPlayVideo04.jsp">[魔方机器人展示]</a></span>
	<div> 

<br/>


<object id="NSPlay" width=480 height=400  classid="CLSID:22d6f312-b0f6-11d0-94ab-0080c74c7e95"  codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6，4，5，715"   standby="Loading Microsoft Windows Media Player components..." type="application/x-oleobject"  align="center" hspace="5">  
 <param name="AutoRewind" value=1>
 <param id="fileName" name="FileName" value="video/04.wmv"> 
 <param name="ShowControls" value="1">   
 <param name="ShowPositionControls" value="1"> 
 <param name="ShowAudioControls" value="1">  
 <param name="ShowTracker" value="1"> 
 <param name="ShowDisplay" value="0"> 
 <param name="ShowStatusBar" value="1"> 
 <param name="ShowGotoBar" value="0">  
 <param name="ShowCaptioning" value="0"> 
 <param name="AutoStart" value=1>  
 <param name="Volume" value="-2500">   
 <param name="AnimationAtStart" value="0"> 
 <param name="TransparentAtStart" value="0">  
 <param name="AllowChangeDisplaySize" value="0"> 
 <param name="AllowScan" value="0">  
 <param name="EnableContextMenu" value="0"> 
 <param name="ClickToPlay" value="0">  
 </object> 


<br/>
<input  type="button" value="重新加载" onClick="history.go(0)">
 &nbsp; &nbsp; &nbsp;<input type="button" value=" 播 放 " onClick="NSPlay.play();">

	</div>

</div>
</body>
</html>
