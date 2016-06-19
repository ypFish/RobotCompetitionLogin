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
	 span{ font-family:"微软雅黑"; font-size: 14px;  }
	 
</style>  
<body style="text-align:center">
<img src="image/top.jpg"  />
<div style="background-color:#39C; margin:0px auto; width:733px; height:1000px; ">
<%@ include file="publicMenu.jsp" %>
	<br/>
	<h3 >浏览北京工业大学机器人大赛赛事信息</h3>
	<p><span>欢迎各院学生踊跃报名参赛</span></p>
	<p><span>可以通过<a href="doPublicSelectSubject">[查看科目信息]</a>，了解已发布科目的规则、报名条件等相关介绍</span></p>
	<br/>
	<div style="text-align:left;">
	<div id="colee_left" style="overflow:hidden; width:520px; margin-left:176px; padding: 0px;">
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
			<td id="colee_left1" valign="top" align="center">
				<table cellpadding="2" cellspacing="0" border="0">
					<tr align="center">
						<td><p><img style=" border: solid;"  src="image/pic1.jpg" width="300px" height="188px"></p></td>
						<td><p><img style=" border: solid;"  src="image/pic2.jpg" width="300px" height="188px"></p></td>
						<td><p><img style=" border: solid;"  src="image/pic3.jpg" width="300px" height="188px"></p></td>
						<td><p><img style=" border: solid;"  src="image/pic4.jpg" width="300px" height="188px"></p></td>
						<td><p><img style=" border: solid;"  src="image/pic5.jpg" width="300px" height="188px"></p></td>
						<td><p><img style=" border: solid;"  src="image/pic6.jpg" width="300px" height="188px"></p></td>
					</tr>
				</table>
			</td>
			<td id="colee_left2" valign="top">
			</td>
		</tr>
		</table>
</div>
<p style="margin-left:382px;"><span>往届比赛图片展示</span></p>
<script>
//使用div时，请保证colee_left2与colee_left1是在同一行上.
var speed=30//速度数值越大速度越慢
var colee_left2=document.getElementById("colee_left2");
var colee_left1=document.getElementById("colee_left1");
var colee_left=document.getElementById("colee_left");
colee_left2.innerHTML=colee_left1.innerHTML
function Marquee3(){
if(colee_left2.offsetWidth-colee_left.scrollLeft<=0)//offsetWidth 是对象的可见宽度
colee_left.scrollLeft-=colee_left1.offsetWidth//scrollWidth 是对象的实际内容的宽，不包边线宽度
else{
colee_left.scrollLeft++
}
}
var MyMar3=setInterval(Marquee3,speed)
colee_left.onmouseover=function() {clearInterval(MyMar3)}
colee_left.onmouseout=function() {MyMar3=setInterval(Marquee3,speed)}
</script>
	
	
	
	</div>

</div>
</body>
</html>
